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

public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String job;
    
    private String passportNo;

    private String idprofile;

    private String idaccount;

    public Customer() {
    }

    public Customer(String id) {
        this.id = id;
    }

    public Customer(String id, String job, String passportNo, String idprofile, String idaccount) {
        this.id = id;
        this.job = job;
        this.passportNo = passportNo;
        this.idprofile = idprofile;
        this.idaccount = idaccount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getIdprofile() {
        return idprofile;
    }

    public void setIdprofile(String idprofile) {
        this.idprofile = idprofile;
    }

    public String getIdaccount() {
        return idaccount;
    }

    public void setIdaccount(String idaccount) {
        this.idaccount = idaccount;
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
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Customer[ id=" + id + " ]";
    }
    
}
