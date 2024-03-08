CREATE TABLE PUBLIC.CONTACT_INFO (
                              CONTACT_ID BIGSERIAL PRIMARY KEY,
                              CLIENT_ID BIGINT NOT NULL,
                              CONSTRAINT CONTACT_INFO_CLIENT_FK FOREIGN KEY(CLIENT_ID) REFERENCES CLIENTS ON UPDATE RESTRICT ON DELETE RESTRICT,
                              CONTACT_TYPE VARCHAR(255) NOT NULL,
                              CONTACT VARCHAR(255) NOT NULL
);

COMMENT ON TABLE CONTACT_INFO IS 'Таблица для хранения контактной информации клиентов';

COMMENT ON COLUMN CONTACT_INFO.CONTACT_ID IS 'Уникальный идентификатор контакта';
COMMENT ON COLUMN CONTACT_INFO.CLIENT_ID IS 'Идентификатор клиента';
COMMENT ON COLUMN CONTACT_INFO.CONTACT_TYPE IS 'Тип контакта (телефон или email)';
COMMENT ON COLUMN CONTACT_INFO.CONTACT IS 'Значение контакта (телефонный номер или email)';
