package org.chintanpatel.app.dao;

import org.chintanpatel.app.bean.User;
import org.chintanpatel.app.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public boolean registerUser(User user) {
        boolean flag = false;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("insert into tbl_user(first_name, " +
                     "last_name, email, mobile, user_name, password) values (?,?,?,?,?,?)"))
        {
                pstmt.setString(1, user.getFirstName());
                pstmt.setString(2, user.getLastName());
                pstmt.setString(3, user.getEmail());
                pstmt.setLong(4,user.getMobile());
                pstmt.setString(5, user.getUserName());
                pstmt.setString(6, user.getPassword());
                int noOfRecordsAffected = pstmt.executeUpdate();
                    if (noOfRecordsAffected > 0) {
                        flag = true;
                    }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }


    public boolean isAuthenticateUser(User user) {
        boolean flag = false;
        try (Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("select * from tbl_user where " +
                "user_name=? and password=?"))
        {
                pstmt.setString(1, user.getUserName());
                pstmt.setString(2, user.getPassword());
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    flag = true;
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
