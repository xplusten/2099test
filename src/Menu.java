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
            System.out.println("6. Expel Student");
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
                    expelStudent();
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

    private void expelStudent() {
        System.out.print("Enter student ID to expel: ");
        int id = scanner.nextInt();
        boolean removed = manager.removeStudent(id);
        if (removed) {
            System.out.println("Student " + id + " has been expelled.");
        } else {
            System.out.println("Student not found.");
        }
    }
}