package com.spring.transaction_management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Payment_info")
public class PaymentInfo {

    @Id
    @GeneratedValue(generator = "UUID2")
    @GenericGenerator(name = "UUID2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "payment_id")
    private String payment_id;

    @Column(name = "account_no")
    private String account_no;

    @Column(name = "total_fare")
    private double total_fare;

    @Column(name = "card_type")
    private String card_type;

    @Column(name = "passenger_id")
    private Long passenger_id;
}
