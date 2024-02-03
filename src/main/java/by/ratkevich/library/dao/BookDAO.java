package by.ratkevich.library.dao;

public interface BookDAO {

    void addBook( String bookName, String bookAuthor);
    boolean findBook (String bookName, String bookAuthor);
}
