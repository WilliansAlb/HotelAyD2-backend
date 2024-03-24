package com.ayd2.hotel.dto;

import lombok.Value;

@Value
public class ClientRequest {
    String identification_no;
    String first_name;
    String middle_name;
    String last_name;
    String email;
    String phone_number;
}
