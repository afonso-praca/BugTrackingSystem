/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tracker.model;

/**
 * @author afonso
 */

public class Ticket {
    
    private int id;
    private String title;
    private int systemKey;
    private int componentKey;
    private String description;
    private int status;
    private int userKey;

    public Ticket(int id, String title, int systemKey, int componentKey, String description, int status, int userKey) {
        this.id = id;
        this.title = title;
        this.systemKey = systemKey;
        this.componentKey = componentKey;
        this.description = description;
        this.status = status;
        this.userKey = userKey;
    }

    public Ticket() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSystemKey() {
        return systemKey;
    }

    public void setSystemKey(int systemKey) {
        this.systemKey = systemKey;
    }

    public int getComponentKey() {
        return componentKey;
    }

    public void setComponentKey(int componentKey) {
        this.componentKey = componentKey;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUserKey() {
        return userKey;
    }

    public void setUserKey(int userKey) {
        this.userKey = userKey;
    }
}