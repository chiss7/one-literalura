package com.chis.literalura.principal;

import com.chis.literalura.dto.AuthorRequest;
import com.chis.literalura.dto.BookRequest;
import com.chis.literalura.dto.Request;
import com.chis.literalura.entity.Author;
import com.chis.literalura.entity.Book;
import com.chis.literalura.repository.AuthorRepository;
import com.chis.literalura.service.Api;
import com.chis.literalura.service.JsonMapperImpl;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private final AuthorRepository authorRepository;
    private final Scanner read = new Scanner(System.in);
    private final Api api = new Api();
    private final JsonMapperImpl mapper = new JsonMapperImpl();
    public Principal(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void menu() {
        int option = -1;
        while(option != 0) {
            String menu = """
                    1 - Search book by title.
                    2 - Print saved books.
                    3 - Print saved authors.
                    4 - Print authors alive in a given year.
                    5 - Print books by language.
                    0 - Exit
                    """;
            System.out.println(menu);
            option = read.nextInt();
            read.nextLine();

            switch (option) {
                case 1:
                    searchBookByTitle();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    System.out.println("Shut down...");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    private void searchBookByTitle() {
        System.out.println("Write the name of the book: ");
        String bookName = read.nextLine();
        String baseUrl = "https://gutendex.com/books/";
        String json = api.getData(baseUrl + "?search=" + bookName.replace(" ", "%20").toLowerCase());
        Request request = mapper.fromJsonToClass(json, Request.class);
        System.out.println(request);
        if (request.books() != null && !request.books().isEmpty()) {
            BookRequest firstBookRequest = request.books().get(0);
            if (firstBookRequest.authors() != null && !firstBookRequest.authors().isEmpty()) {
                AuthorRequest firstAuthorRequest = firstBookRequest.authors().get(0);
                Optional<Author> existingAuthor = authorRepository.findByName(firstAuthorRequest.name());
                Author author = existingAuthor.orElseGet(() -> new Author(firstAuthorRequest));

                Book book = new Book(firstBookRequest);
                book.setAuthor(author);
                author.setBooks(List.of(book));

                authorRepository.save(author);
                System.out.println("Book saved successfully.");
            } else {
                System.out.println("There are no authors.");
            }
        } else {
            System.out.println("There are no books with the name: " + bookName.toLowerCase());
        }
    }
}
