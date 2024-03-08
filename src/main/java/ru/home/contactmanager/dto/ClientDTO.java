package ru.home.contactmanager.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import ru.home.contactmanager.entity.Client;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDTO {
    @Schema(title = "Имя клиента")
    private String name;

    public static ClientDTO fromEntity(Client entity) {
        return ClientDTO.builder()
                .name(entity.getName())
                .build();
    }
}
