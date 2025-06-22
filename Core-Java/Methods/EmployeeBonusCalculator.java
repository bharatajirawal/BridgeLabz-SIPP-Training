import java.util.Random;

public class EmployeeBonusCalculator {

    public static int[][] generateSalaryAndService(int numEmployees) {
        Random rand = new Random();
        int[][] data = new int[numEmployees][2]; // salary, years
        for (int i = 0; i < numEmployees; i++) {
            data[i][0] = 10000 + rand.nextInt(90000); // 5-digit salary
            data[i][1] = 1 + rand.nextInt(10);         // years of service
        }
        return data;
    }

    public static double[][] calculateNewSalaryAndBonus(int[][] data) {
        double[][] result = new double[data.length][2]; // newSalary, bonus
        for (int i = 0; i < data.length; i++) {
            int salary = data[i][0];
            int years = data[i][1];
            double bonus = (years > 5) ? salary * 0.05 : salary * 0.02;
            double newSalary = salary + bonus;
            result[i][0] = newSalary;
            result[i][1] = bonus;
        }
        return result;
    }

    public static void printSummary(int[][] data, double[][] result) {
        double sumOld = 0, sumNew = 0, sumBonus = 0;
        System.out.println("Emp\tSalary\tYears\tNewSalary\tBonus");
        for (int i = 0; i < data.length; i++) {
            sumOld += data[i][0];
            sumNew += result[i][0];
            sumBonus += result[i][1];
            System.out.printf("%d\t%d\t%d\t%.2f\t\t%.2f\n",
                    i+1, data[i][0], data[i][1], result[i][0], result[i][1]);
        }
        System.out.printf("\nSum of Old Salary: %.2f\nSum of New Salary: %.2f\nSum of Bonus: %.2f\n",
                sumOld, sumNew, sumBonus);
    }

    public static void main(String[] args) {
        int numEmployees = 10;
        int[][] data = generateSalaryAndService(numEmployees);
        double[][] result = calculateNewSalaryAndBonus(data);
        printSummary(data, result);
    }
}
