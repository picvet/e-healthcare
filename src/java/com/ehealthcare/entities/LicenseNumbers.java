/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealthcare.entities;

import java.io.Serializable;
import javax.persistence.Entity; 
import javax.persistence.Id;

/**
 *
 * @author Percival
 */
@Entity
public class LicenseNumbers implements Serializable {
    
    @Id
    private String licNum;
    private Boolean taken;

    public String getLicNum() {
        return licNum;
    }

    public void setLicNum(String licNum) {
        this.licNum = licNum;
    }

    public Boolean getTaken() {
        return taken;
    }

    public void setTaken(Boolean taken) {
        this.taken = taken;
    } 
    
}
