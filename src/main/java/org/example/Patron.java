package org.example;

import java.util.ArrayList;
import java.util.List;

public class Patron {
    private String name;
    private String ID;
    private List<Item> borrowedItems;

    public Patron(String name, String ID) {
        this.name = name;
        this.ID = ID;
        this.borrowedItems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public List<Item> getBorrowedItems() {
        return borrowedItems;
    }

    public void borrow(Item item) {
        borrowedItems.add(item);
        System.out.println(getName() + " borrowed " + item.getTitle());
    }

    public void returnItem(Item item) {
        borrowedItems.remove(item);
        System.out.println(getName() + " returned " + item.getTitle());
    }
}