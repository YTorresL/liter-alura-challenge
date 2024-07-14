package com.torres.liter_alura_challenge.main;

import com.torres.liter_alura_challenge.service.APIQueries;

import java.util.Scanner;

public class Main {
    private Scanner keyboard = new Scanner(System.in);
    private APIQueries apiQueries = new APIQueries();
    private final String BASE_URL = "https://gutendex.com/books/?search=";

    public void menu() {
            var option = true;
            while (option) {
                System.out.println("""
                        1 - Search books
                        2 - List books registered
                        3 - List authors registered
                        4 - List books registered by language
                        5 - List books registered by download count
                        0 - Exit
                        """);
                System.out.print("Choose an option: ");

                switch (option) {
                    case 1 -> searchBooks();
                    case 0 -> System.out.println("Bye!");
                    default -> System.out.println("Invalid option");
                }
            }
        }
    }
