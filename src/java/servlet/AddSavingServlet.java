/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controller.SavingDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Saving;
import java.util.Calendar;

/**
 *
 * @author ADMIN
 */
public class AddSavingServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddSavingServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddSavingServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String id = request.getParameter("id");
            String idcustomer = request.getParameter("idcustomer");
            String idemployee = request.getParameter("idemployee");
            String idhusbandry = request.getParameter("idhusbandry");
            String provisionDateStrings = request.getParameter("provisionDate");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date provisionDate = new Date();
            provisionDate = sdf.parse("2018-01-01");
            float interestTotal = 0f;
            //interestTotal = Float.parseFloat(request.getParameter("interestTotal"));
            System.out.println(interestTotal);
            float depositTotal = 0f;
            //depositTotal = Float.parseFloat(request.getParameter("depositTotal"));
            int term = 1;
            //term = Integer.parseInt(request.getParameter("term"));
            Calendar c = Calendar.getInstance();
            //Setting the date to the given date
            c.setTime(provisionDate);
            c.add(Calendar.DAY_OF_MONTH, term);
            Date expirationDate = c.getTime();
            String typeofmoney = request.getParameter("typeofmoney");
            Saving s = new Saving(id, idcustomer, idhusbandry, idemployee, provisionDate, expirationDate, interestTotal, depositTotal, term + " thang", typeofmoney, true);
            SavingDAO.addSaving(s);
            response.sendRedirect("main.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(AddSavingServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(AddSavingServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
