package com.tms.web;

import com.tms.dao.UserDAO;
import com.tms.model.User;
import com.tms.db.DBConnection;

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

@WebServlet(name="UserServlet",urlPatterns = {("/list"),("/new"),("/insert"),("/delete"),("/edit"),("/update")})  /*{("/list"),("/new"),("/insert"),("/delete"),("/edit"),("/update")}*/
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    private UserDAO userDAO;
    private DBConnection dbConnection;

    public void init(){
        this.userDAO=new UserDAO();
    }
    public void init1(){
        String jdbcURL=getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername=getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword=getServletContext().getInitParameter("jdbcPassword");
        dbConnection=new DBConnection(jdbcURL,jdbcUsername,jdbcPassword);
    }
    


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action=request.getServletPath();
        switch (action){
            case "/new":
                showNewForm(request,response);
                break;
            case "/insert":
                try {
                    insertUser(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "/delete":
                try {
                    deleteUser(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/edit":
                try {
                    showEditForm(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/update":
                try {
                    updateUser(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    listUser(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void showNewForm(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        RequestDispatcher dispatcher=request.getRequestDispatcher("/userform.jsp");
        dispatcher.forward(request,response);
    }





    private void insertUser(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ParseException {
        String UserName=request.getParameter("UserName");
        String UserLoginName=request.getParameter("UserLoginName");
        String Password=request.getParameter("Password");
        int UserGroup_id=Integer.parseInt("UserGroup_id");
        int QRAndThump_id=Integer.parseInt("QRAndThump_id");
        int Registration_id=Integer.parseInt("Registration_id");
        String CreatedBy=request.getParameter("CreatedBy");
        String ModifiedBy=request.getParameter("ModifiedBy");
        Date CreatedDate=Date.valueOf(request.getParameter("CreatedDate"));
        Date ModifiedDate=Date.valueOf(request.getParameter("ModifiedDate"));
        User newUser=new User(UserName,UserLoginName,Password,UserGroup_id,QRAndThump_id,Registration_id,CreatedBy,ModifiedBy,CreatedDate,ModifiedDate);
        userDAO.insertUser(newUser);
        response.sendRedirect("list");
    }
    private void deleteUser(HttpServletRequest request,HttpServletResponse response) throws SQLException,IOException{
        int User_id=Integer.parseInt(request.getParameter("User_id"));
        userDAO.deleteUser(User_id);
        response.sendRedirect("list");
    }
    private void showEditForm(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, ServletException {
        int User_id=Integer.parseInt(request.getParameter("User_id"));
        User existingUser= userDAO.selectUserId(User_id);
        RequestDispatcher dispatcher=request.getRequestDispatcher("userform.jsp");
        request.setAttribute("user",existingUser);
        dispatcher.forward(request,response);

    }
    private void updateUser(HttpServletRequest request,HttpServletResponse response)throws SQLException,IOException{
        int User_id=Integer.parseInt(request.getParameter("User_id"));
        String UserName=request.getParameter("UserName");
        String UserLoginName=request.getParameter("userLoginName");
        String Password=request.getParameter("Password");
        int UserGroup_id=Integer.parseInt(request.getParameter("UserGroup_id"));
        int QRAndThump_id=Integer.parseInt(request.getParameter("QRAndThump_id"));
        int Registration_id=Integer.parseInt(request.getParameter("Registration_id"));
        String CreatedBy=request.getParameter("CreatedBy");
        String ModifiedBy=request.getParameter("ModifiedBy");
        Date CreatedDate=Date.valueOf(request.getParameter("CreatedDate"));
        Date ModifiedDate=Date.valueOf(request.getParameter("ModifiedDate"));
        User user=new User(User_id,UserName,UserLoginName,Password,UserGroup_id,QRAndThump_id,Registration_id,CreatedBy,ModifiedBy,CreatedDate,ModifiedDate);
        userDAO.updateUser(user);
        response.sendRedirect("list");
    }

    private void listUser(HttpServletRequest request,HttpServletResponse response)throws SQLException,IOException,ServletException{
        List<User> user=new ArrayList<User>();
        user=userDAO.selectAllUsers();
        request.setAttribute("listUser",user);
        RequestDispatcher dispatcher=request.getRequestDispatcher("userlist.jsp");
        dispatcher.forward(request,response);
    }



}
