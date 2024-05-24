package com.spring.transaction_management.service;

import com.spring.transaction_management.dto.BookingRequest;
import com.spring.transaction_management.dto.BookingResponse;
import com.spring.transaction_management.exception.InsufficientBalanceException;
import com.spring.transaction_management.model.PassengerInfo;
import com.spring.transaction_management.model.PaymentInfo;
import com.spring.transaction_management.repository.PassengerInfoRepository;
import com.spring.transaction_management.repository.PaymentInfoRepository;
import com.spring.transaction_management.utility.PaymentGatewaySimuolator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    @Autowired
    private PassengerInfoRepository passengerInfoRepository;

    @Transactional //(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public BookingResponse bookTicket(BookingRequest bookingRequest) //throws InsufficientBalanceException
    {
        BookingResponse bookingResponse = null;
        PassengerInfo passengerInfo = passengerInfoRepository.save(bookingRequest.getPassengerInfo());

        PaymentInfo paymentInfo = bookingRequest.getPaymentInfo();

        // simulate transaction failure due to insufficient balance in account
        PaymentGatewaySimuolator.validateFateBalanceCriterial(
                paymentInfo.getAccount_no(),
                passengerInfo.getFare());
        paymentInfo.setPassenger_id(passengerInfo.getPId());
        paymentInfo.setTotal_fare(passengerInfo.getFare());

        paymentInfoRepository.save(paymentInfo);

        bookingResponse = new BookingResponse();
        bookingResponse.setStatus("SUCCESS");
        bookingResponse.setPassengerInfo(passengerInfo);
        bookingResponse.setPnr(UUID.randomUUID().toString().split("-")[0]);
        bookingResponse.setTotalFare(passengerInfo.getFare());

        return bookingResponse;

    }
}
