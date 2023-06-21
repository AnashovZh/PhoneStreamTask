package project.serviceImpl;

import project.db.DataBase;
import project.enums.Brand;
import project.model.Phone;
import project.service.PhoneService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class PhoneServiceImpl implements PhoneService {
    private DataBase dataBase;

    public PhoneServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String addPhone(Phone phone) {

        dataBase.getPhones().add(phone);
        return "Phone saved";
    }

    @Override
    public String addPhones(List<Phone> phones) {
        dataBase.getPhones().addAll(phones);
        return "Pones saved";
    }

    @Override
    public Phone getPhoneById(Long phoneId) {
        //stream
        Optional<Phone> first = dataBase.getPhones().stream().filter(s -> s.getId().equals(phoneId)).findFirst();
        return first.orElse(null);
    }

    @Override
    public Phone updatePhoneNameById(Long phoneId, String newName) {
        //stream
        List<Phone> list = dataBase.getPhones().stream().filter(phone -> phone.getId().equals(phoneId)).toList();
        list.forEach(phone -> phone.setName(newName));

        Phone phone=new Phone();
        for (Phone p:list) {
            if (p.getId().equals(phoneId)){
                phone.setId(p.getId());
                phone.setName(p.getName());
                phone.setBrand(p.getBrand());
                phone.setContacts(p.getContacts());
            }
        }
//        Phone phoneById = getPhoneById(phoneId);
//        phoneById.setName(newName);
        return phone;
    }

    @Override
    public List<Phone> getAllPhones() {
        //stream
        List<Phone> list = dataBase.getPhones().stream().toList();
        return list;
    }

    @Override
    public List<Phone> getAllPhonesByBrand(Brand brand) {
        //stream
        List<Phone> list = dataBase.getPhones().stream().filter(s -> s.getBrand().equals(brand)).toList();
        return list;
    }

    @Override
    public void deletePhoneById(Long phoneId) {
        dataBase.getPhones().removeIf(phone -> phone.getId().equals(phoneId));
        System.out.println("Uspeshno udalenno");
    }
}
