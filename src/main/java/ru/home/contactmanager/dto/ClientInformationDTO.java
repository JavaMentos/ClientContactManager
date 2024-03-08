package ru.home.contactmanager.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import ru.home.contactmanager.entity.ContactInfo;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientInformationDTO {
    @Schema(title = "Имя клиента")
    private String name;
    @Schema(title = "Контакты клиента")
    private List<ContactDTO> contacts;

    public static ClientInformationDTO fromEntity(Collection<ContactInfo> contactEntity) {
        List<ContactDTO> contacts = contactEntity.stream()
                .map(ContactDTO::fromEntity).toList();

        String name = contactEntity.stream()
                .map(contact -> contact.getClient().getName())
                .findAny()
                .orElse(null);

        return ClientInformationDTO.builder()
                .name(name)
                .contacts(contacts)
                .build();
    }
}
