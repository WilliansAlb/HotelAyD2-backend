package com.ayd2.hotel.controller;

import com.ayd2.hotel.dto.ClientRequest;
import com.ayd2.hotel.dto.ClientResponse;
import com.ayd2.hotel.exception.HtlException;
import com.ayd2.hotel.model.ClientAccount;
import com.ayd2.hotel.service.ClientAccountService;
import com.ayd2.hotel.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
@Slf4j
public class ClientController {
    private ClientService clientService;
    private ClientAccountService clientAccountService;

    @Autowired
    public ClientController(ClientService clientService, ClientAccountService clientAccountService) {
        this.clientService = clientService;
        this.clientAccountService = clientAccountService;
    }

    @GetMapping
    public ResponseEntity<List<ClientResponse>> getAllClients(){
        return ResponseEntity.ok(clientService.findAll());
    }

    @PostMapping
    public ResponseEntity<ClientResponse> saveClient(@RequestBody ClientRequest clientRequest) throws HtlException {
        return ResponseEntity.ok(this.clientService.saveClient(clientRequest));
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<ClientAccount>> getAllClientAccounts(){
        return ResponseEntity.ok(clientAccountService.getClientAccounts());
    }

    @GetMapping("/accounts/{client_id}")
    public ResponseEntity<ClientAccount> getActiveClientAccount(@PathVariable("client_id") Long clientId){
        return ResponseEntity.ok(clientAccountService.getClientAccount(clientId));
    }
}
