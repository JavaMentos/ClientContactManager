package ru.home.contactmanager.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import ru.home.contactmanager.entity.ContactInfo;
import ru.home.contactmanager.enums.ContactType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactDTO {
    @Schema(title = "Тип контакта")
    private ContactType contactType;
    @Schema(title= "Значение контакта")
    private String contact;

    public static ContactDTO fromEntity(ContactInfo entity) {
        return ContactDTO.builder()
                .contactType(entity.getContactType())
                .contact(entity.getContact())
                .build();
    }
}
