package ru.home.contactmanager.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.home.contactmanager.dto.ClientDTO;
import ru.home.contactmanager.dto.ClientInformationDTO;
import ru.home.contactmanager.entity.Client;
import ru.home.contactmanager.entity.ContactInfo;
import ru.home.contactmanager.repository.ClientRepository;
import ru.home.contactmanager.repository.ContactInfoRepository;
import ru.home.contactmanager.service.ClientService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ContactInfoRepository contactInfoRepository;

    @Override
    public ResponseEntity<String> saveClient(ClientDTO dto) {
        if (clientRepository.existsClientByName(dto.getName())) {
            return ResponseEntity.badRequest().body(String.format("Клиент с именем '%s' уже существует", dto.getName()));
        }
        Client client = new Client(dto.getName());
        clientRepository.save(client);
        return ResponseEntity.ok().build();
    }

    @Override
    public List<ClientDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        if (clients.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return clients.stream()
                .map(ClientDTO::fromEntity)
                .toList();
    }

    @Override
    public ClientInformationDTO getClientById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Collection<ContactInfo> contactInfoByClient = contactInfoRepository.findByClient(client.get());
        return ClientInformationDTO.fromEntity(contactInfoByClient);
    }
}
