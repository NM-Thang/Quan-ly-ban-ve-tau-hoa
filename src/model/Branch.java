/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Delar
 */
public class Branch {
    private String id;
    private String address;
    private String phoneNuber;

    public Branch() {
    }

    public Branch(String id, String address, String phoneNuber) {
        this.id = id;
        this.address = address;
        this.phoneNuber = phoneNuber;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNuber() {
        return phoneNuber;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNuber(String phoneNuber) {
        this.phoneNuber = phoneNuber;
    }
    
    
}
