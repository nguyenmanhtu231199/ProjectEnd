package Service;

import DAO.DepartmentDao;
import DAO.EmployeeDao;
import Model.Departments;

import java.util.Scanner;

public class DepartmentService {
    private final DepartmentDao departmentDao = new DepartmentDao();
    //private final List<Employee>  employeeList = new ArrayList<>();
    public void showDepartment(){
        System.out.println(departmentDao.getAll());
    }
    // Thêm phòng ban
    public void option6(Scanner in){
        Departments departments = new Departments();
        System.out.println("Nhập Tên Phòng :");
        departments.setDepartment_name(in.nextLine());
        DepartmentDao.insert(departments);
    }
    // Sửa thong tin phòng ban
    public void option7(Scanner in){
        Departments d = new Departments();
        System.out.println("Nhập id phòng ban bạn muốn sửa:");
        long id = in.nextLong();
//        System.out.println("Nhập tên phòng:");
//        d.setDepartment_name(in.nextLine());
//        System.out.println("Nhập trưởng phòng");
//        int managerID = in.nextInt();
//        d.setManager_id(managerID);
        DepartmentDao.update(d,id);
    }
    // delete phòng
    public void option8(Scanner in){
        Departments d = new Departments();
        System.out.println("Nhập id phòng muốn xóa");
        int id = in.nextInt();
        DepartmentDao.delete(id);
    }
}
