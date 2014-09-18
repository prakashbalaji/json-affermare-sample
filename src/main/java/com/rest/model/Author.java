package com.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Author {
    private Integer id;
    private String name;

    private List<Phone> phoneNumbers;

    public Author() {
    }

    public Author(Integer id, String name, List<Phone> phoneNumbers) {
        this.id = id;
        this.name = name;
        this.phoneNumbers = phoneNumbers;
    }

    @JsonProperty
    public Integer getId() {
        return id;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    public List<Phone> getPhoneNumbers() {
        return phoneNumbers;
    }
}
