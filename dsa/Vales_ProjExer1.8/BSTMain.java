import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class BSTMain {
    public static void main(String[] args) {
        BST bst = new BST();

        try {
            FileReader fr = new FileReader("bst.txt");
            Scanner sc = new Scanner(fr);

            while (sc.hasNextInt()) {
                int num = sc.nextInt();
                bst.insert(num);
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number to search: ");
        int searchNum = input.nextInt();

        int nodesChecked = bst.search(searchNum);

        if (nodesChecked == 0)
            System.out.println("The tree is empty.");
        else if (nodesChecked == 1)
            System.out.println("The number " + searchNum + " was found after checking 1 node.");
        else
            System.out.println("The number " + searchNum + " was found after checking " + nodesChecked + " nodes.");

        input.close();
    }
}