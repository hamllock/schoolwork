package ProjExer15;

import java.io.*;
import java.util.*;

public class MainApp {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        LinkedList<Student> studentLL = new LinkedList<Student>();

        try (Scanner sc = new Scanner(new FileReader("students.txt"))) {
            while (sc.hasNextLine()) {
                String lastName = sc.nextLine();
                String firstName = sc.nextLine();

                if (lastName.toUpperCase().startsWith("A") || lastName.toUpperCase().startsWith("E")
                        || lastName.toUpperCase().startsWith("I")
                        || lastName.toUpperCase().startsWith("O") || lastName.toUpperCase().startsWith("U")) {
                    studentLL.addFirst(new Student(lastName, firstName));
                } else {
                    studentLL.addLast(new Student(lastName, firstName));
                }

            }
        } catch (IOException e) {
            System.err.println("Error reading data from the file: " + e.getMessage());
            return;
        }

        for (Student display : studentLL)
            System.out.println(display.toString());
    }
}
