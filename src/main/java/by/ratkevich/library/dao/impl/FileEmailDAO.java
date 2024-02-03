package by.ratkevich.library.dao.impl;

import by.ratkevich.library.bean.Email;
import by.ratkevich.library.dao.EmailDAO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileEmailDAO implements EmailDAO {

    private String fileName = "Emails.txt";

    public  void addEmail (Email email) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {

            writer.write(email.getUserName()+ "|" + email.getBook().getBookName() + "|" + email.getBook().getBookAuthor() + "|" + email.getBook().getBookType() + "\n");

        } catch (IOException e) {}

    }
}
