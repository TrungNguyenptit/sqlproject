/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import model.Loan;
import model.Saving;

/**
 *
 * @author ADMIN
 */
public class InterestCount {

    public Date date;
    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    public float SavingInterestCount(ArrayList<Saving> savingList, int term, String finishDate) throws ParseException {
        Date fDate = df.parse(finishDate);
        float m = 0;
        for (Saving s : savingList) {
            if (!s.isMo()) {
                if (s.getExpirationDate().compareTo(fDate) <= 0) {
                    m += s.getInterestTotal();
                }
            }
        }
        return m;
    }
    
     public float LoanInterestCount(ArrayList<Loan> loanList, int term, String finishDate) throws ParseException {
        Date fDate = df.parse(finishDate);
        float m = 0;
        for (Loan lo: loanList) {
            if (!lo.isMo()) {
                if (lo.getExpirationDate().compareTo(fDate) <= 0) {
                    m += lo.getInterestTotal();
                }
            }
        }
        return m;
    }
     

    public static void main(String[] args) throws ParseException, SQLException {
    }
}
