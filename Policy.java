package com.lims;

/**
 * Represents a life insurance policy in the LIMS.
 */
public class Policy {

    private int id;
    private int customerId;
    private String policyNumber;
    private String type;
    private double premiumAmount;
    private double coverageAmount;
    private String startDate;
    private String endDate;

    public Policy(int id, int customerId, String policyNumber, String type,
                  double premiumAmount, double coverageAmount,
                  String startDate, String endDate) {
        this.id             = id;
        this.customerId     = customerId;
        this.policyNumber   = policyNumber;
        this.type           = type;
        this.premiumAmount  = premiumAmount;
        this.coverageAmount = coverageAmount;
        this.startDate      = startDate;
        this.endDate        = endDate;
    }

    // Getters and Setters
    public int getId()                             { return id; }
    public int getCustomerId()                     { return customerId; }
    public String getPolicyNumber()                { return policyNumber; }
    public String getType()                        { return type; }
    public void setType(String type)               { this.type = type; }
    public double getPremiumAmount()               { return premiumAmount; }
    public void setPremiumAmount(double amount)    { this.premiumAmount = amount; }
    public double getCoverageAmount()              { return coverageAmount; }
    public void setCoverageAmount(double amount)   { this.coverageAmount = amount; }
    public String getStartDate()                   { return startDate; }
    public String getEndDate()                     { return endDate; }
    public void setEndDate(String endDate)         { this.endDate = endDate; }

    @Override
    public String toString() {
        return "Policy No: " + policyNumber + " | Customer ID: " + customerId +
               " | Type: " + type + " | Premium: " + premiumAmount +
               " | Coverage: " + coverageAmount +
               " | Start: " + startDate + " | End: " + endDate;
    }
}
