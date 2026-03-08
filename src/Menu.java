import java.util.Scanner;

public class Menu {

    private GradeManager manager;
    private Scanner scanner;

    public Menu() {
        manager = new GradeManager();
        scanner = new Scanner(System.in);
    }

    public void start() {

        while (true) {

            System.out.println("\n--- Student Grade Manager ---");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course to Student");
            System.out.println("3. View Students");
            System.out.println("4. View Student Courses");
            System.out.println("5. Exit");
            System.out.println("6. Add Dummy Data");
            System.out.print("7: Remove Student");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addCourse();
                    break;
                case 3:
                    manager.printAllStudents();
                    break;
                case 4:
                    viewCourses();
                    break;
                case 5:
                    return;
                case 6:
                    addDummyData();
                    break;
                case 7:
                    manager.removeStudent();
                    break;
            }
        }
    }

    private void addStudent() {

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter ID: ");
        int id = scanner.nextInt();

        Student student = new Student(name, id);
        manager.addStudent(student);
    }

    private void addCourse() {

        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Student student = manager.findStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Course name: ");
        String courseName = scanner.nextLine();

        System.out.print("Grade: ");
        double grade = scanner.nextDouble();

        student.addCourse(new Course(courseName, grade));
    }

    private void viewCourses() {

        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();

        Student student = manager.findStudent(id);

        if (student != null) {
            student.printCourses();
        } else {
            System.out.println("Student not found.");
        }
    }

    private void addDummyData() {
        Student s1 = new Student("Alice", 1);
        s1.addCourse(new Course("Math", 90));
        s1.addCourse(new Course("Science", 85));
        manager.addStudent(s1);

        Student s2 = new Student("Bob", 2);
        s2.addCourse(new Course("Math", 75));
        s2.addCourse(new Course("History", 80));
        manager.addStudent(s2);
    }


}