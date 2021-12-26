package com.database.iot.service;

import com.database.iot.DTO.ClientDTO;
import com.database.iot.mapper.ClientMapper;
import com.database.iot.model.Client;
import com.database.iot.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service

public class ClientService {
    private final ClientRepository clientRepository;

    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    public Client getClientById(Integer id) {
        return clientRepository.findById(id).orElse(null);
    }

    public Client createClient(ClientDTO clientDTO) {
        return clientRepository.save(ClientMapper.mapDTOToClient(clientDTO));
    }

    public Client updateClient(ClientDTO clientDTO) {
        if (getClientById(clientDTO.getId()) != null) {
            return clientRepository.save(ClientMapper.mapDTOToClient(clientDTO));
        }
        return null;
    }

    public Client deleteClientById(Integer id) {
        Client client = getClientById(id);
        if (client != null) {
            clientRepository.deleteById(id);
            return client;
        }
        return null;
    }
}