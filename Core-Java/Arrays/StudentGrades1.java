import java.util.Scanner;

public class StudentGrades1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] marks = new int[n][3];
        double[] percentages = new double[n];
        char[] grades = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks for Student " + (i + 1) + ":");
            for (int j = 0; j < 3; j++) {
                String subject = (j == 0) ? "Physics" : (j == 1) ? "Chemistry" : "Maths";
                System.out.print(subject + ": ");
                marks[i][j] = sc.nextInt();

                if (marks[i][j] < 0 || marks[i][j] > 100) {
                    System.out.println("Invalid marks. Enter again.");
                    j--; // retry this subject
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentages[i] = total / 3.0;

            if (percentages[i] >= 90)
                grades[i] = 'A';
            else if (percentages[i] >= 75)
                grades[i] = 'B';
            else if (percentages[i] >= 60)
                grades[i] = 'C';
            else if (percentages[i] >= 45)
                grades[i] = 'D';
            else
                grades[i] = 'F';
        }

        System.out.println("\nResult:");
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1));
            System.out.println("Physics: " + marks[i][0] + ", Chemistry: " + marks[i][1] + ", Maths: " + marks[i][2]);
            System.out.println("Percentage: " + percentages[i] + "%, Grade: " + grades[i]);
            System.out.println();
        }
    }
}
