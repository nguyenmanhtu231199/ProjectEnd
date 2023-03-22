import DAO.AccountDao;
import DAO.DepartmentDao;
import DAO.EmployeeDao;
import Model.Departments;
import Model.Employees;
import Service.AuthenService;

import java.util.List;
import java.util.Scanner;

public class Application {
    private static boolean isLoginSuccess = false;

    // Khai bao service
    private static AuthenService authenService = new AuthenService();

    private static void showMenu(){
        System.out.println("---QUAN LY NHAN SU---");
        System.out.println("1. Thêm Nhân Viên");
        System.out.println("2. Sửa thông tin nhân viên");
        System.out.println("3. Xóa nhân viên");
        System.out.println("4. Thêm phòng ban");
        System.out.println("5. Sửa thông tin phòng ban");
        System.out.println("6. Xóa phòng ban");
        System.out.println("7. Tìm kiếm nhân viên");
        System.out.println("8. Thêm/xóa nhân viên vào phong ban");
        System.out.println("9. Chuyển phòng ban cho nhân viên");
        System.out.println("10. Tính thuế thu nhập cá nhân cho nhân viên");
    }
    // Thêm nhân viên
    private static void option1(Scanner in){
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
        System.out.print("Nhập Giới tính : ");;
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
    private static void  option2(Scanner in){
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
        System.out.print("Nhập Giới tính : ");;
        e.setGender(Integer.parseInt(in.nextLine()));
        System.out.print("Nhập Hire Date : ");
        e.setHire_date(in.nextLine());
        System.out.print("Nhập vị trí : ");
        e.setPosition(in.nextLine());
        System.out.print("Nhập Phòng ban : ");
        e.setDepartment_id(Integer.parseInt(in.nextLine()));
        EmployeeDao.update(e,id);

    }
    // Xóa nhân viên
    private static void option3(Scanner in) {
        Employees s = new Employees();
        System.out.print("Nhập id nhân viên muốn xóa: ");
        int id = in.nextInt();
        EmployeeDao.delete(id);
    }
    // Thêm phòng ban
    private static void option4(Scanner in){
        Departments departments = new Departments();
        System.out.println("Nhập Tên Phòng :");
        departments.setDepartment_name(in.nextLine());
        DepartmentDao.insert(departments);
    }
    // Sửa thong tin phòng ban
    private static void option5(Scanner in){
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
    private static void option6(Scanner in){
        Departments d = new Departments();
        System.out.println("Nhập id phòng muốn xóa");
        int id = in.nextInt();
        DepartmentDao.delete(id);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" --- LOGIN--- ");
        int count = 3;
        /*while (count != 0){
            count = count -1;
            System.out.print("Nhap username: ");
            String username = in.nextLine();
            System.out.print("Nhap password: ");
            String password = in.nextLine();
            // verify
            isLoginSuccess = authenService.login(username, password);
            if(isLoginSuccess == true) {
                break;
            }
            if(count==0){
                continue;
            }else {
                System.out.printf("Bạn còn %d lần đăng nhập \n ", count);
            }
        }
        if(isLoginSuccess == false){
            System.out.println("Dang nhap that bai, bạn đã hết lượt");
            System.exit(0);
        }
        else {
            System.out.println("Đăng nhập thành công");
        }*/
        // Dang nhap thanh cong
        int option = -1;

        do {
            showMenu();
            System.out.print("Nhập lựa chọn: ");
            option = Integer.parseInt(in.nextLine());
            // Làm thêm phàn try-catch khi người dùng nhập lỗi
            if (option < 1 || option > 10) {
                System.out.println("Vui lòng nhập lại!");
                continue;
            }
            switch (option) {
                case 1:
                    option1(in);
                    break;
                case 2:
                    option2(in);
                    break;
                case 3:
                    option3(in);
                    break;
                case 4:
                    option4(in);
                    break;
                case 5:
                    option5(in);
                    break;
                case 6:
                    option6(in);
                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:
                    break;
                case 10:
                    break;
            }

        }
        while (option != 0);

        in.close();
    }

}
