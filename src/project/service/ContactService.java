package project.service;

import project.model.Contact;

import java.util.List;

public interface ContactService {
    String addContactToPhone(Long phoneId, Contact contact);
    String addContactsToPhone(Long phoneId,List<Contact>contacts);
    // with stream (телефонду phoneId мн табып, ичинен контантактардын  арасынан contactName мн табып кайтарып берсин)
    Contact findContactByName(Long phoneId, String contactName);
    // with stream
    Contact findContactByPhoneNumber(Long phoneId, Long phoneNumber);
    // with stream (телефонду phoneId мн табып, ичинен контантактарды аттарын осуу тартибинде чыгарып берсин)
    List<Contact> sortContactsByName(Long phoneId);
    void deleteContactByNameFromPhone(Long phoneId, String contactName);
    List<Contact>getAllContactByPhoneId(Long phoneId);
}
