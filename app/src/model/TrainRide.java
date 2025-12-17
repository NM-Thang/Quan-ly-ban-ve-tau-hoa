/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;
/**
 *
 * @author Delar
 */
public class TrainRide {
    private String id;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Station departureStation;
    private Station destinationStation;
    private Train train;
    private int ticketPrice;

    public TrainRide() {
    }

    public TrainRide(String id, LocalDateTime departureTime, LocalDateTime arrivalTime, Station departureStation, Station destinationStation, Train train, int ticketPrice) {
        this.id = id;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departureStation = departureStation;
        this.destinationStation = destinationStation;
        this.train = train;
        this.ticketPrice = ticketPrice;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public Station getDepartureStation() {
        return departureStation;
    }

    public Station getDestinationStation() {
        return destinationStation;
    }

    public Train getTrain() {
        return train;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setDepartureStation(Station departureStation) {
        this.departureStation = departureStation;
    }

    public void setDestinationStation(Station destinationStation) {
        this.destinationStation = destinationStation;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    

    

    
    
    
}
