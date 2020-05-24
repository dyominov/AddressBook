package com.softserve.itacademy.service;

import com.softserve.itacademy.dao.AddressBookDAO;
import com.softserve.itacademy.dao.AddressBookDAOImpl;
import com.softserve.itacademy.model.AddressBook;
import com.softserve.itacademy.model.SortOrder;

import java.util.List;

public class AddressBookServiceImpl implements AddressBookService {

    AddressBookDAO addressBook;

    public AddressBookServiceImpl() {
        this.addressBook = AddressBookDAOImpl.getInstance();
        addressBook.create("John", "Brown", "Address #1");
        addressBook.create("Susan", "Brown", "Address #4");
        addressBook.create("Karen", "Davis", "Address #2");
        addressBook.create("John", "Taylor", "Address #1");
    }

    @Override
    public boolean create(String firstName, String lastName, String address) {
        return addressBook.create(firstName, lastName, address);
    }

    @Override
    public AddressBook read(String id) {
        return addressBook.read(id);
    }

    @Override
    public boolean update(String firstName, String lastName, String address) {
        return addressBook.update(firstName, lastName, address);
    }

    @Override
    public boolean delete(String id) {
        return addressBook.delete(id);
    }

    @Override
    public int size() {
        return addressBook.size();
    }

    @Override
    public void sortedBy(SortOrder order) {
        addressBook.sortedBy(order);
    }

    @Override
    public List<AddressBook> getAddressBooks() {
        return addressBook.getAddressBooks();
    }
}
