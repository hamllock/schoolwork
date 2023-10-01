import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IntSkipList skipList = new IntSkipList();
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int value = Integer.parseInt(line.trim());
                skipList.skipListInsert(value);
            }
        } catch (IOException e) {
            System.err.println("Error reading data from the file: " + e.getMessage());
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Input a number: ");
        int input = sc.nextInt();
        if (skipList.skipListSearch(input) == input) {
            System.out.println(input + "found, checked " + skipList.nodesChecked + " node/s.");
        } else {
            System.out.println("Number not found.");
        }

    }
}
