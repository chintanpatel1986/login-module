package org.chintanpatel.app.dao;

import org.chintanpatel.app.bean.User;
import org.chintanpatel.app.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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


    public List<User>getAllUserList() {
        List<User>userList = new ArrayList<>();
        User user;
        try (Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("select * from tbl_user");
        ResultSet rs = pstmt.executeQuery())
        {
                if (rs != null) {
                    while (rs.next()) {
                        user = new User();
                        user.setUserId(rs.getInt("user_id"));
                        user.setFirstName(rs.getString("first_name"));
                        user.setLastName(rs.getString("last_name"));
                        user.setEmail(rs.getString("email"));
                        user.setMobile(rs.getLong("mobile"));
                        user.setUserName(rs.getString("user_name"));
                        user.setPassword(rs.getString("password"));
                        userList.add(user);
                    }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }


    public User findUserByUserName(String userName) {
        User user = null;
        ResultSet rs = null;
        try (Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("select * from tbl_user where user_name=?"))
        {
            pstmt.setString(1,userName);
            rs = pstmt.executeQuery();
                if (rs != null) {
                    if (rs.next()) {
                        user = new User();
                        user.setUserId(rs.getInt("user_id"));
                        user.setFirstName(rs.getString("first_name"));
                        user.setLastName(rs.getString("last_name"));
                        user.setEmail(rs.getString("email"));
                        user.setMobile(rs.getLong("mobile"));
                        user.setUserName(rs.getString("user_name"));
                        user.setPassword(rs.getString("password"));
                    }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return user;
    }


    public boolean editUserProfile(User user) {
        boolean flag = false;
        try (Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("update tbl_user set first_name=?, " +
                "last_name=?, email=?, mobile=?, user_name=?, password=? where user_id=?"))
        {
                pstmt.setString(1, user.getFirstName());
                pstmt.setString(2, user.getLastName());
                pstmt.setString(3, user.getEmail());
                pstmt.setLong(4,user.getMobile());
                pstmt.setString(5, user.getUserName());
                pstmt.setString(6, user.getPassword());
                pstmt.setInt(7,user.getUserId());
                int noOfRecordsAffected = pstmt.executeUpdate();
                    if (noOfRecordsAffected > 0) {
                        flag = true;
                    }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }


    public boolean deleteUserById(int userId) {
        boolean flag = false;
        try (Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("delete from tbl_user where user_id=?"))
        {
                pstmt.setInt(1,userId);
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
