import project.db.DataBase;
import project.enums.Brand;
import project.model.Contact;
import project.model.Phone;
import project.serviceImpl.ContactServiceImpl;
import project.serviceImpl.PhoneServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        /** Жаны проект тузунуз.
         3 пакет тузунуз model, db, service.
         model пакеттин ичине Phone жана Contact деген класс тузунуз.
         Phone (id, name, brand, contacts(List)) полелери болуш керек.
         Contact (name, phoneNumber).
         db пакеттин ичинде DataBase класс бар, свойствасы катары телефондордун листин алат,
         бул класс бизге база данных болот.
         service пакет ичинде PhoneService жана ContactService interface тер болот.
         Ушул 2 interface ти implements кылган 2 класс тузунуз(PhoneServiceImpl жана ContactServiceImpl)
         ушул 2 класстын ичине свойства катары биздин DataBase класс келсин жана маалыматтарды ошол жактан
         алып, сактап, очуруп жана башка манипуляция кылсак болот
         PhoneService methods :
         - String addPhone(Phone phone);
         // with stream
         - Phone getPhoneById(int phoneId);
         // with stream
         - Phone updatePhoneNameById(int phoneId, String newName);
         // with stream
         - List<Phone> getAllPhones();
         // with stream
         - List<Phone> getAllPhonesByBrand(String brand);
         - void deletePhoneById(int phoneId);
         10. ContactService methods :
         String addContactToPhone(int phoneId, Contact contact);
         // with stream (телефонду phoneId мн табып, ичинен контантактардын  арасынан contactName мн табып
         кайтарып берсин)
         Contact findContactByName(int phoneId, String contactName);
         // with stream
         Contact findContactByPhoneNumber(int phoneId, String phoneNumber);
         // with stream (телефонду phoneId мн табып, ичинен контантактарды аттарын осуу тартибинде чыгарып берсин)
         List<Contact>sortContactsByName(int phoneId);
         void deleteContactByNameFromPhone(int phoneId, String contactName);*/
        List<Contact> contacts = new ArrayList<>(List.of(
                new Contact("Erjigit", 501232132L),
                new Contact("Baku", 5012233L),
                new Contact("Bilal", 50132132L)));
        List<Contact>contacts1=new ArrayList<>(List.of(
                new Contact("Nurik ake",15553L),
                new Contact("Aizada",1553L)));

        Phone phone = new Phone(1L, "Samsung", Brand.GALAXY, contacts);
        List<Phone>phones=new ArrayList<>(List.of(
                new Phone(2L,"Iphone",Brand.PRO,contacts1),
                new Phone(3L,"Xiomi",Brand.REDMI,contacts1),
                new Phone(5L,"Xiomi1",Brand.REDMI,contacts1),
                new Phone(6L,"Xiomi2",Brand.REDMI,contacts1),
                new Phone(7L,"Xiomi3",Brand.REDMI,contacts1),
                new Phone(4L,"Oppo",Brand.SE,contacts1)));
        Contact contact=new Contact("Asan",2323112L);
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1=new Scanner(System.in);
        int n;
        int z=scanner.nextInt();
        DataBase dataBase = new DataBase();
        PhoneServiceImpl phoneService = new PhoneServiceImpl(dataBase);
        ContactServiceImpl contactService=new ContactServiceImpl(dataBase);
        System.out.println("************");

        System.out.println("------------");
        System.out.println(phoneService.getPhoneById(1L));
        while (true) {

            switch (n = scanner.nextInt()) {
                case 1:System.out.println("Method add phone ");
                System.out.println(phoneService.addPhone(phone));
                break;
                case 2:
                    System.out.println("Method addAll phones");
                    System.out.println(phoneService.addPhones(phones));
                    break;
                case 3:
                    System.out.println("Get phone by id ");
                    System.out.println(phoneService.getPhoneById(2L));
                    break;
                case 4:
                    System.out.println("Delete phone by id");
                    phoneService.deletePhoneById(4L);
                    break;
                case 5:
                    System.out.println("Get all phones");
                    System.out.println(phoneService.getAllPhones());
                    break;
                case 6:
                    System.out.println("Get all phones by brand");
                    System.out.println(phoneService.getAllPhonesByBrand(Brand.REDMI));
                    break;
                case 7:
                    System.out.println("Update phone ");
                    System.out.println(phoneService.updatePhoneNameById(7L, "Meuzu"));
                    break;
                case 8:

                    int number;
                    do {
                        Scanner scanner2 = new Scanner(System.in);
                        number=scanner2.nextInt();
                        switch (number)
                        {
                            case 1:
                                System.out.println("Add contact to phone");
//                                System.out.println("write idPhone");
//                                Long idPhone=scanner2.nextLong();
//                                scanner2.hasNextLong();
//                                System.out.println("write contactName");
//                                String nameContact=scanner2.nextLine();
//                                System.out.println("write contactPhoneNumber");
//                                scanner2.hasNextLine();
//                                Long phoneNumber=scanner2.nextLong();
                                System.out.println(contactService.addContactToPhone(2L,contact));
                                break;
                            case 2:
//
////                                System.out.println("write id ");
////                                Long id=scanner.nextLong();
////                                scanner.hasNextLong();
//                                System.out.println("write contact name ");
//                                String contactName=scanner2.nextLine();
                                System.out.println("Add contacts to Phone-AddAll");
                                System.out.println(contactService.addContactsToPhone(2L, contacts));
                                break;
                            case 3:
                                System.out.println("Find contact by name");
                                System.out.println(contactService.findContactByName(2L, "Asan"));
                                break;

                            case 4: System.out.println("Find contact by phoneNumber");
                                System.out.println(contactService.findContactByPhoneNumber(2L, 2323112L));
                                break;

                            case 5:  System.out.println("Sort contact ByName");
                                System.out.println(contactService.sortContactsByName(2L));
                                break;

                            case 6:  System.out.println("Delete contact by nameContact");
                                contactService.deleteContactByNameFromPhone(2L,"Aizada");
                                break;
                            case 7:
                                System.out.println("Get all contacts by PhoneId");
                                System.out.println(contactService.getAllContactByPhoneId(2L));
                                break;
                        }
                }while (number!=8);



            }
        }
    }
}