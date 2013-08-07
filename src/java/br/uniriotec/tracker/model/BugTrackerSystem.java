/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uniriotec.tracker.model;

/**
 *
 * @author afonso
 */
public class BugTrackerSystem {
    
    private int id;
    private String name;
    
    public BugTrackerSystem() {
        
    }

    public BugTrackerSystem(int id, String name) {
        this.id = id;
        this.name = name;
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
}