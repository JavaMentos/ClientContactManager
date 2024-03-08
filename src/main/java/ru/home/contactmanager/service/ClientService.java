package ru.home.contactmanager.service;

import org.springframework.http.ResponseEntity;
import ru.home.contactmanager.dto.ClientDTO;
import ru.home.contactmanager.dto.ClientInformationDTO;

import java.util.List;

/**
 * Сервисный для добавления клиентов и получении по ним информации.
 */
public interface ClientService {
    /**
     * Сохраняет информацию о новом клиенте.
     *
     * @param client информация о клиенте для сохранения
     * @return ответ с сообщением о результате операции
     */
    ResponseEntity<String> saveClient(ClientDTO client);
    /**
     * Возвращает список всех зарегистрированных клиентов.
     *
     * @return список объектов ClientDTO с информацией о клиентах
     */
    List<ClientDTO> getAllClients();
    /**
     * Получает информацию о клиенте по его идентификатору.
     *
     * @param id идентификатор клиента
     * @return объект ClientInformationDTO с подробной информацией о клиенте
     */
    ClientInformationDTO getClientById(Long id);
}
