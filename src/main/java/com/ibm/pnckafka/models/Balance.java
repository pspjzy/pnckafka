package com.ibm.pnckafka.models;

import java.io.Serializable;

public class Balance implements Serializable {
    private String balanceId;
    private String accountId;
    private String balance;

    public Balance(String balanceId, String accountId, String balance) {
        this.balanceId = balanceId;
        this.accountId = accountId;
        this.balance = balance;
    }

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
}
