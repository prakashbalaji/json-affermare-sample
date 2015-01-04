package com.rest.model;

import java.util.List;

import static java.util.Arrays.asList;

public class Phone {

    private String type;
    private Integer number;

    private List<Email> emails = asList(new Email("yahoo.com"), new Email("gmail.com"));


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

    public List<Email> getEmails() {
        return emails;
    }

    public static class Email {
        private String provider = "gmail.com";
        private String email = "t@gmail.com";

        public Email(String provider) {
            this.provider = provider;
        }

        public String getProvider() {
            return provider;
        }

        public String getEmail() {
            return email;
        }
    }
}
