package com.softserve.itacademy.dao;

import com.softserve.itacademy.model.AddressBook;
import com.softserve.itacademy.model.Person;
import com.softserve.itacademy.model.SortOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AddressBookDAOImpl implements AddressBookDAO {
    private List<AddressBook> addressBooks;
    private int counter = 0;


    private AddressBookDAOImpl(int size) {
        addressBooks = new ArrayList<>(size);
    }

    @Override
    public boolean create(String firstName, String lastName, String address) {
        Person person = new Person(firstName, lastName);
        for (AddressBook addressBook : addressBooks) {
            if (addressBook.getPerson().equals(person)) {
                return false;
            }
        }
        addressBooks.add(counter++, new AddressBook(person, address));
        return true;
    }

    @Override
    public AddressBook read(String id) {
        return addressBooks
                .stream()
                .filter(person -> person.getId()
                        .equals(id))
                .collect(Collectors.toList())
                .get(0);
    }

    @Override
    public boolean update(String firstName, String lastName, String address) {
        Person person = new Person(firstName, lastName);
        for (int i = 0; i < counter; i++) {
            if (addressBooks.get(i).getPerson().equals(person)) {
                addressBooks.get(i).setAddress(address);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if (addressBooks.stream().noneMatch(p -> p.getId().equals(id))) {
            return false;
        }
        addressBooks = addressBooks
                .stream()
                .filter(p -> !p.getId()
                        .equals(id))
                .collect(Collectors.toList());
        counter--;
        return true;
    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    public void sortedBy(SortOrder order) {
        switch (order) {
            case ASC:
                addressBooks.sort((pair1, pair2) -> {
                    if (pair1 == null || pair2 == null) return 0;
                    return pair1.getPerson().getFirstName().compareTo(pair2.getPerson().getFirstName()) == 0 ?
                            pair1.getPerson().getLastName().compareTo(pair2.getPerson().getLastName()) :
                            pair1.getPerson().getFirstName().compareTo(pair2.getPerson().getFirstName());
                });
                break;
            case DESC:
                addressBooks.sort((pair1, pair2) -> {
                    if (pair1 == null || pair2 == null) return 0;
                    return pair1.getPerson().getFirstName().compareTo(pair2.getPerson().getFirstName()) == 0 ?
                            -pair1.getPerson().getLastName().compareTo(pair2.getPerson().getLastName()) :
                            -pair1.getPerson().getFirstName().compareTo(pair2.getPerson().getFirstName());
                });
        }
    }


    private static AddressBookDAOImpl addressBookInstance = null;

    public static AddressBookDAOImpl getInstance() {
        if (addressBookInstance == null) {
            addressBookInstance = new AddressBookDAOImpl(5);
        }
        return addressBookInstance;
    }

    @Override
    public List<AddressBook> getAddressBooks() {
        return addressBooks;
    }


}
