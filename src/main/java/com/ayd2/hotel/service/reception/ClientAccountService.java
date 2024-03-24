package com.ayd2.hotel.service.reception;

import com.ayd2.hotel.model.reception.ClientAccount;
import com.ayd2.hotel.repository.reception.ClientAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientAccountService {

    private ClientAccountRepository clientAccountRepository;

    @Autowired
    public ClientAccountService(ClientAccountRepository clientAccountRepository) { this.clientAccountRepository = clientAccountRepository; }

    public ClientAccount getClientAccount(Long client_id){
        return clientAccountRepository.findByClientIdAndActive(client_id,true);
    }

    public List<ClientAccount> getClientAccounts (){
        return clientAccountRepository.findAll();
    }
}
