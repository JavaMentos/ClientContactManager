package ru.home.contactmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.home.contactmanager.entity.Client;
import ru.home.contactmanager.entity.ContactInfo;
import ru.home.contactmanager.enums.ContactType;

import java.util.Collection;

@Repository
public interface ContactInfoRepository extends JpaRepository<ContactInfo, Long> {
    Collection<ContactInfo> findByClient(Client client);
    Collection<ContactInfo> findByClientNameAndContactType(String clientName, ContactType contactType);
    Collection<ContactInfo> findByClientName(String clientName);

}
