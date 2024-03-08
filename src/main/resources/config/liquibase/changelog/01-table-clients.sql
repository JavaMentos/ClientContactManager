CREATE TABLE PUBLIC.CLIENTS (
                                       CLIENT_ID BIGSERIAL PRIMARY KEY,
                                       NAME VARCHAR(255) NOT NULL UNIQUE
);

COMMENT ON TABLE CLIENTS IS 'Таблица для хранения информации о клиентах';

COMMENT ON COLUMN CLIENTS.CLIENT_ID IS 'Уникальный идентификатор клиента';
COMMENT ON COLUMN CLIENTS.NAME IS 'Имя клиента';
