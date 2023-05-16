package com.example.hr1.address.controller;

import com.example.hr1.address.domain.Address;
import com.example.hr1.address.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    public AddressService addressService;

    AddressController(AddressService addressService){
        this.addressService = addressService;
    }
    @PostMapping
    public ResponseEntity<Address> setAddress(@RequestBody Address address){
       Address address1 = addressService.save(address);
        return new ResponseEntity(address1, HttpStatus.OK);
    }

    @GetMapping
    public List<Address> getAddress(){
        return addressService.getAddress();
    }

    @GetMapping("{id}")
    public Address getAddressById(@PathVariable("id") long id){
            return addressService.getAddressById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") long id){
         addressService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> editAddress(@PathVariable("id") long id, @RequestBody Address address){
        Address updatedAddress = addressService.editAddress(id, address);
        return ResponseEntity.ok(updatedAddress);


    }

}
