package com.ayd2.hotel.model.reception;

import com.ayd2.hotel.util.HtlConstant;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "client_account")
@Getter
@Setter
public class ClientAccount {
    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientAccountIdGenerator")
    @SequenceGenerator(name = "clientAccountIdGenerator", sequenceName = "SEQ_PAYMENT", initialValue = 15000, allocationSize = 1)
    private Long accountId;

    @JsonFormat(pattern = HtlConstant.DATE_FORMAT, shape = JsonFormat.Shape.STRING)
    @Column(name = "start_date")
    private LocalDate startDate;

    @JsonFormat(pattern = HtlConstant.DATE_FORMAT, shape = JsonFormat.Shape.STRING)
    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "active")
    private boolean active;

    @Column(name = "client_id")
    private Long clientId;
}
