package ru.home.contactmanager.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.home.contactmanager.dto.ContactDTO;
import ru.home.contactmanager.enums.ContactType;
import ru.home.contactmanager.service.ContactInfoService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contacts")
public class ContactController {
    private final ContactInfoService contactInfoService;

    @Operation(description = "Добавить контакты для клиента")
    @PostMapping("{clientName}")
    public ResponseEntity<String> addContact(@PathVariable String clientName, @RequestBody ContactDTO contactDTO) {
        return contactInfoService.saveContactInfo(clientName, contactDTO);
    }

    @Operation(description = "Получить список контактов по клиенту")
    @GetMapping("/{clientName}")
    public List<ContactDTO> getClientByName(@PathVariable String clientName) {
        return contactInfoService.getContactInfoByClient(clientName);
    }

    @Operation(description = "Получить выбраный тип контакта по клиенту")
    @GetMapping("/{clientName}/{contactType}")
    public List<String> getContactsByClientAndType(@PathVariable String clientName, @PathVariable ContactType contactType) {
        return contactInfoService.getContactByClientAndType(clientName, contactType);
    }
}
