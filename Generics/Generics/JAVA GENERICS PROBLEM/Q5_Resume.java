// Q5_Resume.java

import java.util.ArrayList;
import java.util.List;

// Abstract JobRole
abstract class JobRole {
    private String name;
    public JobRole(String name) { this.name = name; }
    public String getName() { return name; }
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String name) { super(name); }
}

class DataScientist extends JobRole {
    public DataScientist(String name) { super(name); }
}

class ProductManager extends JobRole {
    public ProductManager(String name) { super(name); }
}

// Generic Resume holder
class Resume<T extends JobRole> {
    private T role;
    private String candidate;
    public Resume(String candidate, T role) {
        this.candidate = candidate; this.role = role;
    }
    public T getRole() { return role; }
    public String getCandidate() { return candidate; }
}

// Wildcard utility for screening multiple roles
class ScreeningUtil {
    public static void printCandidates(List<? extends JobRole> roles) {
        for (JobRole r : roles)
            System.out.println("Screening: " + r.getName());
    }
}

public class Q5_Resume {
    public static void main(String[] args) {
        List<JobRole> jobs = new ArrayList<>();
        jobs.add(new SoftwareEngineer("Alice"));
        jobs.add(new DataScientist("Bob"));

        ScreeningUtil.printCandidates(jobs);

        Resume<SoftwareEngineer> r1 = new Resume<>("Charan", new SoftwareEngineer("Software Engineer"));
        System.out.println(r1.getCandidate() + ", Role: " + r1.getRole().getName());
    }
}
