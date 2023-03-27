import DAO.EmployeeDao;
import Interface.Interface;
import Model.Account;
import Model.Departments;
import Model.Employees;
import Service.AuthenService;
import Service.DepartmentService;
import Service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    static EmployeeDao employeeDAO = new EmployeeDao();
    static List<Employees> employeesList = new ArrayList<>();
    static List<Departments> departmentList = new ArrayList<>();
    static Employees employee = new Employees();
    static Departments departments = new Departments();
    static AuthenService authenService = new AuthenService();
    static EmployeeService employeeService = new EmployeeService();
    static DepartmentService departmentService = new DepartmentService();

    static  Interface ui = new Interface();

    static Scanner in = new Scanner(System.in);
    static int option = -1;

    // Main
    public static void main(String[] args) {
        checkLogin();
        handleMenu();
    }
    private static void checkLogin(){
        System.out.println("-----------------ĐĂNG NHẬP-----------------");
        int count = 3;
        boolean isLoginSuccess = false;
        while(count != 0){
            count = count - 1;
            // Dang nhap truoc
            if(!isLoginSuccess){
                System.out.print("- Username: ");
                String username = in.nextLine();
                System.out.print("- Password: ");
                String password = in.nextLine();
                // Kiem tra xem dang nhap dc ko?
                isLoginSuccess = authenService.login(username, password);
            }
            if(count != 0 && !isLoginSuccess){
                System.out.printf("Bạn còn %d lần nhập !\n", count);
            }
        }
        if(!isLoginSuccess){
            System.out.println("\n<!> Đăng nhập thất bại <!>");
            System.exit(0);
        }
        System.out.println("* Đăng nhập thành công *");
    }

    private static void handleEmployeesManager(){
        do {
            // Hiển thị menu nhân viên
            ui.showEmployeesMenu();
            // Nhập dữ liệu
            inputMenu(12);
            // Chọn menu
            switch (option) {
                case 1 -> employeeService.showEmployees();
                case 2 -> employeeService.option2(in);
                case 3 -> employeeService.option3(in);
                case 4 -> employeeService.option4(in);
                case 5 -> departmentService.showDepartment();
                case 6 -> departmentService.option6(in);
                case 7 -> departmentService.option7(in);
                case 8 -> departmentService.option8(in);
                case 9 -> employeeService.option9(in);
                case 11 -> employeeService.option11(in);
                case 12 -> handleMenu();
            }

        }
        while (option != 0);
        in.close();
    }

    private static void handleAccountsManager(){
        do {
            // Hiển thị menu tài khoản
            ui.showAccountMenu();
            // Nhập dữ liệu
            inputMenu(6);
            // Chọn menu
            switch (option) {
                case 1 -> authenService.showAllAccount();
                case 2 -> authenService.insertAccount();
                case 3 -> authenService.updateAccount();
                case 4 -> authenService.deleteAccount();
                case 5 -> authenService.findAccount();
                case 6 -> handleMenu();
            }
        }
        while (option != 0);
        in.close();
    }

    private static void handleMenu(){
        do {
            // Hiển thị menu chính
            ui.showMainMenu();
            // Nhập dữ liệu
            inputMenu(3);
            // Chọn menu
            switch (option) {
                case 1 -> handleAccountsManager();
                case 2 -> handleEmployeesManager();
                case 3 -> {
                    System.out.println("Đăng xuất thành công");
                    checkLogin();
                }
            }
        }
        while (option != 0);
        in.close();
    }

    private static void inputMenu(int max) {
        boolean isCheck = false;
        System.out.print("Nhập lựa chọn: ");
        try {
            option = Integer.parseInt(in.nextLine());
        } catch (Exception e) {
            System.out.println("<!> Nhập sai định dạng <!>");
            isCheck = true;
            //continue;
        }
        if (!isCheck) {
            if (option == 0) {
                System.out.println("<!> Thoát <!>");
            }else if (option > max){
                System.out.println("<!> Lựa chọn không hợp lệ <!>");
            }
            //continue;
        }
    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        System.out.println(" --- LOGIN--- ");
//        int count = 3;
//        /*while (count != 0){
//            count = count -1;
//            System.out.print("Nhap username: ");
//            String username = in.nextLine();
//            System.out.print("Nhap password: ");
//            String password = in.nextLine();
//            // verify
//            isLoginSuccess = authenService.login(username, password);
//            if(isLoginSuccess == true) {
//                break;
//            }
//            if(count==0){
//                continue;
//            }else {
//                System.out.printf("Bạn còn %d lần đăng nhập \n ", count);
//            }
//        }
//        if(isLoginSuccess == false){
//            System.out.println("Dang nhap that bai, bạn đã hết lượt");
//            System.exit(0);
//        }
//        else {
//            System.out.println("Đăng nhập thành công");
//        }*/
//        // Dang nhap thanh cong
//        int option = -1;
//
//        do {
//            showMenu();
//            System.out.print("Nhập lựa chọn: ");
//            option = Integer.parseInt(in.nextLine());
//            // Làm thêm phàn try-catch khi người dùng nhập lỗi
//            if (option < 1 || option > 10) {
//                System.out.println("Vui lòng nhập lại!");
//                continue;
//            }
//            switch (option) {
//                case 1:
//                    option1(in);
//                    break;
//                case 2:
//                    option2(in);
//                    break;
//                case 3:
//                    option3(in);
//                    break;
//                case 4:
//                    option4(in);
//                    break;
//                case 5:
//                    option5(in);
//                    break;
//                case 6:
//                    option6(in);
//                    break;
//                case 7:
//
//                    break;
//                case 8:
//
//                    break;
//                case 9:
//                    break;
//                case 10:
//                    break;
//            }
//
//        }
//        while (option != 0);
//
//        in.close();
//    }

}
