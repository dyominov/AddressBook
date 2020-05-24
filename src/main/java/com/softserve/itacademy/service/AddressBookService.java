package com.softserve.itacademy.service;

import com.softserve.itacademy.model.AddressBook;
import com.softserve.itacademy.model.SortOrder;

import java.util.List;

public interface AddressBookService {
    boolean create(String firstName, String lastName, String address);

    AddressBook read(String id);

    boolean update(String firstName, String lastName, String address);

    boolean delete(String id);

    int size();

    void sortedBy(SortOrder order);

    List<AddressBook> getAddressBooks();
}
