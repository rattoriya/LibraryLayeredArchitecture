package by.ratkevich.library;

import by.ratkevich.library.controller.Controller;

import java.util.Scanner;

/*
Создать приложение “Учет книг в домашней библиотеке” с помощью  LA.
Общие требования к заданию:
• Система учитывает книги как в электронном, так и в бумажном варианте.
• Существующие роли: пользователь, администратор.
• Пользователь может осуществлять поиск книг в каталоге.
• Администратор может модифицировать каталог.
• Пользователь может предложить добавить книгу в библиотеку, переслав её
администратору на e-mail.
• Каталог книг хранится в текстовом файле.
• Данные аутентификации пользователей хранятся в текстовом файле. Пароль
не хранится в открытом виде
 */

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int choice1;
        int choice2;
        String userName;
        String password;
        int isAdmin;
        String request;

        do {
            System.out.println(
                    "1 - Войти\n"
                            + "2 - Зарегистрироваться");

            while (!scanner.hasNextInt()) {
                scanner.next();
            }

            choice1 = scanner.nextInt();
            scanner.nextLine();

        } while (choice1 != 1 && choice1 != 2);

        while (true) {

            System.out.println("Введите логин/имя пользователя (не может совпадать с именем уже зарегистрированного пользователя):");
            userName = scanner.nextLine();

            System.out.println("Введите пароль:");
            password = scanner.nextLine();

            System.out.println("Являетесь ли вы администратором (1-да, 2-нет):");
            choice2 = scanner.nextInt();

            switch (choice2) {

                case 1:
                    isAdmin = 1;
                    break;

                case 2:
                    isAdmin = 2;
                    break;

                default:
                    System.out.println ("Некорректно введенные данные");
                    scanner.nextLine();
                    continue;
            }
            break;
        }

        request = choice1 + " " + userName + " " + password + " " + isAdmin;

        Controller controller = new Controller();
        controller.doAction(request);
    }
}