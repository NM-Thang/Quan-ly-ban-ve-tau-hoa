/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static controller.DAO.connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Station;

/**
 *
 * @author Delar
 */
public class StationDAO  extends DAO{

    public StationDAO() {
    }
    
    public ArrayList<Station> getAllStation(){
        ArrayList<Station> stations = new ArrayList<>();
        
        try {
            
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Station");
            
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                stations.add(new Station(rs.getString("id"), rs.getString("name"), rs.getString("type"), rs.getString("address")));
            }
        } catch (SQLException ex) {
        }
        return stations;
        
    }
}
