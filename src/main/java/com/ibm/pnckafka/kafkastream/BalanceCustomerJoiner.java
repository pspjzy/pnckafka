package com.ibm.pnckafka.kafkastream;

import com.ibm.pnckafka.models.*;
import org.apache.kafka.streams.kstream.ValueJoiner;

public class BalanceCustomerJoiner implements ValueJoiner<Balance, Customer, Joined> {
    @Override
    public Joined apply(Balance balance, Customer customer) {
        return new Joined(balance.getBalanceId(), balance.getAccountId(), balance.getBalance(), customer.getPhoneNumber());
    }
}
