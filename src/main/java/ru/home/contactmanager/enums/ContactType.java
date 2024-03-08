package ru.home.contactmanager.enums;

import com.fasterxml.jackson.annotation.JsonProperty;


public enum ContactType {
    @JsonProperty("phone")
    PHONE,
    @JsonProperty("email")
    EMAIL
}
