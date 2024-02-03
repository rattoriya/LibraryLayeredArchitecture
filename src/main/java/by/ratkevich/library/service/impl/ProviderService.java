package by.ratkevich.library.service.impl;

import by.ratkevich.library.service.BookService;
import by.ratkevich.library.service.EmailService;
import by.ratkevich.library.service.UserService;

public class ProviderService {

    private static ProviderService instance = new ProviderService();

    private UserService userService = new UserServiceImpl();
    private BookService bookService = new BookServiceImpl();
    private EmailService emailService = new EmailServiceImpl();

    private ProviderService() {}

    public static ProviderService getInstance () {
        return instance;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public EmailService getEmailService() {
        return emailService;
    }

    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }
}
