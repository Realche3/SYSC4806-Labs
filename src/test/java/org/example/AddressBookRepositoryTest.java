package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressBookRepositoryTest {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Test
    void testCascadePersist() {
        BuddyInfo buddy = new BuddyInfo("Charlie", "613-000-1111", "charlie@example.com", "1 First St");

        AddressBook book = new AddressBook();
        book.addBuddy(buddy);

        AddressBook saved = addressBookRepository.save(book);

        Optional<AddressBook> found = addressBookRepository.findById(saved.getId());

        assertTrue(found.isPresent());
        assertEquals(1, found.get().getBuddies().size());
        assertEquals("Charlie", found.get().getBuddies().get(0).getName());
    }
}