package ru.home.contactmanager.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;
import ru.home.contactmanager.dto.ClientDTO;
import ru.home.contactmanager.dto.ClientInformationDTO;
import ru.home.contactmanager.entity.Client;
import ru.home.contactmanager.repository.ClientRepository;
import ru.home.contactmanager.repository.ContactInfoRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {
    @Mock
    private ClientRepository clientRepository;
    @Mock
    private ContactInfoRepository contactInfoRepository;
    @InjectMocks
    private ClientServiceImpl clientService;

    @Test
    void testSaveClient_NewClient_Success() {
        ClientDTO newClient = new ClientDTO("John Doe");
        when(clientRepository.existsClientByName(newClient.getName())).thenReturn(false);

        ResponseEntity<String> response = clientService.saveClient(newClient);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testSaveClient_NewClient_Failed() {
        ClientDTO newClient = new ClientDTO("Peter");
        when(clientRepository.existsClientByName(newClient.getName())).thenReturn(true);

        ResponseEntity<String> response = clientService.saveClient(newClient);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void testGetAllClients_ShouldReturnClients() {
        List<Client> clients = List.of(new Client("Peter"), new Client("John"));
        when(clientRepository.findAll()).thenReturn(clients);

        List<ClientDTO> clientDTOs = clientService.getAllClients();

        assertEquals(2, clientDTOs.size());
    }

    @Test
    void testGetAllClients_EmptyList_NotFoundExceptionThrown() {
        when(clientRepository.findAll()).thenReturn(Collections.emptyList());

        assertThrows(ResponseStatusException.class, () -> clientService.getAllClients());
    }

    @Test
    void testGetClientById_ValidId_ClientInformationDTOReturned() {
        Long clientId = 1L;
        Client mockClient = new Client("Alena");
        when(clientRepository.findById(clientId)).thenReturn(Optional.of(mockClient));

        ClientInformationDTO result = clientService.getClientById(clientId);

        assertNotNull(result);
    }
}
