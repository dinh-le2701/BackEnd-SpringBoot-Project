package com.spring.transaction_management.dto;

import com.spring.transaction_management.model.PassengerInfo;
import com.spring.transaction_management.model.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequest {

    private PaymentInfo paymentInfo;
    private PassengerInfo passengerInfo;
}
