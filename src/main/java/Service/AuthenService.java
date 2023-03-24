package Service;

import DAO.AccountDao;
import Model.Account;

public class AuthenService {
    private static AccountDao accountDAO = new AccountDao();

    // Service ve viec dang nhap

    public boolean login(String userName, String password) {
        Account account = accountDAO.getByUserNameAndPassword(userName, password);
        if(account == null){
            return false;
        }
        // Dang nhap thanh cong
        return true;
    }
    public static void showAllAccount(){
        System.out.println(accountDAO.getAll());
    }

    public void insertAccount(Account account){
        accountDAO.insert(account);
    }

    public void updateAccount(Account account, int id){
        accountDAO.update(account, id);
    }

    public void deleteAccount(int id){
        accountDAO.delete(id);
    }
}
