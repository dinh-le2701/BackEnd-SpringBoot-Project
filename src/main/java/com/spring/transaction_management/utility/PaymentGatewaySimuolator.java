package com.spring.transaction_management.utility;

import com.spring.transaction_management.exception.InsufficientBalanceException;

import java.util.HashMap;
import java.util.Map;

public class PaymentGatewaySimuolator {

    private static Map<String, Double> accountBalanceMap = new HashMap<>();
    static{
        accountBalanceMap.put("acnt-1212", 2000.00);
        accountBalanceMap.put("acnt-1313", 3000.00);
        accountBalanceMap.put("acnt-1414", 4000.00);
    }

    public static boolean validateFateBalanceCriterial(String account_no, double fare) throws InsufficientBalanceException {

        if(fare > accountBalanceMap.get(account_no)) {
            throw new InsufficientBalanceException("You do not have  sufficient balance in your account!");
        }
        return true;
    }
}
