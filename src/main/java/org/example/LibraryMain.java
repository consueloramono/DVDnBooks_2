package org.example;

public class LibraryMain {

    public static void main(String[] args) {
        // Створення об'єктів книг та DVD
        Book book1 = new Book("Introduction to Java", "B001", "John Doe");
        DVD dvd1 = new DVD("Java Basics", "D001", 120);

        // Створення об'єктів читачів
        Patron patron1 = new Patron("Alice", "P001");
        Patron patron2 = new Patron("Bob", "P002");

        // Створення бібліотеки
        Library library = new Library();

        // Реєстрація читачів у бібліотеці
        library.registerPatron(patron1);
        library.registerPatron(patron2);

        // Додавання книг та DVD до бібліотеки
        library.add(book1);
        library.add(dvd1);

        // Список доступних елементів у бібліотеці
        library.listAvailable();

        // Читачі беруть та повертають елементи
        library.lendItem(patron1, book1);
        library.lendItem(patron2, dvd1);

        library.listBorrowed();

        library.returnItem(patron1, book1);
        library.returnItem(patron2, dvd1);

        library.listBorrowed();
    }
}
