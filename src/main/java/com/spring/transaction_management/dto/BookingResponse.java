package com.spring.transaction_management.dto;

import com.spring.transaction_management.model.PassengerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponse {

    private String status;
    private double totalFare;
    private String pnr;
    private PassengerInfo passengerInfo;
}
