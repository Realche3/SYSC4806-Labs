package org.example;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class BuddyInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private AddressBook addressBook;

    private String name;
    private String phoneNumber;
    private String email;
    private String address;

    public BuddyInfo() {

    }
    public BuddyInfo(String name, String phoneNumber, String email, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    @Override
    public String toString() {
        return "BuddyInfo{name='" + name + "', phone='" + phoneNumber +
                "', email='" + email + "', address='" + address + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BuddyInfo)) return false;
        BuddyInfo other = (BuddyInfo) o;
        return Objects.equals(name, other.name) &&
                Objects.equals(phoneNumber, other.phoneNumber) &&
                Objects.equals(email, other.email) &&
                Objects.equals(address, other.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber, email, address);
    }

    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
    }
    public AddressBook getAddressBook() {
        return addressBook;
    }
}
