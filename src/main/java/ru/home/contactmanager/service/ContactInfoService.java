package ru.home.contactmanager.service;

import org.springframework.http.ResponseEntity;
import ru.home.contactmanager.dto.ContactDTO;
import ru.home.contactmanager.enums.ContactType;

import java.util.List;

/**
 * Сервис для работы с контактной информацией клиентов.
 */
public interface ContactInfoService {
    /**
     * Сохраняет информацию о контакте для указанного клиента.
     *
     * @param name имя клиента
     * @param contactDTO объект ContactDTO с информацией о контакте
     * @return ответ с сообщением о результате операции
     */
    ResponseEntity<String> saveContactInfo(String name, ContactDTO contactDTO);
    /**
     * Получает список контактной информации по имени клиента.
     *
     * @param clientName имя клиента
     * @return список объектов ContactDTO с информацией о контактах
     */
    List<ContactDTO> getContactInfoByClient(String clientName);
    /**
     * Получает список контактов для указанного клиента и типа контакта.
     *
     * @param client имя клиента
     * @param contactType тип контакта (например, PHONE или EMAIL)
     * @return список строк с контактами указанного типа для клиента
     */
    List<String> getContactByClientAndType(String client, ContactType contactType);
}
