import DAO.AccountDao;
import Service.AuthenService;

import java.util.Scanner;

public class Application {
    private static boolean isLoginSuccess = false;

    // Khai bao service
    private static AuthenService authenService = new AuthenService();

    private static void showMenu(){
        System.out.println("---QUAN LY NHAN SU---");
        System.out.println("1. ");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" --- LOGIN--- ");
        int count = 3;
        while (count != 0){
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
        }
        // Dang nhap thanh cong
        showMenu();

        in.close();
    }
}
