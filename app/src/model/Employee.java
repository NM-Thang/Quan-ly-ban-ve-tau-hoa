/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author Delar
 */
public class Employee {
    
    private String id;
    private String fullname;
    private String username;
    private String password;
    private int salary;
    private String role;
    private String phoneNumber;
    private Branch branch;


    public Employee() {
    }

    public Employee(String id, String fullname, String username, String password, int salary, String role, String phoneNumber, Branch branch) {
        this.id = id;
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.salary = salary;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.branch = branch;
    }

    public String getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getSalary() {
        return salary;
    }

    public String getRole() {
        return role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    
}
