/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Trung Nguyen
 */
public class Husbandry implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
 
    private String name;
 
    private String term;

    private float minimumamountdespositcycle;
  
    private String typeofmoney;

    private String despositCycle;

    private String interestPaymentCycle;

    private String sourcesofinterestPayment;

    private String note;

    public Husbandry() {
    }

    public Husbandry(String id) {
        this.id = id;
    }

    public Husbandry(String id, String name, String term, float minimumamountdespositcycle, String typeofmoney, String despositCycle, String interestPaymentCycle, String sourcesofinterestPayment, String note) {
        this.id = id;
        this.name = name;
        this.term = term;
        this.minimumamountdespositcycle = minimumamountdespositcycle;
        this.typeofmoney = typeofmoney;
        this.despositCycle = despositCycle;
        this.interestPaymentCycle = interestPaymentCycle;
        this.sourcesofinterestPayment = sourcesofinterestPayment;
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public float getMinimumamountdespositcycle() {
        return minimumamountdespositcycle;
    }

    public void setMinimumamountdespositcycle(float minimumamountdespositcycle) {
        this.minimumamountdespositcycle = minimumamountdespositcycle;
    }

    public String getTypeofmoney() {
        return typeofmoney;
    }

    public void setTypeofmoney(String typeofmoney) {
        this.typeofmoney = typeofmoney;
    }

    public String getDespositCycle() {
        return despositCycle;
    }

    public void setDespositCycle(String despositCycle) {
        this.despositCycle = despositCycle;
    }

    public String getInterestPaymentCycle() {
        return interestPaymentCycle;
    }

    public void setInterestPaymentCycle(String interestPaymentCycle) {
        this.interestPaymentCycle = interestPaymentCycle;
    }

    public String getSourcesofinterestPayment() {
        return sourcesofinterestPayment;
    }

    public void setSourcesofinterestPayment(String sourcesofinterestPayment) {
        this.sourcesofinterestPayment = sourcesofinterestPayment;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
        if (!(object instanceof Husbandry)) {
            return false;
        }
        Husbandry other = (Husbandry) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Husbandry[ id=" + id + " ]";
    }
    
}
