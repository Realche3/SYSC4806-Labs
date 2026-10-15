package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.client.RestTestClient;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureRestTestClient
class AddressBookRestTest {

    @Autowired
    private RestTestClient client;

    @Test
    void createAddressBook() {
        client.post()
                .uri("/addressBooks")
                .contentType(MediaType.APPLICATION_JSON)
                .body("{}")
                .exchange()
                .expectStatus().isCreated();
    }

    @Autowired
    private AddressBookRepository bookRepo;

    @Autowired
    private BuddyInfoRepository buddyRepo;

    @Test
    void createBuddy() {
        String json = """
        {
          "name": "Alice",
          "phoneNumber": "613-555-1234",
          "email": "alice@example.com",
          "address": "123 Main St"
        }
        """;

        client.post()
                .uri("/buddies")
                .contentType(MediaType.APPLICATION_JSON)
                .body(json)
                .exchange()
                .expectStatus().isCreated();
    }

    @Test
    void linkBuddyToBookAndListIt() {
        // set up one book and one buddy directly, so we know their ids
        AddressBook book = bookRepo.save(new AddressBook());
        BuddyInfo buddy = buddyRepo.save(
                new BuddyInfo("Mohamed Cherif", "613-000-0000", "cherif@example.com", "1456 Beautiful St"));

        // PUT: link the buddy to the book (same as request 3a in requests.http)
        client.put()
                .uri("/buddies/" + buddy.getId() + "/addressBook")
                .contentType(MediaType.parseMediaType("text/uri-list"))
                .body("http://localhost/addressBooks/" + book.getId())
                .exchange()
                .expectStatus().isNoContent();

        // GET: the book's buddies should now include Mohamed (same as request 4)
        client.get()
                .uri("/addressBooks/" + book.getId() + "/buddies")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .value(body -> assertTrue(body.contains("Mohamed Cherif")));
    }

    @Test
    void buddyGenderIsReturned() {
        BuddyInfo buddy = new BuddyInfo("Sarah", "613-111-2222", "sarah@example.com", "5 Test Ave");
        buddy.setGender("Female");
        BuddyInfo saved = buddyRepo.save(buddy);

        client.get()
                .uri("/buddies/" + saved.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .value(body -> assertTrue(body.contains("Female")));
    }
}