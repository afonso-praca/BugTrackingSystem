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
    
    private int systemName;
    private String name;
    private String operatorEmail;
    
    public Component() {
        
    }

    public Component(int systemName, String name, String operatorEmail) {
        this.systemName = systemName;
        this.name = name;
        this.operatorEmail = operatorEmail;
    }

    public int getSystemName() {
        return systemName;
    }

    public void setSystemName(int systemName) {
        this.systemName = systemName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOperatorEmail() {
        return operatorEmail;
    }

    public void setOperatorEmail(String operatorEmail) {
        this.operatorEmail = operatorEmail;
    }

   

 
    
}