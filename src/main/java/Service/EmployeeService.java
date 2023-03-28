package Service;
import DAO.DepartmentDao;
import DAO.EmployeeDao;
import Model.Account;
import Model.Departments;
import Model.Employees;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import Verify.VerifyEmployees;
public class EmployeeService {
    private final EmployeeDao employeeDAO = new EmployeeDao();
    private Employees  employee = new Employees();
    private List<Employees> employeeList = new ArrayList<>();
    private DepartmentDao departmentDAO = new DepartmentDao();
    private final DepartmentService departmentService = new DepartmentService();
    private boolean flag = false;

    public void showEmployees() {
        employeeList = employeeDAO.getAll();
        String leftAlignFormat = "| %-12d | %-20s | %-11s  | %-12s  | %-18s  |  %-13s | %-19s | %-10f |%n";
        System.out.format("+--------------+----------------------+--------------+---------------+---------------------+----------------+---------------------+------------+%n");
        System.out.format("| Mã nhân viên |     Tên nhân viên    |  Giới tính   |   Ngày sinh   |       Địa chỉ       |  Số điện thoại |        Email        |    Lương   |%n");
        System.out.format("+--------------+----------------------+--------------+---------------+---------------------+----------------+---------------------+------------+%n");
        for (int i = 0; i < employeeList.size(); i++) {
            System.out.format(leftAlignFormat, employeeList.get(i).getEmployee_id(), employeeList.get(i).getFull_name(),
                    employeeList.get(i).getGender(), employeeList.get(i).getBorn(), employeeList.get(i).getAddress(),
                    employeeList.get(i).getPhone_number(), employeeList.get(i).getEmail(), employeeList.get(i).getSalary());
        }
        System.out.format("+--------------+----------------------+--------------+---------------+---------------------+----------------+---------------------+------------+%n");
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
    public void option11(Scanner in){
        System.out.print("\tNhập id cần tìm: ");
        int id = in.nextInt();
        if (!VerifyEmployees.isCheckIdEmp(id)){
            System.out.println("<!> Không tìm thấy nhân viên nào <!>");
            return;
        }

        String leftAlignFormat = "| %-12d | %-20s | %-15f |%n";
        System.out.format("+--------------+----------------------+-----------------+%n");
        System.out.format("| Mã nhân viên |     Tên nhân viên    |       Lương     |%n");
        System.out.format("+--------------+----------------------+-----------------+%n");
        Employees employee = employeeDAO.getById(id);
        System.out.format(leftAlignFormat, employee.getEmployee_id(),
                employee.getFull_name(),employeeDAO.getById(id).getSalary());
        System.out.format("+--------------+----------------------+-----------------+%n");

        DecimalFormat formatter = new DecimalFormat("###,###,###");

        System.out.print("\tNhập lương đóng bảo hiểm: ");
        int luongBh = in.nextInt();
        System.out.print("\tNhập số người phụ thuộc: ");
        int soNguoiPT = in.nextInt();

        //Mức đóng: BHXH (8%), BHYT (1.5%), BHTN (1%)
        //Bảo hiểm bắt buộc = luongBh x 8% + luongBh x 1.5% + luongBh x 1%
        double BHBB = (luongBh * 0.08) + (luongBh * 0.015) + (luongBh * 0.01);
        System.out.println("\t-Bảo hiểm bắt buộc = "+formatter.format(BHBB)+" VNĐ");

        // giảm trừ bản thân : 11000000
        int GTBT = 11000000;
        System.out.println("\t-Giảm trừ bản thân = "+formatter.format(GTBT)+" VNĐ");



        //Giảm trừ người phụ thuộc = soNguoiPT x 4,400,000 = mặc định
        int GTNPT = soNguoiPT * 4400000;
        System.out.println("\t-Giảm trừ người phụ thuộc = "+formatter.format(GTNPT)+" VNĐ");

        //Thu nhập tính thuế = lương - BHBB - GTBT - GTNPT;
        double luong = employeeDAO.getById(id).getSalary();
        double TNTT = luong - BHBB - GTBT - GTNPT;
        System.out.println("\t-Thu nhập tính thuế = "+formatter.format(TNTT)+" VNĐ");

        // Thuế thu nhập cá nhân phải nộp
        double TTNCN;
        if (luong <= 5000000 ){
            TTNCN = TNTT * 0.05;
        }else if (luong <= 10000000){
            TTNCN = (TNTT * 0.1) - 0.25;
        }else if (luong <= 18000000){
            TTNCN = (TNTT * 0.15) - 0.75;
        }else if (luong <= 32000000){
            TTNCN = (TNTT * 0.2) - 1.65;
        }else if (luong <= 52000000){
            TTNCN = (TNTT * 0.25) - 3.25;
        }else if (luong <= 80000000){
            TTNCN = (TNTT * 0.3) - 5.85;
        }else {
            TTNCN = (TNTT * 0.35) - 9.85;
        }
        if (luong > 0){
            System.out.println("\t-Thuế thu nhập cá nhân phải nộp = "+formatter.format(TTNCN)+" VNĐ");
        }else {
            System.out.println("\t-Thuế thu nhập cá nhân phải nộp = 0 VNĐ");
        }

    }
    public void option10(Scanner in){

        System.out.print("\tNhập id nhân viên: ");
        int employeeId = in.nextInt();
        if (!VerifyEmployees.isCheckIdEmp(employeeId)){
            System.out.println("<!> Không tìm thấy nhân viên nào <!>");
            return;
        }

        System.out.print("\tNhập tên công việc: ");
        String position = in.next();
        employee.setPosition(position);

        DepartmentService.showDepartment();

        System.out.print("\tNhập mã bộ phận muốn chuyển: ");
        int deparmentId = in.nextInt();

        if (!VerifyEmployees.isCheckIdDep(deparmentId)){
            System.out.println("<!> Không tìm thấy mã bộ phận nào <!>");
            return;
        }
        employee.setDepartment_id(deparmentId);

        // kiểm tra manager id cũ = employee id  thì set managerId cũ về null
        Departments departmentDepID = departmentDAO.getByDepartmentId(employeeId);
        if (departmentDepID.getManager_id() == employeeId){
            // update hủy quản lý
            departmentDAO.updateManager(0, departmentDepID.getDepartment_id());
        }
        // update
        employeeDAO.updateDepartment(employee, employeeId);
        System.out.println("* Chuyển bộ phận thành công *");

        // kiểm tra managerid =  null -> set nhân viên lên làm quản lý
        if (!VerifyEmployees.isCheckManagement(employeeId, deparmentId)){
            // update lên quản lý
            departmentDAO.updateManager(employeeId, deparmentId);
            System.out.println("* Nhân viên này được xét lên quản lý *");
        }

    }

    public void deleteEmployeeFromDepartment(Scanner in){
        System.out.print("\tNhập id nhân viên cần đuổi: ");
        int employeeId = in.nextInt();
        if (!VerifyEmployees.isCheckIdEmp(employeeId)){
            System.out.println("<!> Không tìm thấy nhân viên nào <!>");
            return;
        }

        Departments departmentDepID = departmentDAO.getByDepartmentId(employeeId);
        if (departmentDepID.getManager_id() == employeeId){
            // update hủy quản lý
            departmentDAO.updateManager(0, departmentDepID.getDepartment_id());
            System.out.println("* Nhân viên này không còn là quản lý *");
        }

        employeeDAO.deleteEmpFromDep(employeeId);
        System.out.println("* Xóa khỏi bộ phận thành công *");
    }
}
