package com.ayd2.hotel.dto.reception;

import com.ayd2.hotel.model.reception.Client;
import lombok.Value;

@Value
public class ClientResponse {
    Long client_id;
    String identification_no;
    String first_name;
    String middle_name;
    String last_name;
    String email;
    String phone_number;

    public ClientResponse(Client client) {
        this.client_id = client.getClientId();
        this.identification_no = client.getIdentificationNo();
        this.first_name = client.getFirstName();
        this.middle_name = client.getMiddleName();
        this.last_name = client.getLastName();
        this.email = client.getEmail();
        this.phone_number = client.getPhoneNumber();
    }
}
