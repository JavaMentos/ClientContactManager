package ru.home.contactmanager.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import ru.home.contactmanager.enums.ContactType;

@Entity
@Getter
@Setter
@Table(name = "CONTACT_INFO")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ContactInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Long contactId;

    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "client_id")
    private Client client;

    @Enumerated(EnumType.STRING)
    @Column(name = "contact_type")
    private ContactType contactType;

    @Column(name = "contact")
    private String contact;

    public ContactInfo(Client client, ContactType contactType, String contact) {
        this.client = client;
        this.contactType = contactType;
        this.contact = contact;
    }
}
