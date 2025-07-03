/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Delar
 */
public class Train {
    private String id;
    private String manufacturer;
    private int class1_seats;
    private int class2_seats;

    public Train() {
    }

    public Train(String id, String manufacturer, int class1_seats, int class2_seats) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.class1_seats = class1_seats;
        this.class2_seats = class2_seats;
    }

    public String getId() {
        return id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getClass1_seats() {
        return class1_seats;
    }

    public int getClass2_seats() {
        return class2_seats;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setClass1_seats(int class1_seats) {
        this.class1_seats = class1_seats;
    }

    public void setClass2_seats(int class2_seats) {
        this.class2_seats = class2_seats;
    }
    
    
}
