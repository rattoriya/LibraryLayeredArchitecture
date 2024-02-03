package by.ratkevich.library.service;

public interface UserService {
    boolean authorisation (String userName, String password, boolean isAdmin);
    boolean registration (String userName, String password, boolean isAdmin);
}
