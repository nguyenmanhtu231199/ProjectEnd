package Service;

import DAO.AccountDao;
import Model.Account;

public class AuthenService {
    private AccountDao accountDAO = new AccountDao();

    // Service ve viec dang nhap

    public boolean login(String userName, String password) {
        Account account = accountDAO.getByUserNameAndPassword(userName, password);
        if(account == null){
            return false;
        }
        // Dang nhap thanh cong
        return true;
    }
}
