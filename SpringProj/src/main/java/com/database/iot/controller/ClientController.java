package com.database.iot.controller;

import com.database.iot.DTO.ClientDTO;
import com.database.iot.mapper.ClientMapper;
import com.database.iot.model.Client;
import com.database.iot.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/client")

public class ClientController {
    private final ClientService clientService;

    @GetMapping
    public List<ClientDTO> getAllClient() {
        return clientService.getAllClient().stream().map(ClientMapper::mapClientToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable("id") Integer id) {
        Client client = clientService.getClientById(id);
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                ClientMapper.mapClientToDTO(client), HttpStatus.OK);
    }

    @PostMapping
    public ClientDTO createClient(@RequestBody ClientDTO clientDTO) {
        return ClientMapper.mapClientToDTO(clientService.createClient(clientDTO));
    }

    @PutMapping
    public ResponseEntity<ClientDTO> updateClient(@RequestBody ClientDTO clientDTO) {
        Client client = clientService.getClientById(clientDTO.getId());
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                ClientMapper.mapClientToDTO(clientService.updateClient(clientDTO)), HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ClientDTO> deleteClient(@PathVariable("id") Integer id) {
        Client client = clientService.getClientById(id);
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                ClientMapper.mapClientToDTO(clientService.deleteClientById(id)), HttpStatus.OK
        );
    }
}