import java.util.Scanner;

public class BonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] employeeData = new double[10][2]; // [salary, years of service]
        double[] bonuses = new double[10];
        double[] newSalaries = new double[10];
        double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter salary and years of service for employee " + (i + 1) + ":");
            double salary = sc.nextDouble();
            double years = sc.nextDouble();

            if (salary < 0 || years < 0) {
                System.out.println("Invalid input. Try again.");
                i--;
                continue;
            }

            employeeData[i][0] = salary;
            employeeData[i][1] = years;
        }

        for (int i = 0; i < 10; i++) {
            double salary = employeeData[i][0];
            double years = employeeData[i][1];
            double bonus = (years > 5) ? salary * 0.05 : salary * 0.02;
            double newSalary = salary + bonus;

            bonuses[i] = bonus;
            newSalaries[i] = newSalary;
            totalBonus += bonus;
            totalOldSalary += salary;
            totalNewSalary += newSalary;
        }

        System.out.println("\n--- Bonus Report ---");
        for (int i = 0; i < 10; i++) {
            System.out.println("Employee " + (i + 1) + ": Old Salary = " + employeeData[i][0] +
                    ", Bonus = " + bonuses[i] + ", New Salary = " + newSalaries[i]);
        }

        System.out.println("\nTotal Bonus Payout: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);
    }
}
