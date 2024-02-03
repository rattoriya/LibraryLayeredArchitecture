package by.ratkevich.library.service.impl;

import by.ratkevich.library.dao.BookDAO;
import by.ratkevich.library.dao.impl.ProviderDAO;
import by.ratkevich.library.service.BookService;

public class BookServiceImpl implements BookService {

    private static ProviderDAO providerDAO = ProviderDAO.getInstance();

    public void addBook( String bookName, String bookAuthor) {

        BookDAO bookDAO =  providerDAO.getBookDAO();

        bookDAO.addBook(bookName, bookAuthor);
    }

    public boolean findBook (String bookName, String bookAuthor) {

        BookDAO bookDAO =  providerDAO.getBookDAO();

        return bookDAO.findBook(bookName, bookAuthor);
    }


}
