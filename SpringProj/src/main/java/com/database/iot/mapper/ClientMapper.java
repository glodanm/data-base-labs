package com.database.iot.mapper;

import com.database.iot.model.Client;
import com.database.iot.DTO.ClientDTO;
import lombok.NoArgsConstructor;

@NoArgsConstructor

public class ClientMapper {
    public static ClientDTO mapClientToDTO(Client client){
        return new ClientDTO(
                client.getId(),
                client.getFirst_name(),
                client.getSecond_name(),
                client.getEmail(),
                client.getPhone_number(),
                client.getTraining_type_id()
        );
    }

    public static Client mapDTOToClient(ClientDTO clientDTO){
        return new Client(
                clientDTO.getId(),
                clientDTO.getFirst_name(),
                clientDTO.getSecond_name(),
                clientDTO.getEmail(),
                clientDTO.getPhone_number(),
                clientDTO.getTraining_type_id()
        );
    }
}