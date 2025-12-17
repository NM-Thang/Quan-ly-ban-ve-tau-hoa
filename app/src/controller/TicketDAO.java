/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static controller.DAO.connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;
import model.Employee;
import model.Train;
import model.Station;
import model.Ticket;
import model.TrainRide;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Delar
 */
public class TicketDAO  extends DAO{

    public TicketDAO() {
    }
    
    public ArrayList<Ticket> getListTicketedCustomer(String idCustomer){
        ArrayList<Ticket> listTicketedCustomer = new ArrayList<>();
        
        
        try {
            PreparedStatement ps = connection.prepareCall("EXEC sp_getListTicketedCustomer ?");
            
             ps.setString(1, idCustomer);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String idTicket = rs.getString("idTicket");
                int totalAmount = rs.getInt("totalAmount");
                
                Train train = new Train();
                train.setId(rs.getString("idTrain"));
                
                Station startStation = new Station();
                startStation.setName(rs.getString("startStation"));
                
                Station endStation = new Station();
                endStation.setName(rs.getString("endStation"));
                
                
                String startTimeString = rs.getString("startTime");
                startTimeString = startTimeString.substring(0, startTimeString.length() - 2);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime startTime = LocalDateTime.parse(startTimeString, formatter);
                
                TrainRide trainRide = new TrainRide();
                trainRide.setDepartureTime(startTime);
                trainRide.setTrain(train);
                trainRide.setDepartureStation(startStation);
                trainRide.setDestinationStation(endStation);
                
                int seatType = rs.getInt("seatType");
                
                listTicketedCustomer.add(new Ticket(idTicket, totalAmount, trainRide, (new Customer()), (new Employee()), seatType));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
  
        }
        return listTicketedCustomer;
    }
    
    public String addTicket (Ticket ticket, String idBranch){
        try {
            CallableStatement cs = connection.prepareCall("{call sp_addTicket(?, ?, ?, ?, ?, ?, ?)}");
            cs.setString(1, idBranch.trim());
            cs.setInt(2, ticket.getTotalAmount());
            cs.setString(3, ticket.getTrainRide().getId().trim());
            cs.setString(4, ticket.getCustomer().getId().trim());
            cs.setString(5, "CustomerADD");
            cs.setInt(6, ticket.getSeatType());
            cs.registerOutParameter(7, Types.NVARCHAR);
            cs.executeUpdate();
            return cs.getString(7);
        } catch (SQLException ex) {
            return ex.getMessage();
        }
    }
    
}
