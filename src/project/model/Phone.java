package project.model;

import project.enums.Brand;

import java.util.List;

public class Phone {
    private Long id;
    private String name ;
    private Brand brand;
    private List<Contact>contacts;

    public Phone(Long id, String name, Brand brand, List<Contact> contacts) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.contacts = contacts;
    }

    public Phone() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "<<Phone>>" +
                "\nid: " + id +
                "\nname: '" + name +
                "\nbrand: " + brand +
                "\ncontacts: " + contacts;
    }
}
