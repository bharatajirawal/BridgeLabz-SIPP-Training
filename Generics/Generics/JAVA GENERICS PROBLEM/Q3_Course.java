// Q3_Course.java

import java.util.ArrayList;
import java.util.List;

// Abstract evaluation types
abstract class CourseType {
    private String title;
    public CourseType(String title) { this.title = title; }
    public String getTitle() { return title; }
}

class ExamCourse extends CourseType {
    public ExamCourse(String title) { super(title); }
}

class AssignCourse extends CourseType {
    public AssignCourse(String title) { super(title); }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String title) { super(title); }
}

// Generic class for course handling
class Course<T extends CourseType> {
    private List<T> courses = new ArrayList<>();
    public void addCourse(T c) { courses.add(c); }
    public List<T> getCourses() { return courses; }
    // Wildcard method for handling any department/course type
    public static void printCourses(List<? extends CourseType> list) {
        for (CourseType c : list)
            System.out.println(c.getTitle());
    }
}

public class Q3_Course {
    public static void main(String[] args) {
        Course<ExamCourse> exm = new Course<>();
        exm.addCourse(new ExamCourse("Math Final"));

        Course<AssignCourse> asn = new Course<>();
        asn.addCourse(new AssignCourse("CS Assignments"));

        Course.printCourses(exm.getCourses());
        Course.printCourses(asn.getCourses());
    }
}
