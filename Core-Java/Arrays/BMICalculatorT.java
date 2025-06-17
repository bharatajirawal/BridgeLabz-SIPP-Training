import java.util.*;

public class BMICalculatorT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        double[] height = new double[number];
        double[] weight = new double[number];
        double[] bmi = new double[number];
        String[] status = new String[number];

        for (int i = 0; i < number; i++) {
            height[i] = sc.nextDouble();
            weight[i] = sc.nextDouble();
            while (height[i] <= 0 || weight[i] <= 0) {
                height[i] = sc.nextDouble();
                weight[i] = sc.nextDouble();
            }
            bmi[i] = weight[i] / (height[i] * height[i]);

            if (bmi[i] < 18.5)
                status[i] = "Underweight";
            else if (bmi[i] < 24.9)
                status[i] = "Normal";
            else if (bmi[i] < 29.9)
                status[i] = "Overweight";
            else
                status[i] = "Obese";
        }

        for (int i = 0; i < number; i++) {
            System.out.println("Height: " + height[i] + ", Weight: " + weight[i] + ", BMI: " + bmi[i] + ", Status: " + status[i]);
        }
    }
}
