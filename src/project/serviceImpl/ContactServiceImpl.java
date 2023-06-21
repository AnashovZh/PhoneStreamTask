package project.serviceImpl;

import project.db.DataBase;
import project.model.Contact;
import project.model.Phone;
import project.service.ContactService;

import java.util.Comparator;
import java.util.List;

public class ContactServiceImpl implements ContactService {
    private DataBase dataBase;

    public ContactServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String addContactToPhone(Long phoneId, Contact contact) {
        for (Phone p : dataBase.getPhones()) {
            if (p.getId().equals(phoneId)) {
                p.getContacts().add(contact);

            }
        }
        return "Phongo contact saved";
    }

    @Override
    public String addContactsToPhone(Long phoneId, List<Contact> contacts) {
        for (Phone p:dataBase.getPhones()) {
            if (p.getId().equals(phoneId)){
                p.getContacts().addAll(contacts);
            }
        }
        return"Phone contacts saved";
    }

    @Override
    public Contact findContactByName(Long phoneId, String contactName) {
        List<Phone> list = dataBase.getPhones().stream().filter(phone -> phone.getId().equals(phoneId)).toList();
        List<Contact> list1 = list.get(0).getContacts().stream().filter(contact -> contact.getName().equals(contactName)).toList();
//        Contact contact = new Contact();
//        for (Contact x : list1) {
//            if (x.getName().equals(contactName)) {
//                contact.setName(x.getName());
//                contact.setPhoneNumber(x.getPhoneNumber());
//            }
//        }
        Contact contact=(Contact) list1.get(0);
        return contact;
    }

    @Override
    public Contact findContactByPhoneNumber(Long phoneId, Long phoneNumber) {
        List<Phone> list = dataBase.getPhones().stream().filter(phone -> phone.getId().equals(phoneId)).toList();
        List<Contact> list1 = list.get(0).getContacts().stream().filter(contact -> contact.getPhoneNumber().equals(phoneNumber)).toList();
        Contact contact = new Contact();
        for (Contact c : list1) {
            if (c.getPhoneNumber().equals(phoneNumber)) {
                contact.setName(c.getName());
                contact.setPhoneNumber(c.getPhoneNumber());
            }
        }
        return contact;
    }

    @Override
    public List<Contact> sortContactsByName(Long phoneId) {
        List<Phone> list = dataBase.getPhones().stream().filter(phone -> phone.getId().equals(phoneId)).toList();
        List<Contact> list1 = list.get(0).getContacts().stream().sorted(Comparator.comparing(Contact::getName)).toList();
        return list1;
    }

    @Override
    public void deleteContactByNameFromPhone(Long phoneId, String contactName) {
        for (Phone p : dataBase.getPhones()) {
            if (p.getId().equals(phoneId)) {
                p.getContacts().removeIf(contact -> contact.getName().equals(contactName));
                System.out.println("Deleted contact");
            }
        }
    }

    @Override
    public List<Contact> getAllContactByPhoneId(Long phoneId) {
        List<Phone> list = dataBase.getPhones().stream().filter(phone -> phone.getId().equals(phoneId)).toList();
        List<Contact> list1 = list.get(0).getContacts().stream().toList();
        return list1;
    }
}
