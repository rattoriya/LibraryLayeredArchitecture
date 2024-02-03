package by.ratkevich.library.dao;


public interface UserDAO {

    boolean authorisation (String userName, String password, boolean isAdmin);
    boolean registration (String userName, String password, boolean isAdmin);

}
