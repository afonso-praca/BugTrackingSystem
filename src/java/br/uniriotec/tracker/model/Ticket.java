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
    private String system;
    private String component;
    private String description;
    private String status;
    private String operator;
    private String[] comments;
    
    public Ticket() {
        
    }

    public Ticket(int id, String title, String systemKey, String componentKey, String description, String status, String userKey) {
        this.id = id;
        this.title = title;
        this.system = systemKey;
        this.component = componentKey;
        this.description = description;
        this.status = status;
        this.operator = userKey;
    }
    public Ticket(int id, String title, String systemKey, String componentKey, String description, String status) {
        this.id = id;
        this.title = title;
        this.system = systemKey;
        this.component = componentKey;
        this.description = description;
        this.status = status;
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

    public String getSystemKey() {
        return system;
    }

    public void setSystemKey(String systemKey) {
        this.system = systemKey;
    }

    public String getComponentKey() {
        return component;
    }

    public void setComponentKey(String componentKey) {
        this.component = componentKey;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserKey() {
        return operator;
    }

    public void setUserKey(String userKey) {
        this.operator = userKey;
    }
    
    public String[] getComments() {
        return comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }
}