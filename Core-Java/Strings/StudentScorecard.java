import java.util.Random;

public class StudentScorecard {

    public static int[][] generateScores(int studentCount) {
        int[][] scores = new int[studentCount][3];
        Random rand = new Random();
        for (int i = 0; i < studentCount; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = rand.nextInt(41) + 60; // Random 2-digit score between 60 and 100
            }
        }
        return scores;
    }

    public static double[][] calculatePerformance(int[][] scores) {
        double[][] performance = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percent = (total / 300.0) * 100;

            performance[i][0] = total;
            performance[i][1] = Math.round(average * 100.0) / 100.0;
            performance[i][2] = Math.round(percent * 100.0) / 100.0;
        }
        return performance;
    }

    public static String[] assignGrades(double[][] performance) {
        String[] grades = new String[performance.length];
        for (int i = 0; i < performance.length; i++) {
            double percent = performance[i][2];
            if (percent >= 90) grades[i] = "A+";
            else if (percent >= 80) grades[i] = "A";
            else if (percent >= 70) grades[i] = "B+";
            else if (percent >= 60) grades[i] = "B";
            else if (percent >= 50) grades[i] = "C";
            else grades[i] = "F";
        }
        return grades;
    }

    public static void displayScorecard(int[][] scores, double[][] performance, String[] grades) {
        System.out.printf("%-10s %-8s %-10s %-8s %-8s %-10s %-12s %-10s\n",
                "Student", "Physics", "Chemistry", "Maths", "Total", "Average", "Percentage", "Grade");
        System.out.println("--------------------------------------------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("Student%-3d %-8d %-10d %-8d %-8.0f %-10.2f %-12.2f %-10s\n",
                    (i + 1),
                    scores[i][0],
                    scores[i][1],
                    scores[i][2],
                    performance[i][0],
                    performance[i][1],
                    performance[i][2],
                    grades[i]);
        }
    }

    public static void main(String[] args) {
        int studentCount = 5;

        int[][] scores = generateScores(studentCount);
        double[][] performance = calculatePerformance(scores);
        String[] grades = assignGrades(performance);

        displayScorecard(scores, performance, grades);
    }
}
