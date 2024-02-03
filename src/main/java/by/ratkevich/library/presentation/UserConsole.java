package by.ratkevich.library.presentation;

import by.ratkevich.library.bean.BookType;
import by.ratkevich.library.bean.Book;
import by.ratkevich.library.bean.Email;
import by.ratkevich.library.service.BookService;
import by.ratkevich.library.service.EmailService;
import by.ratkevich.library.service.impl.ProviderService;

import java.util.Scanner;
import static by.ratkevich.library.bean.BookType.ELECTRONICBOOK;

public class UserConsole {

    public void getUserConsole(String userName) {

        Scanner scanner = new Scanner (System.in);
        ProviderService provider = ProviderService.getInstance();
        int choice;

        while (true) {

            do {
                System.out.println(
                        "1 - Поиск книги в каталоге\n" +
                                "2 - Предложить добавить книгу\n" +
                                "0 - Выход из библиотеки");

                while (!scanner.hasNextInt()) {
                    scanner.nextLine();
                }

                choice = scanner.nextInt();

                scanner.nextLine();

            } while (choice < 0 || choice > 3);

            switch (choice) {

                case 1:

                    String bookName;
                    String bookAuthor;

                    System.out.println("Введите название книги, которую вы ищете:");
                    bookName = scanner.nextLine();

                    System.out.println("Введите автора книги, которую вы ищете:");
                    bookAuthor = scanner.nextLine();

                    BookService bookService = provider.getBookService();

                    if (bookService.findBook(bookName, bookAuthor)) {
                        System.out.println ("Книга найдена в каталоге");
                    }
                    else {
                        System.out.println ("Книги нет в каталоге");
                    }
                    break;

                case 2:

                    BookType bookType = ELECTRONICBOOK;

                    System.out.println("Введите название книги, которую вы предлагаете:");
                    bookName = scanner.nextLine();

                    System.out.println("Введите автора книги, которую вы предлагаете:");
                    bookAuthor = scanner.nextLine();

                    EmailService emailservice = provider.getEmailService();
                    emailservice.addEmail(new Email( userName, new Book (bookName,bookAuthor, ELECTRONICBOOK )));

                    System.out.println ("Книга предложена к добавлению в каталог");
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Ошибка");
            }
        }

    }
}
