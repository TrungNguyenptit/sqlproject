/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controller.EmployeeAccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.EmployeeAccount;

/**
 *
 * @author ADMIN
 */
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try
{    
     EmployeeAccount ea = new EmployeeAccount();
     ea.setUsername(request.getParameter("username"));
     ea.setPassword(request.getParameter("password"));
     ea = EmployeeAccountDAO.LogIn(ea);		    
     if (ea.isValid())
     {        
          HttpSession session = request.getSession(true);	    
          session.setAttribute("currentSessionUser",ea); 
          response.sendRedirect("main.jsp"); //logged-in page      		
     }
	        
     else 
     {
         response.getOutputStream().println("<script> alert(\"Sai thông tin đăng nhập!!\"); window.location = 'index.jsp';</script>");
     }
} 
catch (SQLException e) {
            e.printStackTrace();
        }
    
    }

}
