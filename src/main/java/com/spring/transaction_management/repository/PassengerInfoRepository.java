package com.spring.transaction_management.repository;

import com.spring.transaction_management.model.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerInfoRepository extends JpaRepository<PassengerInfo, Long> {
}
