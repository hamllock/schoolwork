package ProjExer19;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        BST packages = new BST();
        readFromFile(packages);
        chooseSelection(packages);
    }

    public static void chooseSelection(BST packages) {
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        boolean selection = true;

        while (selection) {
            // clearScreen();
            System.out.println("===============================");
            System.out.println(">> Select an option:");
            System.out.println("1. Display Packages");
            System.out.println("2. Add New Item");
            System.out.println("3. Edit Inventory");
            System.out.println("4. Delete Package");
            System.out.println("5. Exit and Save");
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
                    editSoftwares(packages);
                    break;
                case 4:
                    deletePackage(packages);
                    break;
                case 5:
                    writeToFile(packages);
                    selection = false;
                    break;
                default:
                    System.out.println(">> Invalid choice");
            }
        }

    }

    public static void writeToFile(BST packages) {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("software.txt", false)))) {
            List<String> softwareDetails = packages.inOrderTraversal();
            for (String details : softwareDetails) {
                String[] parts = details.split(", ");
                if (Integer.parseInt(parts[2]) == 0) {
                    continue;
                }
                for (int i = 0; i < parts.length; i++) {
                    if (i == 1 && (parts[i] == null || parts[i].isEmpty())) {
                        writer.write("-");
                    } else {
                        writer.write(parts[i]);
                    }
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFromFile(BST packages) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream("software.txt"), StandardCharsets.UTF_8))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String name = line;
                String version = reader.readLine();
                if (version.equals("-")) {
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
        System.out.printf("%-30s %-10s %-10s %-10s%n", "Name", "Version", "Quantity", "Price");
        List<String> softwareDetails = packages.inOrderTraversal();
        for (String details : softwareDetails) {
            String[] parts = details.split(", ");
            System.out.printf("%-30s %-10s %-10d %-10.2f%n", parts[0], parts[1], Integer.parseInt(parts[2]),
                    Double.parseDouble(parts[3]));
        }
    }

    public static void addSoftwares(BST packages) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter software name:");
        String name = sc.nextLine();

        System.out.println("Enter software version:");
        String version = sc.nextLine();
        Software checkIfExists = new Software(name, version, 0, 0.0);
        if (packages.search(checkIfExists)) {
            System.out.println(">> Software already exists.");
            return;
        }

        System.out.println("Enter how many packages are available:");
        int quantity = sc.nextInt();

        System.out.println("Enter the package's price:");
        double price = sc.nextDouble();

        Software software = new Software(name, version, quantity, price);
        packages.insert(software);
    }

    public static void editSoftwares(BST packages) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter software name to edit:");
        String name = sc.nextLine();

        System.out.println("Enter software version to edit:");
        String version = sc.nextLine();
        Software checkIfExists = new Software(name, version, 0, 0.0);
        if (!packages.search(checkIfExists)) {
            System.out.println(">> Software does not exist.");
            return;
        }

        System.out.println("Enter how many packages are available:");
        int quantity = sc.nextInt();

        System.out.println("Enter the package's new price:");
        double price = sc.nextDouble();

        Software software = new Software(name, version, quantity, price);
        packages.deleteKey(software);
        packages.insert(software);
    }

    public static void deletePackage(BST packages) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter software name to delete:");
        String name = sc.nextLine();

        System.out.println("Enter software version to delete:");
        String version = sc.nextLine();

        Software software = new Software(name, version, 0, 0.0);
        if (!packages.search(software)) {
            System.out.println(">> Software does not exist.");
            return;
        }

        packages.deleteKey(software);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
