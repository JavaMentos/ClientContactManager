package ru.home.contactmanager.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.home.contactmanager.dto.ClientDTO;
import ru.home.contactmanager.dto.ClientInformationDTO;
import ru.home.contactmanager.service.ClientService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    @Operation(description = "Создать нового клиента")
    @PostMapping
    public ResponseEntity<String> addClient(@RequestBody ClientDTO clientDTO) {
        return clientService.saveClient(clientDTO);
    }

    @Operation(description = "Получить имена всех клиентов")
    @GetMapping
    public List<ClientDTO> getClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{clientId}")
    @Operation(description = "Получить информацию по клиенту")
    public ClientInformationDTO getClientById(@PathVariable Long clientId) {
        return clientService.getClientById(clientId);
    }
}
