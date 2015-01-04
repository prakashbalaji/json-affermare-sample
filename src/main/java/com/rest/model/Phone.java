package com.rest.model;

import java.util.List;

import static java.util.Arrays.asList;

public class Phone {

    private String type;
    private Integer number;


    public Phone(String type, Integer number) {
        this.type = type;
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public Integer getNumber() {
        return number;
    }

}
