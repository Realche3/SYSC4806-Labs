package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BuddyInfoRepositoryTest {

    @Autowired
    private BuddyInfoRepository buddyInfoRepository;

    @Test
    void testSaveAndFindById() {
        BuddyInfo buddy = new BuddyInfo("Alice", "613-555-1234", "alice@example.com", "123 Main St");
        BuddyInfo saved = buddyInfoRepository.save(buddy);

        Optional<BuddyInfo> found = buddyInfoRepository.findById(saved.getId());

        assertTrue(found.isPresent());
        assertEquals("Alice", found.get().getName());
    }

    @Test
    void testFindByName() {
        buddyInfoRepository.save(new BuddyInfo("Bob", "613-555-5678", "bob@example.com", "456 Elm St"));

        List<BuddyInfo> results = buddyInfoRepository.findByName("Bob");

        assertEquals(1, results.size());
        assertEquals("Bob", results.get(0).getName());
    }
}