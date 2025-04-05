
import java.util.*;

class Student {

    String name;
    int rollNumber;
    String grade;

    Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String toString() {
        return "Name: " + name + ", Roll No: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManagementSystem {

    ArrayList<Student> students = new ArrayList<>();

    void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    void removeStudent(int rollNumber) {
        for (Student s : students) {
            if (s.rollNumber == rollNumber) {
                students.remove(s);
                System.out.println("Student removed successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    void searchStudent(int rollNumber) {
        for (Student s : students) {
            if (s.rollNumber == rollNumber) {
                System.out.println(s);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    void displayAllStudents() {
        for (Student s : students) {
            System.out.println(s);
        }
    }
}

public class StudentManagement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        int choice;
        do {
            System.out.println("\n1. Add Student\n2. Remove Student\n3. Search Student\n4. Display All Students\n5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();
                    System.out.print("Enter Grade: ");
                    String grade = sc.next();
                    sms.addStudent(new Student(name, roll, grade));
                    break;

                case 2:
                    System.out.print("Enter Roll No to remove: ");
                    int rollRemove = sc.nextInt();
                    sms.removeStudent(rollRemove);
                    break;

                case 3:
                    System.out.print("Enter Roll No to search: ");
                    int rollSearch = sc.nextInt();
                    sms.searchStudent(rollSearch);
                    break;

                case 4:
                    sms.displayAllStudents();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }
        } while (choice != 5);
    }
}
