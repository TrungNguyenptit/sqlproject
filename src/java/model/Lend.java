/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Lend {
    
    private String id;
    private String name;
    private String term;
    private float interestRate;
    private float lendingamountmaximum;

    public Lend() {
    }

    public Lend(String id, String name, String term, float interestRate, float lendingamountmaximum) {
        this.id = id;
        this.name = name;
        this.term = term;
        this.interestRate = interestRate;
        this.lendingamountmaximum = lendingamountmaximum;
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

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public float getLendingamountmaximum() {
        return lendingamountmaximum;
    }

    public void setLendingamountmaximum(float lendingamountmaximum) {
        this.lendingamountmaximum = lendingamountmaximum;
    }
}
