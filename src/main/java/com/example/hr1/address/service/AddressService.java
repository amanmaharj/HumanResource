package com.example.hr1.address.service;

import com.example.hr1.address.domain.Address;
import com.example.hr1.address.doa.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    AddressService(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }
    public Address save(Address address) {
       return addressRepository.save(address);
    }

    public List<Address> getAddress() {
        return addressRepository.findAll();
    }

    public Address getAddressById(Long id) {
        Optional<Address> addressOptional = addressRepository.findById(id);

        if(addressOptional.isPresent()){

           return addressOptional.get();

        }

        return null;

    }

    public void deleteById(long id) {
        addressRepository.deleteById(id);
    }

//    public Address updateAddress(Address address) {
//        return addressRepository.save(address);
//    }

    public Address editAddress(long id, Address address) {
        Optional<Address> existingAddress = addressRepository.findById(id);

        Address address1 = existingAddress.get();
        if(existingAddress.isPresent()){

            address1.setId(id);
            address1.setCity(address.getCity());
            address1.setZip(address.getZip());
            address1.setState(address.getState());
            address1.setStreetName(address.getStreetName());
            address1.setCountry(address.getCountry());
            addressRepository.save(address1);
        }
    return address1;
    }
}
