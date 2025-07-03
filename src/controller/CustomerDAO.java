/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static controller.DAO.connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Customer;
import java.sql.CallableStatement;
import java.sql.Types;
import model.Branch;


/**
 *
 * @author Delar
 */
public class CustomerDAO extends DAO{
    
    String idBranch;

    public CustomerDAO() {
        
    }
    
    public boolean checkLogin(Customer c){
        try {
            
            PreparedStatement ps = connection.prepareStatement("EXEC sp_loginCustomer ?, ?");
            ps.setString(1, c.getUsername().trim());
            ps.setString(2, c.getPassword().trim());
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                c.setId(rs.getString("idCustomer"));
                c.setFullname(rs.getString("fullname"));
                c.setPhoneNumber(rs.getString("phoneNumberCustomer"));
                c.setAddress(rs.getString("addressCustomer"));
                
                c.setBranch(new Branch(rs.getString("idBranch"), rs.getString("addressBranch"), rs.getString("phoneNumberBranch")));
                

                    
                setConnectionDAO(String.valueOf(rs.getString("idBranch")));
                System.out.println("vao check");
                return true;
                
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
        return false;
    }
    
    public String addCustomer(Customer c){
        
        try {
            CallableStatement cs = connection.prepareCall("{call sp_addCustomer(?, ?, ?, ?, ?, ?, ?)}");
            cs.setString(1, c.getFullname().trim());
            cs.setString(2, c.getUsername().trim());
            cs.setString(3, c.getPassword().trim());
            cs.setString(4, c.getPhoneNumber().trim());
            cs.setString(5, c.getAddress().trim());
            cs.setString(6, c.getBranch().getId().trim());
            
            cs.registerOutParameter(7, Types.NVARCHAR);
            cs.executeUpdate();
            c.setId(cs.getString(7));
            return "success";
        } catch (SQLException ex) {
            return ex.getMessage();
        }
    }
    
    public String editCustomer(Customer c){
        try {
            CallableStatement cs = connection.prepareCall("{call sp_editCustomer(?, ?, ?, ?, ?, ?, ?)}");
            cs.setString(1, c.getId());
            cs.setString(2, c.getFullname());
            cs.setString(3, c.getUsername());
            cs.setString(4, c.getPassword());
            cs.setString(5, c.getPhoneNumber());
            cs.setString(6, c.getAddress());
            cs.registerOutParameter(7, Types.NVARCHAR);
            cs.executeUpdate();
            
            return cs.getString(7);
            
        } catch (SQLException ex) {
            return ex.getMessage();
        }
    }
}
