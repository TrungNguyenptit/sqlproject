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
public class Interestrate implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String type;

    private String term;

    private float vndinterestrate;

    private float usdinterestrate;

    private float eurinterestrate;
    
    private float audinterestrate;

    public Interestrate() {
    }

    public Interestrate(String id) {
        this.id = id;
    }

    public Interestrate(String id, String name, String type, String term, float vndinterestrate, float usdinterestrate, float eurinterestrate, float audinterestrate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.term = term;
        this.vndinterestrate = vndinterestrate;
        this.usdinterestrate = usdinterestrate;
        this.eurinterestrate = eurinterestrate;
        this.audinterestrate = audinterestrate;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public float getVndinterestrate() {
        return vndinterestrate;
    }

    public void setVndinterestrate(float vndinterestrate) {
        this.vndinterestrate = vndinterestrate;
    }

    public float getUsdinterestrate() {
        return usdinterestrate;
    }

    public void setUsdinterestrate(float usdinterestrate) {
        this.usdinterestrate = usdinterestrate;
    }

    public float getEurinterestrate() {
        return eurinterestrate;
    }

    public void setEurinterestrate(float eurinterestrate) {
        this.eurinterestrate = eurinterestrate;
    }

    public float getAudinterestrate() {
        return audinterestrate;
    }

    public void setAudinterestrate(float audinterestrate) {
        this.audinterestrate = audinterestrate;
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
        if (!(object instanceof Interestrate)) {
            return false;
        }
        Interestrate other = (Interestrate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Interestrate[ id=" + id + " ]";
    }
    
}
