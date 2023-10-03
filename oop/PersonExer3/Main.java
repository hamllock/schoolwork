package PersonExer3;

import java.util.*;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static void main(String[] args) {

        HashMap<Integer, Student> studentHash = new HashMap<Integer, Student>();
        HashMap<String, Teacher> teacherHash = new HashMap<String, Teacher>();

        Scanner sc = new Scanner(System.in);
        String choice = null;
        boolean flag = true;

        while (flag) {
            System.out.println("---------------------------------------");
            System.out.println("1: Add a student");
            System.out.println("2: Add a teacher");
            System.out.println("3: Display list of teachers");
            System.out.println("4: Exit");

            System.out.print(">> Enter choice: ");
            choice = sc.nextLine();
            System.out.println("----------------------------------------");

            switch (choice.toUpperCase()) {
                case "1":
                    addStudent(studentHash);
                    break;
                case "2":
                    addTeacher(teacherHash);
                    break;
                case "3":
                    printTeachers(teacherHash);
                    break;
                case "4":
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }

    public static void addStudent(HashMap<Integer, Student> studentHash) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input student name: ");
        String studentName = sc.nextLine();

        System.out.print("Input student address: ");
        String studentAddr = sc.nextLine();

        System.out.print("Input student year level: ");
        Integer studentYear = sc.nextInt();
        sc.nextLine();

        System.out.print("Input student ID: ");
        Integer studentID = sc.nextInt();
        sc.nextLine();

        if (studentHash.containsKey(studentID)) {
            System.out.println(ANSI_RED + ">> ID already exists in database" + ANSI_RESET);
            return;
        }

        Student student = new Student(studentName, studentAddr, studentID, studentYear);
        studentHash.put(studentID, student);
    }

    public static void addTeacher(HashMap<String, Teacher> teacherHash) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input teacher name: ");
        String teacherName = sc.nextLine();

        System.out.print("Input teacher address: ");
        String teacherAddr = sc.nextLine();

        System.out.print("Input teacher department: ");
        String teacherDepartment = sc.nextLine();


        if (teacherHash.containsKey(teacherName.toUpperCase())) {
            System.out.println(ANSI_RED + ">> Teacher already exists in database" + ANSI_RESET);
            return;
        }

        Teacher teacher = new Teacher(teacherName, teacherAddr, teacherDepartment);
        teacherHash.put(teacherName.toUpperCase(), teacher);
    }

    public static void printTeachers(HashMap<String, Teacher> teacherHash) {
        Scanner sc = new Scanner(System.in);
        
        if (teacherHash.size() == 0) {
            System.out.println(ANSI_RED + ">> No entries in database" + ANSI_RESET);
            return;
        }

        System.out.print(">> Which department would you like to see?: ");
        String deptSearch = sc.nextLine();

        System.out.println("\nTeachers in the " + deptSearch + " department:\n");

        for (Teacher teacher : teacherHash.values()) {
            if (teacher.getDepartment().equalsIgnoreCase(deptSearch)) {
                System.out.println(teacher.toString());
            }
        }
    }

}
