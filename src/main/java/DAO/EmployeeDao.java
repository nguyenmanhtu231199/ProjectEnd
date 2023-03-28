package DAO;

import Model.Employees;
import Connection.MyConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    public List<Employees> getAll() {
        List<Employees> employeesList = new ArrayList<>();
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "SELECT * FROM employees";
            Statement stmt = conn.createStatement();
            ResultSet rs= stmt.executeQuery(sql);
            while (rs.next()){
                Employees e = new Employees();
                e.setEmployee_id(rs.getInt("Employee_ID"));
                e.setFull_name(rs.getString("Full_name"));
                e.setBorn(rs.getString("born"));
                e.setEmail(rs.getString("email"));
                e.setPhone_number(rs.getString("phone_number"));
                e.setAddress(rs.getString("address"));
                e.setSalary(rs.getDouble("salary"));
                e.setGender(rs.getInt("gender"));
                e.setHire_date(rs.getString("Hire_Date"));
                e.setPosition(rs.getString("position"));
                e.setDepartment_id(rs.getInt("Department_ID"));
                employeesList.add(e);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeesList;
    }
    public static void insert(Employees e){
        final String sql = String.format("INSERT INTO employees VALUES (NULL, '%s', '%s', '%s', '%s','%s', '%f', '%d', '%s', '%s', '%d')",
                e.getFull_name(),e.getBorn(),e.getEmail(),
                e.getPhone_number(),e.getAddress(),e.getSalary(),e.getGender(),e.getHire_date(),
                e.getPosition(),e.getDepartment_id());
        try {
            Connection conn= MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(sql);
            if(rs ==0){
                System.out.println("Error");
            }
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static Employees getById(long id) {
        final String sql = "SELECT * FROM `employees` WHERE  `Employee_ID` = " + id;
        Employees e = null;

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                e = new Employees();
                e.setEmployee_id(rs.getInt("Employee_ID"));
                e.setFull_name(rs.getString("Full_name"));
                e.setBorn(rs.getString("born"));
                e.setEmail(rs.getString("email"));
                e.setPhone_number(rs.getString("phone_number"));
                e.setAddress(rs.getString("address"));
                e.setSalary(rs.getDouble("salary"));
                e.setGender(rs.getInt("gender"));
                e.setHire_date(rs.getString("Hire_Date"));
                e.setPosition(rs.getString("position"));
                e.setDepartment_id(rs.getInt("Department_ID"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return e;
    }
    public static void update(Employees employees, long id) {
        Employees tmp = getById(id);
        if (tmp == null) {
            throw new RuntimeException("ERROR");
        }

        final String sql = String.format("UPDATE `employees` SET `Employees`='%d',`Full_name`='%s',`born`='%s'," +
                        "`email`='%s',`Phone_number`='%S',`Address`='%s',`Salary`='%f',`Gender`='%d',`Hire_Date`='%s'," +
                        "`Position`='%s',`Departmet_ID`='%d' WHERE `id` = '%d'",
                employees.getEmployee_id(), employees.getFull_name(), employees.getBorn(), employees.getEmail(),
                employees.getPhone_number(), employees.getAddress(),employees.getSalary(), employees.getGender(),
                employees.getHire_date(), employees.getPosition(), employees.getDepartment_id(),id
        );
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
    public static void delete(int id){
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "DELETE FROM products WHERE id = " +id;
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);
            if (rs == 0){
                System.out.println("Delete fail");
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateDepartment(Employees e, int id) {
        Employees tmp = getById(id);
        if (tmp == null) {
            throw new RuntimeException("Nhân viên không tồn tại!");
        }
        final String sql = String.format("UPDATE employees SET " +
                "`Position`= '%s', " +
                "`Department_ID`= '%d' " +
                " WHERE `EmployeeID` = "+id+"", e.getPosition(), e.getDepartment_id());
        try {

            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();

            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Cập nhật thất bại");
            }

            stmt.close();
            conn.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void deleteEmpFromDep(int id) {
        Employees tmp = getById(id);
        if (tmp == null) {
            throw new RuntimeException("Nhân viên không tồn tại!");
        }
        final String sql = "UPDATE employees SET " +
                "`Position`= NULL, " +
                "`DepartmentID`= NULL " +
                " WHERE `EmployeeID` = "+id+"";
        try {

            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();

            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Cập nhật thất bại");
            }

            stmt.close();
            conn.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}
