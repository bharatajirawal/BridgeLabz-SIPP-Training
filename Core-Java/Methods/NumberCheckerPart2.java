import java.util.ArrayList;
import java.util.Arrays;

public class NumberCheckerPart2 {

    public static int[] storeDigits(int num) {
        ArrayList<Integer> list = new ArrayList<>();
        while (num > 0) { list.add(num % 10); num /= 10; }
        int[] digits = new int[list.size()];
        for (int i = 0; i < digits.length; i++)
            digits[i] = list.get(list.size()-1-i);
        return digits;
    }

    public static int sumOfDigits(int num) {
        int sum = 0;
        for (int d : storeDigits(num)) sum += d;
        return sum;
    }

    public static int sumOfSquaresOfDigits(int num) {
        int sum = 0;
        for (int d : storeDigits(num)) sum += Math.pow(d,2);
        return sum;
    }

    public static boolean isHarshad(int num) {
        return num % sumOfDigits(num) == 0;
    }

    public static int[][] digitFrequency(int num) {
        int[] digits = storeDigits(num);
        int[][] freq = new int[10][2]; 
        for (int i = 0; i < freq.length; i++) freq[i][0] = i;
        for (int d : digits) freq[d][1]++;
        return freq;
    }

    public static void main(String[] args) {
        int num = 21;
        System.out.println("Digits: " + Arrays.toString(storeDigits(num)));
        System.out.println("Sum of digits: " + sumOfDigits(num));
        System.out.println("Sum of squares: " + sumOfSquaresOfDigits(num));
        System.out.println(num + " is Harshad? " + isHarshad(num));
        int[][] freq = digitFrequency(num);
        System.out.println("Frequency:");
        for (int[] f : freq) if (f[1] > 0) System.out.println(f[0]+": "+f[1]);
    }
}
