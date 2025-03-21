package com.bridgelabz.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bridgelabz.dto.AddressBookDTO;
import com.bridgelabz.service.AddressBookService;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    private final AddressBookService addressBookService;

    
    public AddressBookController(AddressBookService addressBookService) {
        this.addressBookService = addressBookService;
    }

    @GetMapping
    public ResponseEntity<List<AddressBookDTO>> getAllAddressBook() {
        return ResponseEntity.ok(addressBookService.getAllAddressBook());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressBookDTO> getAddressBookById(@PathVariable Long id) {
        return ResponseEntity.ok(addressBookService.getAddressBookById(id));
    }

    @PostMapping
    public ResponseEntity<AddressBookDTO> createAddressBook(@RequestBody AddressBookDTO addressBookDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressBookService.createAddressBook(addressBookDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressBookDTO> updateAddressBook(@PathVariable Long id, @RequestBody AddressBookDTO addressBookDTO) {
        return ResponseEntity.ok(addressBookService.updateAddressBook(id, addressBookDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAddressBook(@PathVariable Long id) {
        addressBookService.deleteAddressBook(id);
        return ResponseEntity.noContent().build();
    }
}
