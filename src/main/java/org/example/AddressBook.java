package org.example;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "addressBook", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<BuddyInfo> buddies;



    public AddressBook() {
        this.buddies = new ArrayList<>();
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public void addBuddy(BuddyInfo buddy) {
        if (buddy == null) {
            throw new IllegalArgumentException("Buddy cannot be null");
        }
        buddies.add(buddy);
        buddy.setAddressBook(this);
    }

    public boolean removeBuddy(BuddyInfo buddy) {
        boolean removed = buddies.remove(buddy);
        if (removed) {
            buddy.setAddressBook(null);
        }
        return removed;
    }

    public int size() {
        return buddies.size();
    }

    public List<BuddyInfo> getBuddies() {
        return new ArrayList<>(buddies);
    }

    public void printAll() {
        for (BuddyInfo b : buddies) {
            System.out.println(b);
        }
    }
}