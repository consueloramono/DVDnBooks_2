package org.example;

public class DVD extends Item {
    private int duration;

    public DVD(String title, String uniqueID, int duration) {
        super(title, uniqueID);
        this.duration = duration;
    }

    @Override
    public void borrowItem() {
        if (!isBorrowed()) {
            setBorrowed(true);
            System.out.println("DVD borrowed: " + getTitle());
        } else {
            System.out.println("DVD is already borrowed.");
        }
    }

    @Override
    public void returnItem() {
        if (isBorrowed()) {
            setBorrowed(false);
            System.out.println("DVD returned: " + getTitle());
        } else {
            System.out.println("DVD is not borrowed.");
        }
    }
}
