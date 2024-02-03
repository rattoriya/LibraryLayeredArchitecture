package by.ratkevich.library.service.impl;

import by.ratkevich.library.bean.Email;
import by.ratkevich.library.dao.BookDAO;
import by.ratkevich.library.dao.EmailDAO;
import by.ratkevich.library.dao.impl.ProviderDAO;
import by.ratkevich.library.service.EmailService;

public class EmailServiceImpl implements EmailService {

    private static ProviderDAO providerDAO = ProviderDAO.getInstance();

    public void addEmail (Email email) {
        EmailDAO emailDAO =  providerDAO.getEmailDAO();

        emailDAO.addEmail (email);
    }
}
