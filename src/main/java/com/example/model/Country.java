/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "country_id")
    private long id;

    private String countryName;

    private boolean isBlacklist = false;

    @ManyToOne(targetEntity = Timeframe.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "count_id")
    private Timeframe timeframeCountLoan;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public boolean isIsBlacklist() {
        return isBlacklist;
    }

    public void setIsBlacklist(boolean isBlacklist) {
        this.isBlacklist = isBlacklist;
    }

    public Timeframe getTimeframeCountLoan() {
        return timeframeCountLoan;
    }

    public void setTimeframeCountLoan(Timeframe timeframeCountLoan) {
        this.timeframeCountLoan = timeframeCountLoan;
    }
}
