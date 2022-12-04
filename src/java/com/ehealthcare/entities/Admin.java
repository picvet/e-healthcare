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
public class Admin implements Serializable {

    @Id
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }  
}
