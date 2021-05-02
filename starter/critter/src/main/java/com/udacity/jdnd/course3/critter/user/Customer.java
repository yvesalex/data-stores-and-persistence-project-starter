package com.udacity.jdnd.course3.critter.user;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {
    @Id
    private long id;
    private String name;
    private String notes;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Long> petIds;
    private String phoneNumber;

    public Customer() {
    }

    public Customer(long id, String name, String notes, List<Long> petIds, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.notes = notes;
        this.petIds = petIds;
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Long> getPetIds() {
        return petIds;
    }

    public void setPetIds(List<Long> petIds) {
        this.petIds = petIds;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
