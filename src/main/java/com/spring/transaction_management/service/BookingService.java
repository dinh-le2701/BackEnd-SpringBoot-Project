package com.spring.transaction_management.service;

import com.spring.transaction_management.dto.BookingRequest;
import com.spring.transaction_management.dto.BookingResponse;
import com.spring.transaction_management.exception.InsufficientBalanceException;
import org.springframework.stereotype.Service;

@Service
public interface BookingService {
    BookingResponse bookTicket(BookingRequest bookingRequest) throws InsufficientBalanceException;


}
