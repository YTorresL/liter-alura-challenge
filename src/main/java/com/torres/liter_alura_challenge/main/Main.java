package com.torres.liter_alura_challenge.main;

import com.torres.liter_alura_challenge.model.Author;
import com.torres.liter_alura_challenge.model.Book;
import com.torres.liter_alura_challenge.model.ResultsData;
import com.torres.liter_alura_challenge.repository.AuthorRepository;
import com.torres.liter_alura_challenge.repository.BookRepository;
import com.torres.liter_alura_challenge.service.APIQueries;
import com.torres.liter_alura_challenge.service.DataConversor;

import java.util.List;
import java.util.Scanner;

public class Main {
    private Scanner keyboard = new Scanner(System.in);
    private APIQueries apiQueries = new APIQueries();
    private final String BASE_URL = "https://gutendex.com/books/?search=";
    private DataConversor conversor = new DataConversor();
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Main(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public void menu() {
            var start = true;
            while (start) {
                System.out.println("""
                        -------------------------------
                        
                        1 - Search books
                        2 - List books registered
                        3 - List authors registered
                        4 - List books registered by language
                        5 - List authors in certain years
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
                    case 5 -> listAuthorsinYears();
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
        ResultsData resultsData = conversor.getData(json, ResultsData.class);

        var bookData = resultsData.books().get(0);

        // Crear y guardar el autor primero
        Author authorDB = new Author(bookData.authors().get(0));
        authorRepository.save(authorDB);

        // Crear el libro y asociar el autor guardado
        Book bookDB = new Book(bookData);
        bookDB.setAuthor(authorDB);


        // Guardar el libro
        bookRepository.save(bookDB);

        System.out.println("""
                
                ------------ Book -------------
                """);
        System.out.println(
                resultsData.books().stream().map(
                book -> "Title: " + book.title() + "\n"
                        + "Authors: " + book.authors().stream().map(author -> author.name())
                        .findFirst().orElse("Author not found") + "\n"
                        + "Languages: " + book.languages().stream()
                        .findFirst().orElse("Language not found") + "\n"
                        + "Download count: " + book.downloadCount())
                        .findFirst().orElse("Book not found") + "\n");
    }

    private void listBooks() {
        List<Book> books = bookRepository.findAll();
        books.forEach(System.out::println);
    }

    private void listAuthors() {
        List<Author> authors = authorRepository.findAll();
        authors.forEach(System.out::println);
    }

    private void listBooksByLanguage() {
    }

    private void listAuthorsinYears() {
    }
}
