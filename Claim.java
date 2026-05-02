package com.lims;

/**
 * Represents an insurance claim in the LIMS.
 */
public class Claim {

    public enum Status { PENDING, APPROVED, REJECTED, SETTLED }

    private int id;
    private int customerId;
    private String policyNumber;
    private double claimAmount;
    private Status status;
    private String claimDate;

    public Claim(int id, int customerId, String policyNumber,
                 double claimAmount, String claimDate) {
        this.id           = id;
        this.customerId   = customerId;
        this.policyNumber = policyNumber;
        this.claimAmount  = claimAmount;
        this.claimDate    = claimDate;
        this.status       = Status.PENDING;
    }

    // Getters and Setters
    public int getId()                     { return id; }
    public int getCustomerId()             { return customerId; }
    public String getPolicyNumber()        { return policyNumber; }
    public double getClaimAmount()         { return claimAmount; }
    public Status getStatus()              { return status; }
    public void setStatus(Status status)   { this.status = status; }
    public String getClaimDate()           { return claimDate; }

    @Override
    public String toString() {
        return "Claim ID: " + id + " | Policy No: " + policyNumber +
               " | Customer ID: " + customerId +
               " | Amount: " + claimAmount +
               " | Status: " + status +
               " | Date: " + claimDate;
    }
}
