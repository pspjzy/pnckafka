package com.ibm.pnckafka.models;

public class Joined {
    private String balanceId;

    public Joined(String balanceId, String accountId, String balance, String phoneNumber) {
        this.balanceId = balanceId;
        this.accountId = accountId;
        this.balance = balance;
        this.phoneNumber = phoneNumber;
    }

    private String accountId;

    public String getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(String balanceId) {
        this.balanceId = balanceId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private String balance;
    private String phoneNumber;

}
