package com.bridgelabz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bridgelabz.dto.AddressBookDTO;
import com.bridgelabz.model.AddressBook;
import com.bridgelabz.modelmapper.AddressBookMapper;
import com.bridgelabz.repository.AddressBookRepository;
import java.util.List;

@Service
public class AddressBookService {

	@Autowired
    private final AddressBookRepository addressBookRepository;
	@Autowired
    private final AddressBookMapper addressBookMapper;

    public AddressBookService(AddressBookRepository addressBookRepository, AddressBookMapper addressBookMapper) {
        this.addressBookRepository = addressBookRepository;
        this.addressBookMapper = addressBookMapper;
    }

    public List<AddressBookDTO> getAllAddressBook() {
        List<AddressBook> addressBooks = addressBookRepository.findAll();
        return addressBookMapper.toDtoList(addressBooks);
    }

    public AddressBookDTO getAddressBookById(Long id) {
        AddressBook addressBook = addressBookRepository.findById(id).orElse(null);
        return addressBookMapper.toDto(addressBook);
    }

    public AddressBookDTO createAddressBook(AddressBookDTO addressBookDTO) {
        AddressBook addressBook = addressBookMapper.toEntity(addressBookDTO);
        AddressBook savedAddressBook = addressBookRepository.save(addressBook);
        return addressBookMapper.toDto(savedAddressBook);
    }

    public AddressBookDTO updateAddressBook(Long id, AddressBookDTO addressBookDTO) {
        AddressBook addressBook = addressBookRepository.findById(id).orElse(null);
        if (addressBook != null) {
            addressBook.setFirstName(addressBookDTO.getFirstName());
            addressBook.setLastName(addressBookDTO.getLastName());
            addressBook.setAddress(addressBookDTO.getAddress());
            addressBook.setCity(addressBookDTO.getCity());
            addressBook.setState(addressBookDTO.getState());
            addressBook.setZip(addressBookDTO.getZip());
            AddressBook savedAddressBook = addressBookRepository.save(addressBook);
            return addressBookMapper.toDto(savedAddressBook);
        } else {
            return null;
        }
    }

    public void deleteAddressBook(Long id) {
        addressBookRepository.deleteById(id);
    }
}
