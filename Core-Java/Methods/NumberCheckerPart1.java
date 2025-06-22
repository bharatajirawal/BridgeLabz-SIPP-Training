import java.util.ArrayList;
import java.util.Arrays;

public class NumberCheckerPart1 {

    public static int countDigits(int num) {
        return String.valueOf(num).length();
    }

    public static int[] storeDigits(int num) {
        ArrayList<Integer> digitsList = new ArrayList<>();
        int temp = num;
        while (temp > 0) {
            digitsList.add(temp % 10);
            temp /= 10;
        }
        // reverse to original order
        int[] digits = new int[digitsList.size()];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = digitsList.get(digitsList.size() - 1 - i);
        }
        return digits;
    }

    public static boolean isDuckNumber(int num) {
        int[] digits = storeDigits(num);
        for (int d : digits) if (d == 0) return true;
        return false;
    }

    public static boolean isArmstrong(int num) {
        int[] digits = storeDigits(num);
        int sum = 0;
        int n = digits.length;
        for (int d : digits) sum += Math.pow(d, n);
        return sum == num;
    }

    public static int[] largestAndSecondLargest(int num) {
        int[] digits = storeDigits(num);
        int largest = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int d : digits) {
            if (d > largest) { second = largest; largest = d; }
            else if (d > second && d != largest) { second = d; }
        }
        return new int[]{largest, second};
    }

    public static int[] smallestAndSecondSmallest(int num) {
        int[] digits = storeDigits(num);
        int smallest = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int d : digits) {
            if (d < smallest) { second = smallest; smallest = d; }
            else if (d < second && d != smallest) { second = d; }
        }
        return new int[]{smallest, second};
    }

    public static void main(String[] args) {
        int num = 153; // example number

        System.out.println("Count of digits: " + countDigits(num));
        System.out.println("Digits: " + Arrays.toString(storeDigits(num)));
        System.out.println(num + " is a duck number? " + isDuckNumber(num));
        System.out.println(num + " is an Armstrong number? " + isArmstrong(num));
        System.out.println("Largest & second largest: " +
                Arrays.toString(largestAndSecondLargest(num)));
        System.out.println("Smallest & second smallest: " +
                Arrays.toString(smallestAndSecondSmallest(num)));
    }
}
