package com.torres.liter_alura_challenge.main;

import com.torres.liter_alura_challenge.service.APIQueries;

import java.util.Scanner;

public class Main {
    private Scanner keyboard = new Scanner(System.in);
    private APIQueries apiQueries = new APIQueries();
    private final String BASE_URL = "https://gutendex.com/books?search=";

    public void menu() {
        var option = -1;
        while (option != 0) {
            var menu = """
                    1 - Search for books
                    2 - Show searched books
                    0 - Exit
                    """;
            System.out.println(menu);
            option = keyboard.nextInt();
            keyboard.nextLine();

            switch (option) {
                case 1:
                    searchBook();
                    break;
                case 2:
                    showSearchedBooks();
                    break;
                case 0:
                    System.out.println("Closing the application...");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
