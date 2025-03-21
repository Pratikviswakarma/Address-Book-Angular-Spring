package com.bridgelabz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.model.AddressBook;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook, Long> {
}
