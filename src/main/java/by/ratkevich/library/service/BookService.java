package by.ratkevich.library.service;

public interface BookService {
    void addBook( String bookName, String bookAuthor);
    boolean findBook (String bookName, String bookAuthor);
}
