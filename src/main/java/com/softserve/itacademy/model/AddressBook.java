package com.softserve.itacademy.model;

import java.util.Objects;
import java.util.UUID;

public class AddressBook {
    private final String id;
    private final Person person;
    private String address;

    public AddressBook(Person person, String address) {
        this.id = UUID.randomUUID().toString();
        this.person = person;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressBook that = (AddressBook) o;
        return Objects.equals(person, that.person) &&
                Objects.equals(address, that.address);
    }

    public Person getPerson() {
        return person;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, address);
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "person=" + person +
                ", address='" + address + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }
}
