/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controller.InterestCount;
import controller.SavingDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Saving;

/**
 *
 * @author ADMIN
 */
public class ReportServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int term=0;
            Date fDate = new Date();
            if (request.getParameter("term").equalsIgnoreCase("thang")) {
                term = 30;
            } else if (request.getParameter("term").equalsIgnoreCase("quy")) {
                term = 90;
            } else if (request.getParameter("term").equalsIgnoreCase("nam")) {
                term = 365;
            }
            String[] endDate = request.getParameterValues("endDate");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                fDate = sdf.parse(endDate[0]);
            } catch (ParseException ex) {
                Logger.getLogger(ReportServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            InterestCount tc = new InterestCount();
            SavingDAO sdao = new SavingDAO();
            ArrayList<Saving> savingList = sdao.GetSaving("all","all","all");
            float totalMoney = tc.SavingInterestCount(savingList, term, sdf.format(fDate) );
            BigDecimal bdTotalMoney = new BigDecimal(totalMoney);
            response.getOutputStream().println("<script> alert(\""+bdTotalMoney+" VND\"); window.location = 'index.jsp';</script>");
        } catch (ParseException | SQLException ex) {
            Logger.getLogger(ReportServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
