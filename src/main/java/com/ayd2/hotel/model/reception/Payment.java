package com.ayd2.hotel.model.reception;

import com.ayd2.hotel.util.HtlConstant;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "payment")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
public class Payment {
    @Id
    @Column(name = "payment_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paymentIdGenerator")
    @SequenceGenerator(name = "paymentIdGenerator", sequenceName = "SEQ_PAYMENT", initialValue = 15000, allocationSize = 1)
    private Long paymentId;

    @Column(name = "account_id")
    private Long accountId;

    @JsonFormat(pattern = HtlConstant.DATE_FORMAT, shape = JsonFormat.Shape.STRING)
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "total")
    private double total;

    @Column(name = "description")
    private String description;
}
