import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();  // Number of persons
        double[][] personData = new double[number][3]; // [weight, height, BMI]
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {
            double weight = -1, height = -1;

            while (weight <= 0) {
                System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
                weight = sc.nextDouble();
            }

            while (height <= 0) {
                System.out.print("Enter height (m) for person " + (i + 1) + ": ");
                height = sc.nextDouble();
            }

            double bmi = weight / (height * height);

            personData[i][0] = weight;
            personData[i][1] = height;
            personData[i][2] = bmi;

            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi < 25) {
                weightStatus[i] = "Normal weight";
            } else if (bmi < 30) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        System.out.println("\nPerson Data:");
        System.out.println("Height(m)\tWeight(kg)\tBMI\t\tStatus");

        for (int i = 0; i < number; i++) {
            System.out.printf("%.2f\t\t%.2f\t\t%.2f\t%s\n",
                    personData[i][1], personData[i][0], personData[i][2], weightStatus[i]);
        }
    }
}
