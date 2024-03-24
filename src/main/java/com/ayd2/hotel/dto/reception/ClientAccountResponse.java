package com.ayd2.hotel.dto.reception;

import com.ayd2.hotel.model.reception.ClientAccount;
import com.ayd2.hotel.model.reception.Room;
import lombok.Value;

import java.time.LocalDate;

@Value
public class ClientAccountResponse {
    Long account_id;
    LocalDate start_date;
    LocalDate end_date;
    boolean active;
    Long client_id;

    public ClientAccountResponse(ClientAccount clientAccount){
        this.account_id = clientAccount.getAccountId();
        this.start_date = clientAccount.getStartDate();
        this.end_date = clientAccount.getEndDate();
        this.active = clientAccount.isActive();
        this.client_id = clientAccount.getClientId();
    }
}