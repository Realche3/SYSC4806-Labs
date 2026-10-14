package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {
    @Test
    void testAddBuddy(){
        AddressBook addressBook = new AddressBook();
        BuddyInfo Cherif = new BuddyInfo("Mohamed", "1234567890","email@email.com","123 St");
        addressBook.addBuddy(Cherif);

        assertEquals(1,addressBook.size());
    }
    @Test
    void testRemoveBuddy() {
        AddressBook addressBook = new AddressBook();
        BuddyInfo alice = new BuddyInfo("Alice", "613-555-1234", "alice@example.com", "123 Main St");

        addressBook.addBuddy(alice);
        boolean removed = addressBook.removeBuddy(alice);

        assertTrue(removed);
        assertEquals(0, addressBook.size());
    }
}