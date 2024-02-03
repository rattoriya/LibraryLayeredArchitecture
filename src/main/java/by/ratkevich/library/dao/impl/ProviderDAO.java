package by.ratkevich.library.dao.impl;

import by.ratkevich.library.dao.BookDAO;
import by.ratkevich.library.dao.EmailDAO;
import by.ratkevich.library.dao.UserDAO;

public class ProviderDAO {

    private static ProviderDAO instance = new ProviderDAO();

    private UserDAO userDAO = new FileUserDAO();
    private BookDAO bookDAO = new FileBookDAO();
    private EmailDAO emailDAO = new FileEmailDAO();

    private ProviderDAO() {}

    public static ProviderDAO getInstance () {
        return instance;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public BookDAO getBookDAO() {
        return bookDAO;
    }

    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public EmailDAO getEmailDAO() {
        return emailDAO;
    }

    public void setEmailDAO(EmailDAO emailDAO) {
        this.emailDAO = emailDAO;
    }
}
