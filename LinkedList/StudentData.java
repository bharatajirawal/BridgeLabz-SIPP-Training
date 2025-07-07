package LinkedList;
public class StudentData {
    int rollNumber;
    String name;
    int age;
    String grade;

    public StudentData(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}
public class StudentNode {
    StudentData data;
    StudentNode next;

    public StudentNode(StudentData data) {
        this.data = data;
        this.next = null;
    }
}
public class StudentListManager {
    private StudentNode head;

    public void insertAtBeginning(StudentData student) {
        StudentNode newNode = new StudentNode(student);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(StudentData student) {
        StudentNode newNode = new StudentNode(student);
        if (head == null) {
            head = newNode;
            return;
        }
        StudentNode temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
    }

    public void insertAtPosition(StudentData student, int position) {
        if (position <= 1) {
            insertAtBeginning(student);
            return;
        }

        StudentNode newNode = new StudentNode(student);
        StudentNode temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of range.");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void deleteByRollNumber(int roll) {
        if (head == null) return;

        if (head.data.rollNumber == roll) {
            head = head.next;
            return;
        }

        StudentNode temp = head;
        while (temp.next != null && temp.next.data.rollNumber != roll) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Roll number not found.");
            return;
        }

        temp.next = temp.next.next;
    }

    public StudentData searchByRoll(int roll) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.data.rollNumber == roll) return temp.data;
            temp = temp.next;
        }
        return null;
    }

    public void updateGrade(int roll, String newGrade) {
        StudentData s = searchByRoll(roll);
        if (s != null) {
            s.grade = newGrade;
        } else {
            System.out.println("Student not found.");
        }
    }

    public void displayRecords() {
        StudentNode temp = head;
        if (temp == null) {
            System.out.println("No records found.");
            return;
        }

        while (temp != null) {
            StudentData s = temp.data;
            System.out.println("Roll No: " + s.rollNumber + ", Name: " + s.name + ", Age: " + s.age + ", Grade: " + s.grade);
            temp = temp.next;
        }
    }
}
public class StudentApp {
    public static void main(String[] args) {
        StudentListManager manager = new StudentListManager();

        // Insert some records
        manager.insertAtEnd(new StudentData(101, "Amit", 20, "B"));
        manager.insertAtBeginning(new StudentData(102, "Neha", 21, "A"));
        manager.insertAtPosition(new StudentData(103, "Raj", 22, "C"), 2);

        System.out.println("📚 All Student Records:");
        manager.displayRecords();

        // Search
        System.out.println("\n🔍 Searching for Roll No 103:");
        StudentData found = manager.searchByRoll(103);
        if (found != null)
            System.out.println("✅ Found: " + found.name + ", Grade: " + found.grade);
        else
            System.out.println("❌ Not Found");

        // Update
        System.out.println("\n✏️ Updating grade for Roll No 101 to A+...");
        manager.updateGrade(101, "A+");

        System.out.println("\n📄 Records After Grade Update:");
        manager.displayRecords();

        // Delete
        System.out.println("\n❌ Deleting student with Roll No 102...");
        manager.deleteByRollNumber(102);

        System.out.println("\n📄 Final Records:");
        manager.displayRecords();
    }
}   

