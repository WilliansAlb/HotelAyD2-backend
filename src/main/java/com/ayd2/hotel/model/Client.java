package com.ayd2.hotel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "htl_client")
@Getter
@Setter
public class Client {
    @Id
    @Column(name = "client_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientIdGenerator")
    @SequenceGenerator(name = "clientIdGenerator", sequenceName = "SEQ_HTL_CLIENT", initialValue = 15000, allocationSize = 1)
    private Long clientId;

    @Column(name = "identification_no")
    private String identificationNo;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;
}
