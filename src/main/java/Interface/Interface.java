package Interface;

public class Interface {
    public void showMainMenu(){
        System.out.println("----- M E N U -----");
        System.out.println("1. Account Management");
        System.out.println("2. Employee Management");
        System.out.println("3. Log out");
        System.out.println("0. Exit");
    }
    public void showAccountMenu(){
        System.out.println("----Account Management ----");
        System.out.println("1. New accounts list");
        System.out.println("2. Creat new account");
        System.out.println("3. Update information account");
        System.out.println("4. Delete account");
        System.out.println("5. Search account");
        System.out.println("6. Back");
        System.out.println("0. Exit");
    }
    public void showEmployeesMenu() {
        System.out.println("----Employee Management----");
        System.out.println("1. Employees List");
        System.out.println("2. Creat new account");
        System.out.println("3. Update Employee");
        System.out.println("4. Delete Employee");
        System.out.println("5. Departments List");
        System.out.println("6. Create new Department");
        System.out.println("7. Update Department");
        System.out.println("8. Delete Department");
        System.out.println("9. Search Employee");
        System.out.println("10. Transfer Department to Employee");
        System.out.println("11. Personal Income Tax");
        System.out.println("12. Back");
        System.out.println("0. Exit");
    }
}
