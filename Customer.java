package com.lims;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a customer in the Life Insurance Management System.
 */
public class Customer {

    private int id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private List<Policy> policies;

    public Customer(int id, String name, String email, String phone, String address) {
        this.id      = id;
        this.name    = name;
        this.email   = email;
        this.phone   = phone;
        this.address = address;
        this.policies = new ArrayList<>();
    }

    // Getters and Setters
    public int getId()                     { return id; }
    public String getName()                { return name; }
    public void setName(String name)       { this.name = name; }
    public String getEmail()               { return email; }
    public void setEmail(String email)     { this.email = email; }
    public String getPhone()               { return phone; }
    public void setPhone(String phone)     { this.phone = phone; }
    public String getAddress()             { return address; }
    public void setAddress(String address) { this.address = address; }
    public List<Policy> getPolicies()      { return policies; }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name +
               " | Email: " + email + " | Phone: " + phone +
               " | Address: " + address;
    }
}
