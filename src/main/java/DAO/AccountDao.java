package DAO;

import Connection.MyConnection;
import Model.Account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {
    // Dinh nghia: xem, them, sua, xoa

    public Account getById(long id) {
        Account account = null;
        try {
            // Tao ket noi
            Connection conn = MyConnection.getConnection();
            // Chuan bi cau lenh, thuc thi
            String sql = "SELECT * FROM `accounts` WHERE `id` = " + id + " LIMIT 1";
            Statement stmt = conn.createStatement();

            // Ket qua
            ResultSet resultSet = stmt.executeQuery(sql);

            if (resultSet.next()) {
                account = new Account();
                account.setId(resultSet.getLong("id"));
                account.setUsername(resultSet.getString("user"));
            }
            // Dong tai nguyen
            resultSet.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }

    public Account getByUserNameAndPassword(String username, String password) {
        Account account = null;
        try {
            Connection conn = MyConnection.getConnection();
            String sql = String.format("SELECT id, user FROM accounts WHERE user='%s' AND password='%s' LIMIT 1 ",
                    username, password);

            // THUC THI
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            if (resultSet.next()) {
                account = new Account();
                account.setId(resultSet.getLong("id"));
                account.setUsername(resultSet.getString("user"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return account;
    }

    // Co the lam them phan sua xoa nhe....
    public List<Account> getAll() {

        List<Account> accountList = new ArrayList<>();
        try {
            Connection conn = MyConnection.getConnection();
            String sql = "SELECT * FROM accounts ";

            // THUC THI
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                Account account = new Account();
                account.setId(resultSet.getInt("id"));
                account.setUsername(resultSet.getString("user"));
                account.setPassword(resultSet.getString("password"));
                accountList.add(account);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return accountList;
    }


    public void insert(Account a) {
        final String sql = String.format("INSERT  INTO `accounts` VALUES ( NULL,'%s','%s' ) ",
                a.getUsername(), a.getPassword()
        );
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Thêm thất bại");
            }

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Account a, int id) {
        Account tmp = getById(id);
        if (tmp == null) {
            throw new RuntimeException("Tài khoản không tồn tại!");
        }

        final String sql = String.format("UPDATE `accounts` SET `user`='%s',`password`='%s' WHERE `id` = '%d'",
                a.getUsername(), a.getPassword(), id
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


    public void delete(int id) {
        Account a = getById(id);
        if (a == null) {
            throw new RuntimeException("Tài khoản không tồn tại!");
        }

        final String sql = "DELETE FROM `accounts` WHERE  `id` = " + id;
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Xoá thất bại");
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
