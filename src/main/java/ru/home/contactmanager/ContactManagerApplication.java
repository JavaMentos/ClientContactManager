package ru.home.contactmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Класс ContactManager представляет точку входа в приложение.
 * Он использует аннотации Spring Boot для настройки и запуска приложения.
 */
@SpringBootApplication
public class ContactManagerApplication {
    /**
     * Метод main является точкой входа в приложение.
     *
     * @param args массив строковых аргументов командной строки
     */
    public static void main(String[] args) {
        SpringApplication.run(ContactManagerApplication.class, args);
    }
}
