package BooksAuthor;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private ArrayList<Author> authors = new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return "Title: " + this.getTitle();
    }

    public List<Author> getAuthors() {
        return authors;
    }

}
