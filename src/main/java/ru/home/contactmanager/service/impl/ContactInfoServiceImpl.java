package ru.home.contactmanager.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.home.contactmanager.dto.ContactDTO;
import ru.home.contactmanager.entity.Client;
import ru.home.contactmanager.entity.ContactInfo;
import ru.home.contactmanager.enums.ContactType;
import ru.home.contactmanager.repository.ClientRepository;
import ru.home.contactmanager.repository.ContactInfoRepository;
import ru.home.contactmanager.service.ContactInfoService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactInfoServiceImpl implements ContactInfoService {
    private final ContactInfoRepository contactInfoRepository;
    private final ClientRepository clientRepository;

    @Override
    public ResponseEntity<String> saveContactInfo(String name, ContactDTO contactDTO) {
        Optional<Client> client = clientRepository.findClientByName(name);
        if (client.isEmpty()) {
            return ResponseEntity.badRequest().body("Клиента с таким именем нет");
        }
        ContactInfo contactInfo =
                new ContactInfo(client.get(), contactDTO.getContactType(), contactDTO.getContact());
        contactInfoRepository.save(contactInfo);
        return ResponseEntity.ok().build();
    }

    @Override
    public List<ContactDTO> getContactInfoByClient(String clientName) {
        Collection<ContactInfo> contactsInfo = contactInfoRepository.findByClientName(clientName);
        if (contactsInfo.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return contactsInfo.stream().map(ContactDTO::fromEntity).toList();
    }

    @Override
    public List<String> getContactByClientAndType(String client, ContactType contactType) {
        Collection<ContactInfo> contactInfos = contactInfoRepository.findByClientNameAndContactType(client, contactType);
        if (contactInfos.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return contactInfos.stream().map(ContactInfo::getContact).toList();
    }
}
