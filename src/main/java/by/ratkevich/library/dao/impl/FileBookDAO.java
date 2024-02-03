package by.ratkevich.library.dao.impl;

import by.ratkevich.library.bean.BookType;
import static by.ratkevich.library.bean.BookType.ELECTRONICBOOK;
import by.ratkevich.library.bean.Book;
import by.ratkevich.library.dao.BookDAO;

import java.io.*;
import java.util.ArrayList;

public class FileBookDAO implements BookDAO {

    private ArrayList<Book> books;
    private String fileName = "Books.txt";

    public FileBookDAO () {
        books = new ArrayList <> ();
        readCatalogFromFile();
    }

    public void addBook (String bookName, String bookAuthor) {
        BookType bookType = ELECTRONICBOOK;
        Book book = new Book (bookName, bookAuthor, bookType);
        books.add(book);
        writeBookToFile (book);
    }

    public boolean findBook(String bookName, String bookAuthor) {

        for (Book book: books) {
            if (book.getBookName().equals(bookName)
                    && book.getBookAuthor().equals(bookAuthor))
            {
                return true;
            }
        }
        return false;
    }

    public void readCatalogFromFile () {

        String bookName;
        String bookAuthor;
        BookType bookType;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String[] buffer;

            while ((line = reader.readLine()) != null) {
                buffer = line.split("\\|");

                bookName = buffer[0];
                bookAuthor = buffer[1];
                bookType = BookType.valueOf(buffer[2]);

                books.add(new Book(bookName, bookAuthor, bookType));
            }

        } catch (IOException e) {}
    }

    public void writeBookToFile (Book book) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(book.getBookName() + "|" + book.getBookAuthor() + "|"+ book.getBookType() + "\n");

        } catch (IOException e) {}

    }
}
