package project.db;

import project.model.Phone;

import java.util.ArrayList;

public class DataBase {
    private ArrayList<Phone>phones=new ArrayList<>();

    public ArrayList<Phone> getPhones() {
        return phones;
    }

    public void setPhones(ArrayList<Phone> phones) {
        this.phones = phones;
    }
}
