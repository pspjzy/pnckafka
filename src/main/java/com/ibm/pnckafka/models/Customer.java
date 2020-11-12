package com.ibm.pnckafka.models;

public class Customer {
    private String customerID;
    private String name;
    private String phoneNumber;
    private String accountId;

    public Customer(String customerID, String name, String phoneNumber, String accountId) {
        this.customerID = customerID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.accountId = accountId;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
