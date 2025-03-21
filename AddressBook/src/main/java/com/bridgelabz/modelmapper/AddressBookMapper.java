package com.bridgelabz.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bridgelabz.dto.AddressBookDTO;
import com.bridgelabz.model.AddressBook;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddressBookMapper {

	@Autowired
    private final ModelMapper modelMapper;

    public AddressBookMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public AddressBookDTO toDto(AddressBook addressBook) {
        return modelMapper.map(addressBook, AddressBookDTO.class);
    }

    public List<AddressBookDTO> toDtoList(List<AddressBook> addressBooks) {
        return addressBooks.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public AddressBook toEntity(AddressBookDTO addressBookDTO) {
        return modelMapper.map(addressBookDTO, AddressBook.class);
    }
}
