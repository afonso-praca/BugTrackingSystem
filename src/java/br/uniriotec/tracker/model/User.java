/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tracker.model;

import java.util.Date;

/**
 * @author afonso
 */
public class User {
    private String type;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String token;
    private boolean isActive;
    private boolean forcePasswordReset;
    private boolean shouldChangePassword;
    private Date lastLogonTime;
    private int failedLogins;
    
    public User() {
        
    }

    public User(String type, String name, String lastName, String email, String password, boolean isActive, boolean forcePasswordReset, boolean shouldChangePassword) {
        this.type = type;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
        this.forcePasswordReset = forcePasswordReset;
        this.shouldChangePassword = shouldChangePassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
     public boolean isForcePasswordReset() {
        return forcePasswordReset;
    }

    public void setForcePasswordReset(boolean forcePasswordReset) {
        this.forcePasswordReset = forcePasswordReset;
    }

    public boolean isShouldChangePassword() {
        return shouldChangePassword;
    }

    public void setShouldChangePassword(boolean shouldChangePassword) {
        this.shouldChangePassword = shouldChangePassword;
    }
    
     public Date getLastLogonTime() {
        return lastLogonTime;
    }

    public void setLastLogonTime(Date lastLogonTime) {
        this.lastLogonTime = lastLogonTime;
    }
    
    public int getFailedLogins() {
        return failedLogins;
    }

    public void setFailedLogins(int failedLogins) {
        this.failedLogins = failedLogins;
    }
}