package by.ratkevich.library.presentation;

public class Viewer {

    public static void answer (boolean result) {

        String response;

        if (result) {
            response = "Добро пожаловать";
        }
        else {
            response = "Неверная комбинация логина/пароля";
        }

        System.out.println(response);
    }
}
