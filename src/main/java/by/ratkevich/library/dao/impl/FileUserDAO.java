package by.ratkevich.library.dao.impl;

import by.ratkevich.library.dao.UserDAO;
import by.ratkevich.library.bean.User;

import java.io.*;
import java.util.HashMap;

public class FileUserDAO implements UserDAO {

    private HashMap<String, String> users;

    private String fileName = "Users.txt";

    public FileUserDAO () {

        users = new HashMap <>();
        readUsersFromFile ();
    }

    public boolean authorisation (String userName, String password, boolean isAdmin) {

        User user = isLoginCorrect (userName, password, isAdmin);

        if (user != null) {
            return true;
        }
        return false;

    }
    public boolean registration (String userName, String password, boolean isAdmin) {

        return addUser (userName, password, isAdmin);
    }


    public boolean addUser (String userName, String password, boolean isAdmin) {

        User user = new User (userName, password.hashCode(), isAdmin);

        if (!users.containsKey(userName)) {

            users.put(userName, password.hashCode() + "|" + isAdmin);
            writeUserToFile(user);

            return true;
        }
        else {
            return false;
        }

    }

    public void readUsersFromFile () {

        String userName;
        int passwordHash;
        boolean isAdmin;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String[] buffer;

            while ((line = reader.readLine()) != null) {
                buffer = line.split("\\|");

                userName = buffer[0];
                passwordHash = Integer.parseInt(buffer[1]);
                isAdmin = Boolean.parseBoolean(buffer[2]);

                users.put(userName , passwordHash + "|" + isAdmin );
            }

        } catch (IOException e) {}

    }

    public void writeUserToFile (User user) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {

            writer.write(user.getUserName() + "|" + user.getPasswordHash() + "|" + user.getIsAdmin() + "\n");

        } catch (IOException e) {}

    }


    public User isLoginCorrect (String userName, String password, boolean isAdmin) {

        if (!users.containsKey(userName)) {
            return null;
        }

        if (! users.get(userName).equals(password.hashCode()+"|"+isAdmin)) {
            return null;
        }

        return new User (userName, password.hashCode(),isAdmin);
    }

}
