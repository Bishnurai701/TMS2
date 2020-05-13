package com.tms.dao;

import com.tms.db.DBConnection;
import com.tms.model.UserRoll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRollDAO {
    private static final String INSERT_USERROLL_SQL="INSERT INTO tbl_userroll"+"(UserRollName,CreatedBy,ModifiedBy,CreatedDate,ModifiedDate) VALUES"+"(?,?,?,?,?);";
    private static final String SELECT_USERROLL_BY_ID="select UserRoll_id,UserRollName from tbl_userroll where UserRoll_id=?";
    private static final String SELECT_ALL_USERROLLS="select *from tbl_userroll";
    private static final String DELETE_USERROLL_SQL="delete from tbl_userroll where UserRoll_id=?;";
    private static final String UPDATE_USERROLL_SQL="update tbl_userroll set UserRollName=? where UserRoll_id=?;";

    public UserRollDAO(){}
    public boolean insertUserRoll(UserRoll ur) throws SQLException {
        boolean statusUR=false;
        try(
                //Connection conn=getConnection();
            Connection conn= DBConnection.createConnection();
            PreparedStatement ps=conn.prepareStatement(INSERT_USERROLL_SQL)){
            ps.setString(1,ur.getUserRollName());
            ps.setString(2,ur.getCreatedBy());
            ps.setString(3,ur.getModifiedBy());
            ps.setDate(4, (Date) ur.getCreatedDate());
            ps.setDate(5, (Date) ur.getModifiedDate());
            statusUR=ps.executeUpdate()>0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return statusUR;
    }

}
