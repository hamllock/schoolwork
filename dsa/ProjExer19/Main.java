package ProjExer19;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        BST packages = new BST();
        chooseSelection(packages);
    }

    public static void chooseSelection(BST packages) {
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        boolean selection = true;

        while (selection) {
            // clearScreen();
            readFromFile(packages);
            System.out.println("===============================");
            System.out.println(">> Select an option:");
            System.out.println("1. Display Packages");
            System.out.println("2. Add New Software");
            System.out.println("3. Update Software Information");
            System.out.println("4. Edit Software Quantity");
            System.out.println("5. Delete Package");
            System.out.print(">> ");

            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(">> Invalid input. Please enter a valid integer.");
                sc.nextLine();
                continue;
            }

            System.out.println("===============================");

            switch (choice) {
                case 1:
                    displayPackages(packages);
                    break;
                case 2:
                    addSoftwares(packages);
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    selection = false;
                    break;
                default:
                    System.out.println(">> Invalid choice");
            }
        }

    }

    public static void readFromFile(BST packages) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream("packages.txt"), StandardCharsets.UTF_8))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String name = line;
                String version = reader.readLine();
                if (version.equals("0.0")) {
                    version = "";
                }
                int quantity = Integer.parseInt(reader.readLine());
                double price = Double.parseDouble(reader.readLine());

                Software software = new Software(name, version, quantity, price);
                packages.insert(software);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayPackages(BST packages) {
        packages.inOrderTraversal();
    }

    public static void addSoftwares(BST packages) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter software name:");
        String name = scanner.nextLine();

        System.out.println("Enter software version:");
        String version = scanner.nextLine();

        System.out.println("Enter software quantity:");
        int quantity = scanner.nextInt();

        System.out.println("Enter software price:");
        double price = scanner.nextDouble();

        Software software = new Software(name, version, quantity, price);
        packages.insert(software);
    }

    public static void updateSoftwareInfo(BST packages) {

    }

    public static void editSoftwareQuantity(BST packages) {

    }

    public static void deletePackage(BST packages) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter software name to delete:");
        String name = scanner.nextLine();

        System.out.println("Enter software version to delete:");
        String version = scanner.nextLine();

        Software software = new Software(name, version, 0, 0.0);
        packages.deleteKey(software);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
