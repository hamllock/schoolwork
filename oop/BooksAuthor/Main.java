package BooksAuthor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        ArrayList<Person> authors = new ArrayList<>();
        ArrayList<Book> book = new ArrayList<>();

        boolean selection = true;
        String menuItems = "y";

        while (selection) {
            System.out.println("-----------------------------------------------");
            System.out.println("A: Add Authors");
            System.out.println("B: Add Book and assign Authors");
            System.out.println("C: View Books and Authors");
            System.out.println("D: View Authors and Books");
            System.out.println("Q: Quit");
            System.out.print(">> Enter choice: ");
            menuItems = input.nextLine();
            System.out.println("-----------------------------------------------");

            switch (menuItems.toUpperCase()) {
                case "A":
                    addAuthors(authors);
                    break;
                case "B":
                    addBook(authors, book);
                    break;
                case "C":
                    bookAndAuthor(book);
                    break;
                case "D":
                    authorAndBook(authors, book);
                    break;
                case "Q":
                    selection = false;
                    break;

            }
        }

        input.close();
    }

    public static void addAuthors(ArrayList<Person> authors) {
        System.out.print(">> Enter Author Name: ");
        String name = input.nextLine();
        Person author = new Author(name);
        authors.add(author);
    }

    public static void addBook(ArrayList<Person> authors, ArrayList<Book> book) {
        System.out.print(">> Enter Book Title: ");
        String title = input.nextLine();
        Book newBook = new Book(title);

        System.out.println("List of authors -----------------");
        for (Person author : authors) {
            System.out.println(author.toString());
        }

        while (true) {
            System.out.print(">> Enter Author Name: (Type EXIT to quit) ");
            String name = input.nextLine();
            if (name.equalsIgnoreCase("EXIT")) {
                break;
            }
            Person author = new Author(name);

            boolean authorExists = false;
            for (int i = 0; i < authors.size(); i++) {
                if (authors.get(i).getName().equals(name)) {
                    newBook.addAuthor((Author) author);
                    authorExists = true;
                    break;
                }
            }

            if (!authorExists) {
                System.out.println(">> Author does not exist");
            }
        }

        book.add(newBook);
    }

    public static void bookAndAuthor(ArrayList<Book> books) {
        System.out.println("Books\t\tAuthors");

        for (Book book : books) {
            System.out.print(book.getTitle() + "\t\t");
            List<Author> authors = book.getAuthors();
            for (int i = 0; i < authors.size(); i++) {
                System.out.print(authors.get(i).getName());
                if (i != authors.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

    public static void authorAndBook(ArrayList<Person> arrAuthor, ArrayList<Book> arrBooks) {
        System.out.println("Authors\t\tBooks");

        for (Person author : arrAuthor) {
            System.out.print(author.getName() + "\t\t");
            for (Book book : arrBooks) {
                for (Author searchAuthor : book.getAuthors()) {
                    if (searchAuthor.getName().equals(author.getName())) {
                        System.out.print(book.getTitle() + ", ");
                    }
                }
            }
            System.out.println();
        }
    }
}