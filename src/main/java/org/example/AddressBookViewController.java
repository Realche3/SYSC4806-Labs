package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AddressBookViewController {

    private final AddressBookRepository repository;

    public AddressBookViewController(AddressBookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/view/addressbook/{id}")
    public String view(@PathVariable Integer id, Model model) {
        AddressBook book = repository.findById(id).orElseThrow();
        model.addAttribute("book", book);
        return "addressbook";
    }
}