import java.io.*;
import java.util.*; 

public class ValesExer2 {
    public static void main(String[] args) {

        ArrayList<Integer> score = new ArrayList<Integer>();

        try {
            FileReader fr = new FileReader("input.txt");
            Scanner sc = new Scanner(fr);
            sc.useDelimiter(",\\s*");
            while(sc.hasNext()) {
                score.add(sc.nextInt());
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        int arr[] = new int[8];
        for (int i = 0; i < score.size(); i++) {
            for (int j = 0; j < 8; j++){
                if (score.get(i) >= 25 * j && score.get(i) < 25 + (25 * j)){ 
                    arr[j] += 1;
                } 
            }

            if (score.get(i) == 200) {
                    arr[7] += 1;
            }
        }

        for (int i = 0; i < 8; i++) {
            System.out.println("Range from " + (25 * i) + " to " + (25 + (25 * i)) + " has " + arr[i] + " student/s");
        }
    }
}
