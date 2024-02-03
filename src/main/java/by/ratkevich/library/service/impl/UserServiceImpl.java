package by.ratkevich.library.service.impl;

import by.ratkevich.library.dao.UserDAO;
import by.ratkevich.library.dao.impl.ProviderDAO;
import by.ratkevich.library.service.UserService;

public class UserServiceImpl implements UserService {

    private static ProviderDAO providerDAO = ProviderDAO.getInstance();

    public boolean authorisation (String userName, String password, boolean isAdmin) {

        UserDAO userDAO = providerDAO.getUserDAO();
        return userDAO.authorisation(userName, password, isAdmin);
    }

    public boolean registration (String userName, String password, boolean isAdmin) {

        UserDAO userDAO = providerDAO.getUserDAO();
        return userDAO.registration(userName, password, isAdmin);
    }
}
