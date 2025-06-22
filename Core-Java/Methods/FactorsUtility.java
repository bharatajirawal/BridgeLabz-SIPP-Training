import java.util.ArrayList;
import java.util.Arrays;

public class FactorsUtility {

    public static int[] findFactors(int num) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= num; i++)
            if (num % i == 0) list.add(i);
        int[] factors = new int[list.size()];
        for (int i = 0; i < factors.length; i++)
            factors[i] = list.get(i);
        return factors;
    }

    public static int greatestFactor(int num) {
        int[] factors = findFactors(num);
        return factors[factors.length - 1]; // last one is greatest
    }

    public static int sumOfFactors(int num) {
        int sum = 0;
        for (int f : findFactors(num)) sum += f;
        return sum;
    }

    public static long productOfFactors(int num) {
        long product = 1;
        for (int f : findFactors(num)) product *= f;
        return product;
    }

    public static long productOfCubeOfFactors(int num) {
        long product = 1;
        for (int f : findFactors(num)) product *= (long) Math.pow(f, 3);
        return product;
    }

    public static void main(String[] args) {
        int num = 12;
        int[] factors = findFactors(num);
        System.out.println("Factors: " + Arrays.toString(factors));
        System.out.println("Greatest factor: " + greatestFactor(num));
        System.out.println("Sum of factors: " + sumOfFactors(num));
        System.out.println("Product of factors: " + productOfFactors(num));
        System.out.println("Product of cube of factors: " + productOfCubeOfFactors(num));
    }
}
