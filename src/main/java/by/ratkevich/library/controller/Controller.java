package by.ratkevich.library.controller;

import by.ratkevich.library.presentation.AdminConsole;
import by.ratkevich.library.presentation.UserConsole;
import by.ratkevich.library.presentation.Viewer;
import by.ratkevich.library.service.UserService;
import by.ratkevich.library.service.impl.ProviderService;

public class Controller {

    public void doAction (String request) {

        String [] params;
        String commandName;
        String userName;
        String password;
        String admin;
        boolean isAdmin;
        boolean result;

        params =  request.split(" ");

        commandName = params[0];
        userName = params[1];
        password = params[2];
        admin = params[3];

        if (admin.equals("1")) {

            isAdmin = true;
        }
        else {
            isAdmin = false;
        }

        ProviderService provider = ProviderService.getInstance();
        UserService userService = provider.getUserService();

        switch (commandName) {
            case "1":

                result = userService.authorisation( userName, password, isAdmin);
                break;

            case "2":

                result = userService.registration(userName, password, isAdmin);
                break;

            default: result = false;
        }

        Viewer.answer(result);

        if (!result) return;

        if (isAdmin) {
            AdminConsole adminConsole = new AdminConsole();
            adminConsole.getAdminConsole();
        }
        else {
            UserConsole userConsole = new UserConsole();
            userConsole.getUserConsole(userName);
        }
    }

}
