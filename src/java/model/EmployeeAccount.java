/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;

public class EmployeeAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String username;

    private String password;

    private Date provisionDate;

    private String branch;

    private float surplus;

    private boolean valid;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
    public EmployeeAccount() {
    }

    public EmployeeAccount(String id) {
        this.id = id;
    }

    public EmployeeAccount(String userName,String password)
    {
        this.username = userName;
        this.password = password;
    }
    public EmployeeAccount(String id, String userName, String passWord, Date provisionDate, String branch, float surplus) {
        this.id = id;
        this.username = userName;
        this.password = passWord;
        this.provisionDate = provisionDate;
        this.branch = branch;
        this.surplus = surplus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getProvisionDate() {
        return provisionDate;
    }

    public void setProvisionDate(Date provisionDate) {
        this.provisionDate = provisionDate;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public float getSurplus() {
        return surplus;
    }

    public void setSurplus(float surplus) {
        this.surplus = surplus;
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
        if (!(object instanceof EmployeeAccount)) {
            return false;
        }
        EmployeeAccount other = (EmployeeAccount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Employeeaccount[ id=" + id + " ]";
    }
    
}
