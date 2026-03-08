public class Course {

    private String courseName;
    private double grade;

    public Course(String courseName, double grade) {
        this.courseName = courseName;
        this.grade = grade;
    }

    public String getCourseName() {
        return courseName;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return courseName + " - Grade: " + grade;
    }
}