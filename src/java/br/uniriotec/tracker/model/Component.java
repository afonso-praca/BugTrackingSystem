/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tracker.model;

/**
 *
 * @author afonso
 */
public class Component {
    
    private int id;
    private String name;
    private int userKey;
    
    public Component() {
        
    }

    public Component(int id, String name, int userKey) {
        this.id = id;
        this.name = name;
        this.userKey = userKey;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserKey() {
        return userKey;
    }

    public void setUserKey(int userKey) {
        this.userKey = userKey;
    }
}