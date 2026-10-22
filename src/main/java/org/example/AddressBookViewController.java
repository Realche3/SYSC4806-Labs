package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddressBookViewController {

    private final AddressBookRepository bookRepo;
    private final BuddyInfoRepository buddyRepo;

    public AddressBookViewController(AddressBookRepository bookRepo, BuddyInfoRepository buddyRepo) {
        this.bookRepo = bookRepo;
        this.buddyRepo = buddyRepo;
    }

    // Root page: list all address books
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("books", bookRepo.findAll());
        return "index";
    }

    // Button: create a new address book, then go back to root
    @PostMapping("/view/addressbook")
    public String createBook() {
        bookRepo.save(new AddressBook());
        return "redirect:/";
    }

    // Page listing one book's buddies
    @GetMapping("/view/addressbook/{id}")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("book", bookRepo.findById(id).orElseThrow());
        return "addressbook";
    }

    // Form: add a buddy, then reload the same page
    @PostMapping("/view/addressbook/{bookId}/buddy")
    public String addBuddy(@PathVariable Integer bookId, @ModelAttribute BuddyInfo buddy) {
        AddressBook book = bookRepo.findById(bookId).orElseThrow();
        buddy.setAddressBook(book);
        buddyRepo.save(buddy);
        return "redirect:/view/addressbook/" + bookId;
    }
}