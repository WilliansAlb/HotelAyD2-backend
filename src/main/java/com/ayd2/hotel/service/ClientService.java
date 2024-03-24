package com.ayd2.hotel.service;

import com.ayd2.hotel.dto.ClientRequest;
import com.ayd2.hotel.dto.ClientResponse;
import com.ayd2.hotel.exception.HtlClient;
import com.ayd2.hotel.exception.HtlException;
import com.ayd2.hotel.model.Client;
import com.ayd2.hotel.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientResponse> findAll() {
        return clientRepository.findAll()
                .stream()
                .map(ClientResponse::new)
                .collect(Collectors.toList());
    }

    public ClientResponse saveClient(ClientRequest clientRequest) throws HtlException {
        List<Client> found = this.clientRepository.findByIdentificationNo(clientRequest.getIdentification_no());
        if (found.isEmpty()) {
            throw new HtlException("Duplicated client").status(HttpStatus.CONFLICT);
        }

        Client newClient = new Client();

        newClient.setEmail(clientRequest.getEmail());
        newClient.setFirstName(clientRequest.getFirst_name());
        newClient.setIdentificationNo(clientRequest.getIdentification_no());
        newClient.setLastName(clientRequest.getLast_name());
        newClient.setMiddleName(clientRequest.getMiddle_name());
        newClient.setPhoneNumber(clientRequest.getPhone_number());

        return new ClientResponse(this.clientRepository.save(newClient));
    }
}
