package com.tms.dao;

import com.mysql.cj.Session;
import com.tms.db.DBConnection;
import com.tms.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*this DAO class provides CRUD database operators for the table users in the database(uselegacyDatetimeCode=false)*/
public class UserDAO {
    //private String jdbcURL="jdbc:mysql://localhost:3309/db_tms?uselegacyDatetimeCode=false&serverTimezone=UTC";
    //private String jdbcUsername="admin";
    //private String jdbcPassword="admin";

    private static final String INSERT_USERS_SQL="INSERT INTO tbl_user"+"(UserName,UserLoginName,Password,UserGroup_id,QRAndThump_id,Registration_id,CreatedBy,ModifiedBy,CreatedDate,ModifiedDate) VALUES"+"(?,?,?,?,?,?,?,?,?,?);";
    private static final String SELECT_USER_BY_ID="select user_id,UserName,UserLoginName,Password from tbl_User where User_id=?";
    private static final String SELECT_ALL_USERS="select *from tbl_user";
    private static final String DELETE_USERS_SQL="delete from tbl_user where User_id=?;";
    private static final String UPDATE_USERS_SQL="update tbl_user set UserName=?,UserLoginName=?,Password=?,UserGroup_id=?,QRAndThump_id=?,Registration_id=? where User_id=?;";

    public UserDAO(){}

    /*Database Connection method*/
/*
    protected Connection getConnection()throws SQLException{
        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3309/db_tms?uselegacyDatetimeCode=false&serverTimezone=UTC","admin","admin");
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return conn;
    }

*/

    /*Create or Insert User*/
    public boolean insertUser(User u)throws SQLException{
        boolean status=false;
        try(
            //Connection conn=getConnection();
           Connection conn= DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(INSERT_USERS_SQL)){
            ps.setString(1,u.getUserName());
            ps.setString(2,u.getUserLoginName());
            ps.setString(3,u.getPassword());
            ps.setInt(4,u.getUserGroup_id());
            ps.setInt(5,u.getQRAndThump_id());
            ps.setInt(6,u.getRegistration_id());
            ps.setString(7,u.getCreatedBy());
            ps.setString(8,u.getModifiedBy());
            ps.setDate(9, (Date) u.getCreatedDate());
            ps.setDate(10, (Date) u.getModifiedDate());
            status=ps.executeUpdate()>0;

        }catch (SQLException e){
           e.printStackTrace();
        }

        return status;
    }

    /*Update User*/
    public boolean updateUser(User u)throws SQLException{
        boolean rowUpdated;
        try(
           //Connection conn=getConnection();
           Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(UPDATE_USERS_SQL);){
            ps.setString(1,u.getUserName());
            ps.setString(2,u.getUserLoginName());
            ps.setString(3,u.getPassword());
            ps.setInt(4,u.getUserGroup_id());
            ps.setInt(5,u.getQRAndThump_id());
            ps.setInt(6,u.getRegistration_id());
            ps.setInt(7,u.getUser_id());
            rowUpdated=ps.executeUpdate()>0;
        }
        return rowUpdated;
    }


    /*Select User By id*/
    public User selectUserId(int User_id) throws SQLException {
        User u=null;
        try(
            //Connection conn=getConnection();                                /*Step 1: establishing a connection*/
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(SELECT_USER_BY_ID);){    /*Step 2: Create a statement using connection object*/
            ps.setInt(1,User_id);
            System.out.println(ps);
            ResultSet rs=ps.executeQuery();                                 /*Step 3: Execute the query or update query*/
            while (rs.next()){                                              /*Step 4 process the result set object*/
                String UserName=rs.getString("UserName");
                String UserLoginName=rs.getString("UserLoginName");
                String Password=rs.getString("Password");
                int UserGroup_id=rs.getInt("UserGroup_id");
                int QRAndThump_id=rs.getInt("QRAndThump_id");
                int Registration_id=rs.getInt("Registration_id");
                String CreatedBy=rs.getString("CreatedBy");
                String ModifiedBy=rs.getString("ModifiedBy");
                Date CreatedDate=rs.getDate("CreatedDate");
                Date ModifiedDate=rs.getDate("ModifiedDate");
                u=new User(User_id,UserName,UserLoginName,Password,UserGroup_id,QRAndThump_id,Registration_id,CreatedBy,ModifiedBy,CreatedDate,ModifiedDate);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return u;
    }



    /*Select All Users*/
        public List<User> selectAllUsers() throws SQLException {
        List<User> users=new ArrayList<User>();
        try(
            //Connection conn=getConnection();                                    /*Step 1: establishing a connection*/
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(SELECT_ALL_USERS)){     /*Step 2: Create a statement using connection object*/
            System.out.println(ps);
            ResultSet rs=ps.executeQuery();                                     /*Step 3: Execute the query or update query*/
            while (rs.next()){                                                  /*Step 4 process the result set object*/
                int User_id=rs.getInt("User_id");
                String UserName=rs.getString("UserName");
                String UserLoginName=rs.getString("UserLoginName");
                String Password=rs.getString("Password");
                int UserGroup_id=rs.getInt("UserGroup_id");
                int QRAndThump_id=rs.getInt("QRAndThump_id");
                int Registration_id=rs.getInt("Registration_id");
                String CreatedBy=rs.getString("CreatedBy");
                String ModifiedBy=rs.getString("ModifiedBy");
                Date CreatedDate=rs.getDate("CreatedDate");
                Date ModifiedDate=rs.getDate("ModifiedDate");
                users.add(new User(User_id,UserName,UserLoginName,Password,UserGroup_id,QRAndThump_id,Registration_id,CreatedBy,ModifiedBy,CreatedDate,ModifiedDate));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
       return users;
    }

    /*Delete User*/
    public boolean deleteUser(int User_id)throws SQLException{
        boolean rowDeleted;
        try(
            //Connection conn=getConnection();
            Connection conn=DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(DELETE_USERS_SQL);){
           ps.setInt(1,User_id);
            rowDeleted=ps.executeUpdate()>0;
        }
        return rowDeleted;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }


}
