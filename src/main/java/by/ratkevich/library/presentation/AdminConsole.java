package by.ratkevich.library.presentation;

import by.ratkevich.library.bean.Book;
import by.ratkevich.library.bean.BookType;
import by.ratkevich.library.bean.Email;
import by.ratkevich.library.service.BookService;
import by.ratkevich.library.service.EmailService;
import by.ratkevich.library.service.impl.ProviderService;

import java.util.Scanner;
import static by.ratkevich.library.bean.BookType.ELECTRONICBOOK;

public class AdminConsole {

    public void getAdminConsole () {

        Scanner scanner = new Scanner (System.in);
        ProviderService provider = ProviderService.getInstance();
        int choice;

        while (true) {

            do {
                System.out.println(
                        "1 - Найти книгу в каталоге\n" +
                                "2 - Добавить книгу в каталог\n" +
                                "0 - Выйти");

                while (!scanner.hasNextInt()) {
                    scanner.next();
                }

                choice = scanner.nextInt();
                scanner.nextLine();

            } while (choice < 0 || choice > 4);

            String bookName;
            String bookAuthor;
            BookService bookService = provider.getBookService();

            switch (choice) {

                case 1:

                    System.out.println("Введите название книги, которую вы ищете:");
                    bookName = scanner.nextLine();

                    System.out.println("Введите автора книги, которую вы ищете:");
                    bookAuthor = scanner.nextLine();

                    if (bookService.findBook(bookName, bookAuthor)) {
                        System.out.println ("Книга найдена в каталоге");
                    }
                    else {
                        System.out.println ("Книги нет в каталоге");
                    }

                    break;

                case 2:

                    BookType bookType = ELECTRONICBOOK;

                    System.out.println("Введите название книги, которую вы хотите добавить:");
                    bookName = scanner.nextLine();

                    System.out.println("Введите автора книги, которую вы хотите добавить:");
                    bookAuthor = scanner.nextLine();

                    bookService.addBook(bookName, bookAuthor);

                    System.out.println("Книга была добавлена");

                    break;

                case 0:

                    return;

                default:
                    System.out.println("Ошибка");
            }
        }

    }
}
