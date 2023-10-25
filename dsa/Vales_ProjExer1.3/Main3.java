import java.util.*;
import java.io.*;

public class Main3 {
	public static void main(String[] args) {
		ArrayList<Student> studentInfo = new ArrayList<>();

		try {
			FileReader fr = new FileReader("student.txt");
			Scanner sc = new Scanner(fr);

			while (sc.hasNextLine()) {
				String studentID = sc.nextLine();
				String lastName = sc.nextLine();
				String firstName = sc.nextLine();
				char gender = sc.nextLine().charAt(0);
				String course = sc.nextLine();
				String s = sc.nextLine();
				int yearLevel = Integer.valueOf(s);

				studentInfo.add(new Student(lastName, firstName, studentID, course, gender, yearLevel));
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		studentInfo.sort(Comparator.comparing(Student::getCourse).thenComparing(Student::getLastname)
				.thenComparing(Student::getFirstname));

		for (Student display : studentInfo)
			display.display();

	}
}
