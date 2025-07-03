/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Delar
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
    public static Connection connection;

    
    public DAO() {
        if(connection == null){
            String jdbcUrl = "jdbc:sqlserver://DESKTOP-V4LC0I5:1433;DatabaseName=QLBVTH;encrypt=true;trustServerCertificate=true";
            String username = "sa";
            String password = "sa123";
            System.out.println("vao tien");
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                connection = DriverManager.getConnection(jdbcUrl, username, password);
            
            } catch (Exception e) {
                e.printStackTrace();
            }    
            
        }
    }

    public void setConnectionDAO(String idBranch) {
        
//    
    String jdbcUrl = "";

        String username = "sa";
        String password = "sa123";
        
        switch (idBranch) {
            case "DN" -> jdbcUrl = "jdbc:sqlserver://DESKTOP-VDP4V98:1433;DatabaseName=QLBVTH_DN;encrypt=true;trustServerCertificate=true";
            case "HN" -> jdbcUrl = "jdbc:sqlserver://KAITOKIEN:1433;DatabaseName=QLBVTH_HN;encrypt=true;trustServerCertificate=true";
            case "HP" -> jdbcUrl = "jdbc:sqlserver://HEIDI:1433;DatabaseName=QLBVTH_HP;encrypt=true;trustServerCertificate=true";
            case "HCM" -> jdbcUrl = "jdbc:sqlserver://LAPTOP-LGGJOAI2:1422;DatabaseName=QLBVTH_HCM;encrypt=true;trustServerCertificate=true";
            default -> {
            }
        }
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println(jdbcUrl);
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("done");

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    
    
    
    
    
    
 
    
}
