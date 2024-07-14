package com.torres.liter_alura_challenge.main;

import com.torres.liter_alura_challenge.service.APIQueries;

import java.util.Scanner;

public class Main {
    private Scanner keyboard = new Scanner(System.in);
    private APIQueries apiQueries = new APIQueries();
    private final String BASE_URL = "https://gutendex.com/books/?search=";

    public void menu() {
            var start = true;
            while (start) {
                System.out.println("""
                        -------------------------------
                        
                        1 - Search books
                        2 - List books registered
                        3 - List authors registered
                        4 - List books registered by language
                        5 - List books registered by download count
                        0 - Exit
                        
                        -------------------------------
                        """);
                System.out.print("Choose an option: ");

                var option = keyboard.nextInt();

                switch (option) {
                    case 1 -> searchBooks();
                    case 2 -> listBooks();
                    case 3 -> listAuthors();
                    case 4 -> listBooksByLanguage();
                    case 5 -> listBooksByDownloadCount();
                    case 0 -> {
                        System.out.println("Bye!");
                        start = false;
                    }
                    default -> System.out.println("Invalid option");
                }
            }
        }

    private void searchBooks() {
        System.out.print("Enter the book title: ");
        var title = keyboard.next();
        var url = BASE_URL + title.replace(" ", "%20");
        var json = apiQueries.getData(url);
        System.out.println(json);
    }

    private void listBooks() {
    }

    private void listAuthors() {
    }

    private void listBooksByLanguage() {
    }

    private void listBooksByDownloadCount() {
    }
}
