package ru.home.contactmanager.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.home.contactmanager.dto.ContactDTO;
import ru.home.contactmanager.entity.Client;
import ru.home.contactmanager.entity.ContactInfo;
import ru.home.contactmanager.enums.ContactType;
import ru.home.contactmanager.repository.ClientRepository;
import ru.home.contactmanager.repository.ContactInfoRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class ContactInfoServiceTest {
    @Mock
    private ContactInfoRepository contactInfoRepository;
    @Mock
    private ClientRepository clientRepository;
    @InjectMocks
    private ContactInfoServiceImpl contactInfoService;

    @Test
    void testSaveContactInfo_ValidClient_Success() {
        String clientName = "Alena";
        ContactDTO contactDTO = new ContactDTO(ContactType.EMAIL, "Alena@example.com");
        Client mockClient = new Client(clientName);
        when(clientRepository.findClientByName(clientName)).thenReturn(Optional.of(mockClient));

        ResponseEntity<String> response = contactInfoService.saveContactInfo(clientName, contactDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testGetContactInfoByClient_ExistingClient_ReturnsContacts() {
        String clientName = "Peter";
        ContactInfo contactInfo1 = new ContactInfo(new Client(clientName), ContactType.PHONE, "89104448811");
        ContactInfo contactInfo2 = new ContactInfo(new Client(clientName), ContactType.EMAIL, "Peter@example.com");
        when(contactInfoRepository.findByClientName(clientName)).thenReturn(List.of(contactInfo1, contactInfo2));

        List<ContactDTO> contactDTOs = contactInfoService.getContactInfoByClient(clientName);

        assertEquals(2, contactDTOs.size());
    }

    @Test
    void testGetContactByClientAndType_ExistingContacts_ReturnsContactList() {
        // Arrange
        String clientName = "Molly";
        ContactType contactType = ContactType.PHONE;
        ContactInfo contactInfo1 = new ContactInfo(new Client(clientName), ContactType.PHONE, "89165558877");
        ContactInfo contactInfo2 = new ContactInfo(new Client(clientName), ContactType.PHONE, "89153335566");
        when(contactInfoRepository.findByClientNameAndContactType(clientName, contactType))
                .thenReturn(List.of(contactInfo1, contactInfo2));

        List<String> contacts = contactInfoService.getContactByClientAndType(clientName, contactType);

        assertEquals(2, contacts.size());
    }
}
