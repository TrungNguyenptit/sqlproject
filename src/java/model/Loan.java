/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Loan {
    
    private String id;
    private String idlend;
    private String idcustomer;
    private String idemployee;
    private Date provisionDate;
    private Date expirationDate;
    private String term;
    private float loanamount;
    private float interestTotal;
    private String InterestPaymentCycle;
    private String note;
    
    private boolean mo;

    public Loan(String id, String idlend, String idcustomer, String idemployee, Date provisionDate, Date expirationDate, String term, float loanamount, float interestTotal, String InterestPaymentCycle, String note, boolean mo) {
        this.id = id;
        this.idlend = idlend;
        this.idcustomer = idcustomer;
        this.idemployee = idemployee;
        this.provisionDate = provisionDate;
        this.expirationDate = expirationDate;
        this.term = term;
        this.loanamount = loanamount;
        this.interestTotal = interestTotal;
        this.InterestPaymentCycle = InterestPaymentCycle;
        this.note = note;
        this.mo = mo;
    }

    public boolean isMo() {
        return mo;
    }

    public void setMo(boolean mo) {
        this.mo = mo;
    }

    public Loan() {
    
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdlend() {
        return idlend;
    }

    public void setIdlend(String idlend) {
        this.idlend = idlend;
    }

    public String getIdcustomer() {
        return idcustomer;
    }

    public void setIdcustomer(String idcustomer) {
        this.idcustomer = idcustomer;
    }

    public String getIdemployee() {
        return idemployee;
    }

    public void setIdemployee(String idemployee) {
        this.idemployee = idemployee;
    }

    public Date getProvisionDate() {
        return provisionDate;
    }

    public void setProvisionDate(Date provisionDate) {
        this.provisionDate = provisionDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public float getLoanamount() {
        return loanamount;
    }

    public void setLoanamount(float loanamount) {
        this.loanamount = loanamount;
    }


    public float getInterestTotal() {
        return interestTotal;
    }

    public void setInterestTotal(float interestTotal) {
        this.interestTotal = interestTotal;
    }

    public String getInterestPaymentCycle() {
        return InterestPaymentCycle;
    }

    public void setInterestPaymentCycle(String InterestPaymentCycle) {
        this.InterestPaymentCycle = InterestPaymentCycle;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
