import java.util.ArrayList;
import java.util.List;

public class GradeManager {

    private final List<Student> students;

    public GradeManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student findStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public void printAllStudents() {
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public boolean removeStudent(int id) {
        Student toRemove = null;
        for (Student s : students) {
            if (s.getId() == id) {
                toRemove = s;
                break;
            }
        }
        if (toRemove != null) {
            students.remove(toRemove);
            return true;
        }
        return false;
    }
}