package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuddyInfoTest {
    @Test
    void testGetters() {
        BuddyInfo buddy = new BuddyInfo("Alice", "613-555-1234", "alice@example.com", "123 Main St");

        assertEquals("Alice", buddy.getName());
        assertEquals("613-555-1234", buddy.getPhoneNumber());
        assertEquals("alice@example.com", buddy.getEmail());
        assertEquals("123 Main St", buddy.getAddress());
    }

    @Test
    void testSetters() {
        BuddyInfo buddy = new BuddyInfo("Alice", "613-555-1234", "alice@example.com", "123 Main St");

        buddy.setName("Alicia");
        buddy.setEmail("alicia@example.com");

        assertEquals("Alicia", buddy.getName());
        assertEquals("alicia@example.com", buddy.getEmail());
    }

}