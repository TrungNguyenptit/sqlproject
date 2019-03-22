/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Trung Nguyen
 */

public class Saving implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String idcustomer;

    private String idhusbandry;

    private String idemployee;

    private Date provisionDate;

    private Date expirationDate;
    
    private float interestTotal;

    private float depositTotal;

    private String term;

    private String typeofmoney;
    
    private boolean mo;

    public Saving() {
    }

    public boolean isMo() {
        return mo;
    }

    public void setMo(boolean mo) {
        this.mo = mo;
    }

    public Saving(String id) {
        this.id = id;
    }

    public Saving(String id, String idcustomer, String idhusbandry, String idemployee, Date provisionDate, Date expirationDate, float interestTotal, float depositTotal, String term, String typeofmoney, boolean mo) {
        this.id = id;
        this.idcustomer = idcustomer;
        this.idhusbandry = idhusbandry;
        this.idemployee = idemployee;
        this.provisionDate = provisionDate;
        this.expirationDate = expirationDate;
        this.interestTotal = interestTotal;
        this.depositTotal = depositTotal;
        this.term = term;
        this.typeofmoney = typeofmoney;
        this.mo = mo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdcustomer() {
        return idcustomer;
    }

    public void setIdcustomer(String idaccount) {
        this.idcustomer = idaccount;
    }

    public String getIdhusbandry() {
        return idhusbandry;
    }

    public void setIdhusbandry(String idhusbandry) {
        this.idhusbandry = idhusbandry;
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

    public float getInterestTotal() {
        return interestTotal;
    }

    public void setInterestTotal(float interestTotal) {
        this.interestTotal = interestTotal;
    }

    public float getDepositTotal() {
        return depositTotal;
    }

    public void setDepositTotal(float depositTotal) {
        this.depositTotal = depositTotal;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTypeofmoney() {
        return typeofmoney;
    }

    public void setTypeofmoney(String typeofmoney) {
        this.typeofmoney = typeofmoney;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Saving)) {
            return false;
        }
        Saving other = (Saving) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Saving[ id=" + id + " ]";
    }
    
}
