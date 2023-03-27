package Service;
import DAO.EmployeeDao;
import Model.Account;
import Model.Employees;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class EmployeeService {
    private final EmployeeDao employeeDAO = new EmployeeDao();
    private final List<Employees> employeeList = new ArrayList<>();
    private boolean flag = false;

    public void showEmployees() {
        System.out.println(employeeDAO.getAll());
    }

    // Thêm nhân viên
    public void option2(Scanner in) {
        Employees employees = new Employees();
        System.out.print("Nhập Họ Và Tên : ");
        employees.setFull_name(in.nextLine());
        System.out.print("Nhập Ngày sinh : ");
        employees.setBorn(in.nextLine());
        System.out.print("Nhập email : ");
        employees.setBorn(in.nextLine());
        System.out.print("Nhập Phone Number : ");
        employees.setPhone_number(in.nextLine());
        System.out.print("Nhập Address : ");
        employees.setAddress(in.nextLine());
        System.out.print("Nhập Salary : ");
        employees.setSalary(Double.parseDouble(in.nextLine()));
        System.out.print("Nhập Giới tính : ");
        ;
        employees.setGender(Integer.parseInt(in.nextLine()));
        System.out.print("Nhập Hire Date : ");
        employees.setHire_date(in.nextLine());
        System.out.print("Nhập vị trí : ");
        employees.setPosition(in.nextLine());
        System.out.print("Nhập Phòng ban : ");
        employees.setDepartment_id(Integer.parseInt(in.nextLine()));
        EmployeeDao.insert(employees);
    }

    //Sửa thông tin nhân viên
    public void option3(Scanner in) {
        Employees e = new Employees();
        System.out.println("Nhập ID bạn muốn sửa");
        long id = in.nextLong();
        System.out.print("Nhập Họ Và Tên : ");
        e.setFull_name(in.nextLine());
        System.out.print("Nhập Ngày sinh : ");
        e.setBorn(in.nextLine());
        System.out.print("Nhập email : ");
        e.setBorn(in.nextLine());
        System.out.print("Nhập Phone Number : ");
        e.setPhone_number(in.nextLine());
        System.out.print("Nhập Address : ");
        e.setAddress(in.nextLine());
        System.out.print("Nhập Salary : ");
        e.setSalary(Double.parseDouble(in.nextLine()));
        System.out.print("Nhập Giới tính : ");
        ;
        e.setGender(Integer.parseInt(in.nextLine()));
        System.out.print("Nhập Hire Date : ");
        e.setHire_date(in.nextLine());
        System.out.print("Nhập vị trí : ");
        e.setPosition(in.nextLine());
        System.out.print("Nhập Phòng ban : ");
        e.setDepartment_id(Integer.parseInt(in.nextLine()));
        EmployeeDao.update(e, id);

    }

    // Xóa nhân viên
    public void option4(Scanner in) {
        Employees s = new Employees();
        System.out.print("Nhập id nhân viên muốn xóa: ");
        int id = in.nextInt();
        EmployeeDao.delete(id);
    }

    public void option9(Scanner in) {
        System.out.println("Nhập id cần tìm:");
        int id = in.nextInt();
        checkId(id);
        System.out.println(employeeDAO.getById(id));
    }
    public void checkId ( int id){
        for (Employees userId : employeeList) {
            if (userId.getEmployee_id() == id) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("<!> Tài khoản không tồn tại <!>");
            return;
        }
    }
}
