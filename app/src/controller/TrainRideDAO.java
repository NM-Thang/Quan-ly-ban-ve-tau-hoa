/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static controller.DAO.connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Station;
import model.Train;
import model.TrainRide;

/**
 *
 * @author Delar
 */
public class TrainRideDAO  extends DAO{

    public TrainRideDAO() {
    }
    
    public ArrayList<TrainRide> getListTrainRide(String nameStartStation, String nameEndStation){
        ArrayList<TrainRide> trainRides = new ArrayList<>();
        
        try {
            PreparedStatement ps = connection.prepareCall("EXEC sp_getListTrainRide ?, ?");
            
            ps.setString(1, nameStartStation.trim());
            ps.setString(2, nameEndStation.trim());
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String id = rs.getString("id");
                
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                
                String startTimeString = rs.getString("departureTime");
                startTimeString = startTimeString.substring(0, startTimeString.length()-2);
                LocalDateTime startTime = LocalDateTime.parse(startTimeString, formatter);
                
                String endTimeString = rs.getString("arrivalTime");
                endTimeString = endTimeString.substring(0, endTimeString.length()-2);
                LocalDateTime endTime = LocalDateTime.parse(endTimeString, formatter);
                
                Station startStation = new Station();
                startStation.setId(rs.getString("idDepartureStation"));
                startStation.setName(nameStartStation.trim());
                
                Station endStation = new Station();
                endStation.setId(rs.getString("idDestinationStation"));
                endStation.setName(nameEndStation.trim());
                
                Train train = new Train();
                train.setId(rs.getString("idTrain"));
                
                int ticketPrice = rs.getInt("ticketPrice");
                
                
                
                trainRides.add(new TrainRide(id, startTime, endTime, startStation, endStation, train, ticketPrice));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
  
        }
        return trainRides;

    }
    
}
