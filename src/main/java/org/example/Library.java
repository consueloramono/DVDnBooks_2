package org.example;

import java.util.ArrayList;
import java.util.List;

public class Library implements IManageable {
    private List<Item> items;
    private List<Patron> patrons;

    public Library() {
        this.items = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    public void registerPatron(Patron patron) {
        patrons.add(patron);
        System.out.println("Patron registered: " + patron.getName());
    }

    public void lendItem(Patron patron, Item item) {
        if (items.contains(item) && !item.isBorrowed()) {
            patron.borrow(item);
            item.borrowItem();
        } else {
            System.out.println("Item not available for borrowing.");
        }
    }

    public void returnItem(Patron patron, Item item) {
        if (patron.getBorrowedItems().contains(item)) {
            patron.returnItem(item);
            item.returnItem();
        } else {
            System.out.println("Patron did not borrow this item from the library.");
        }
    }

    @Override
    public void add(Item item) {
        items.add(item);
        System.out.println("Item added to the library: " + item.getTitle());
    }

    @Override
    public void remove(Item item) {
        items.remove(item);
        System.out.println("Item removed from the library: " + item.getTitle());
    }

    public List<Patron> getPatrons() {
        return patrons;
    }

    @Override
    public void listAvailable() {
        System.out.println("Available items in the library:");
        for (Item item : items) {
            if (!item.isBorrowed()) {
                System.out.println(item.getTitle());
            }
        }
    }

    @Override
    public void listBorrowed() {
        System.out.println("Borrowed items in the library:");
        for (Item item : items) {
            if (item.isBorrowed()) {
                System.out.println(item.getTitle());
            }
        }
    }
}