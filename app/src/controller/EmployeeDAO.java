/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Employee;
import model.Branch;
import static controller.DAO.connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Delar
 */
public class EmployeeDAO extends DAO{
    
    public EmployeeDAO() {
    }
    
    public boolean checkLogin(Employee e){
        try {
            
            PreparedStatement ps = connection.prepareStatement("EXEC sp_loginEmployee ?, ?");
            ps.setString(1, e.getUsername());
            ps.setString(2, e.getPassword());
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                e.setId(rs.getString("idEmployee"));
                e.setFullname(rs.getString("fullname"));
                e.setSalary(rs.getInt("salary"));
                e.setRole(rs.getString("role"));
                e.setPhoneNumber(rs.getString("phoneNumberEmployee"));
                
                e.setBranch(new Branch(rs.getString("idBranch"), rs.getString("addressBranch"), rs.getString("phoneNumberBranch")));
                
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
}
