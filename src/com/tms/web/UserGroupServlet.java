package com.tms.web;

import com.tms.dao.UserGroupDAO;
import com.tms.db.DBConnection;
import com.tms.model.UserGroup;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="UserGroupServlet",urlPatterns = {("/listgroup"),("/newgroup"),("/insertgroup"),("/deletegroup"),("/editgroup"),("/updategroup")}) /* {("/listgroup"),("/newgroup"),("/insertgroup"),("/deletegroup"),("/editgroup"),("/updategroup")}*/
public class UserGroupServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    private UserGroupDAO userGroupDAO;

    public void init(){
        this.userGroupDAO=new UserGroupDAO();

    }
    public void init1(){
        String jdbcURL=getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername=getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword=getServletContext().getInitParameter("jdbcPassword");
        DBConnection dbConnection = new DBConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getServletPath();
        switch (action){
            case "/newgroup":
                showNewFormUserGroup(request,response);
                break;
            case"/insertgroup":
                try {
                    insertUserGroup(request,response);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "/deletegroup":
                try {
                    deleteUserGroup(request,response);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                break;
            case "/editgroup":
                try {
                    showEditFormUserGroup(request,response);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                break;
            case "/updategroup":
                try {
                    updateUserGroup(request,response);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                break;
            default:
                try {
                    listUserGroup(request,response);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                break;
        }

    }


    private void showNewFormUserGroup(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        RequestDispatcher dispatcher=request.getRequestDispatcher("/usergroupform.jsp");
        dispatcher.forward(request,response);
    }


    private void insertUserGroup(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ParseException {
        String UserGroupName=request.getParameter("UserGroupName");
       // int UserAuthentication_id=Integer.parseInt("UserAuthentication_id");
        String CreatedBy=request.getParameter("CreatedBy");
        String ModifiedBy=request.getParameter("ModifiedBy");
        Date CreatedDate=Date.valueOf(request.getParameter("CreatedDate"));
        Date ModifiedDate=Date.valueOf(request.getParameter("ModifiedDate"));
        UserGroup newUserGroup=new UserGroup(UserGroupName,CreatedBy,ModifiedBy,CreatedDate,ModifiedDate);
        userGroupDAO.insertUserGroup(newUserGroup);
        response.sendRedirect("listgroup");
    }

    private void deleteUserGroup(HttpServletRequest request,HttpServletResponse response) throws SQLException,IOException{
        int UserGroup_id=Integer.parseInt(request.getParameter("UserGroup_id"));
        userGroupDAO.deleteUserGroup(UserGroup_id);
        response.sendRedirect("listgroup");
    }

    private void showEditFormUserGroup(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException {
        int UserGroup_id=Integer.parseInt(request.getParameter("UserGroup_id"));
        UserGroup existingUserGroup= userGroupDAO.selectUserGroupId(UserGroup_id);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/usergroupform.jsp");
        request.setAttribute("userGroup",existingUserGroup);
        dispatcher.forward(request,response);

    }

    private void updateUserGroup(HttpServletRequest request,HttpServletResponse response)throws SQLException,IOException{
        int UserGroup_id=Integer.parseInt(request.getParameter("UserGroup_id"));
        String UserGroupName=request.getParameter("UserGroupName");
       // int UserAuthentication_id=Integer.parseInt(request.getParameter("UserAuthentication_id"));
        String CreatedBy=request.getParameter("CreatedBy");
        String ModifiedBy=request.getParameter("ModifiedBy");
        Date CreatedDate=Date.valueOf(request.getParameter("CreatedDate"));
        Date ModifiedDate=Date.valueOf(request.getParameter("ModifiedDate"));
        UserGroup userGroup=new UserGroup(UserGroup_id,UserGroupName,CreatedBy,ModifiedBy,CreatedDate,ModifiedDate);
        userGroupDAO.updateUserGroup(userGroup);
        response.sendRedirect("listgroup");
    }

    private void listUserGroup(HttpServletRequest request,HttpServletResponse response)throws SQLException,IOException,ServletException{
        List<UserGroup> userGroup=new ArrayList<UserGroup>();
        userGroup=userGroupDAO.selectAllUsersGroup();
        request.setAttribute("listUserGroup",userGroup);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/usergrouplist.jsp");
        dispatcher.forward(request,response);
    }


}
