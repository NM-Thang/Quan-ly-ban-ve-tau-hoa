/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Delar
 */
public class Ticket {
    private String id;
    private int totalAmount;
    private TrainRide trainRide ;
    private Customer customer;
    private Employee employee;
    private int seatType;

    public Ticket() {
    }

    public Ticket(String id, int totalAmount, TrainRide trainRide, Customer customer, Employee employee, int seatType) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.trainRide = trainRide;
        this.customer = customer;
        this.employee = employee;
        this.seatType = seatType;
    }

    public String getId() {
        return id;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public TrainRide getTrainRide() {
        return trainRide;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public int getSeatType() {
        return seatType;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setTrainRide(TrainRide trainRide) {
        this.trainRide = trainRide;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setSeatType(int seatType) {
        this.seatType = seatType;
    }

    
}
