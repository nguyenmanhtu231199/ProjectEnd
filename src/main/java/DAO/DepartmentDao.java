package DAO;

import Connection.MyConnection;
import Model.Departments;
import Model.Employees;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao {
    public static List<Departments> getAll() {
        final String sql = "SELECT * FROM `departments`";

        List<Departments> brandList = new ArrayList<>();

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Departments b = new Departments();
                b.setDepartment_id(rs.getInt("Department_ID"));
                b.setDepartment_name(rs.getString("Department_Name"));
                b.setManager_id(rs.getInt("Manager_ID"));
                brandList.add(b);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return brandList;
    }
    public static Departments getById(long id) {
        final String sql = "SELECT * FROM `departments` WHERE  `id` = " + id;
        Departments d = null;

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                d = new Departments();
                d.setDepartment_id(rs.getInt("Department_ID"));
                d.setDepartment_name(rs.getString("Department_Name"));
                d.setManager_id(rs.getInt("Manager_ID"));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }
    public List<Departments> getAllEmployeeByDepartment(long Department_ID) {
        Departments d = getById(Department_ID);
        if (d == null) {
            throw new RuntimeException("Hãng không tồn tại!");
        }
        // SQL
        final String sql = "SELECT * FROM `employees` WHERE `Department_Name` = " + Department_ID;

        List<Departments> departmentsList = new ArrayList<>();
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Departments p = new Departments();
                d.setDepartment_id(rs.getInt("Department_ID"));
                d.setDepartment_name(rs.getString("Department_Name"));
                d.setManager_id(rs.getInt("Manager_ID"));
                departmentsList.add(d);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return departmentsList;
    }
    public static void insert(Departments departments) {
        final String sql = String.format("INSERT INTO `departments` VALUES (NULL,'%s',NUll)",
                departments.getDepartment_name());
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Thêm thất bại");
            }

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update(Departments departments, long id) {
        //kiem tra phong ban co ton tai hay k
        Departments d = getById(id);
        // neu phong ban co ton tai
            // thi lay ra tat ca nhan vien thuoc phong ban day
            // nguoi dung nhap stt nhan vien bo nhiem lam quan ly
            //
        if (d == null) {
            throw new RuntimeException("ERROR! Phòng không tồn tại");
        }
        final String sql = "SELECT * FROM `employees` WHERE `Department_Name` = " + id;
        List<Employees> employeesList = new ArrayList<>();

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Cập nhật thất bại");
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void delete(long id) {
        final String sql = "DELETE FROM `departments` WHERE `id` = " + id;
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Xoá thất bại");
            }

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
