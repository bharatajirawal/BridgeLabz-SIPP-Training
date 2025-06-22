import java.util.ArrayList;
import java.util.Arrays;

public class NumberPropertiesChecker1 {

    public static int[] storeDigits(int num) {
        ArrayList<Integer> list = new ArrayList<>();
        while (num > 0) { list.add(num % 10); num /= 10; }
        int[] digits = new int[list.size()];
        for (int i = 0; i < digits.length; i++)
            digits[i] = list.get(list.size()-1-i);
        return digits;
    }

    public static int[] reverseArray(int[] arr) {
        int n = arr.length;
        int[] rev = new int[n];
        for (int i = 0; i < n; i++)
            rev[i] = arr[n-1-i];
        return rev;
    }

    public static boolean arraysEqual(int[] arr1, int[] arr2) {
        return Arrays.equals(arr1, arr2);
    }

    public static boolean isPalindrome(int num) {
        int[] digits = storeDigits(num);
        return arraysEqual(digits, reverseArray(digits));
    }

    public static boolean isDuckNumber(int num) {
        for (int d : storeDigits(num)) if (d == 0) return true;
        return false;
    }

    public static void main(String[] args) {
        int num = 1221;
        System.out.println("Digits: " + Arrays.toString(storeDigits(num)));
        System.out.println("Is palindrome? " + isPalindrome(num));
        System.out.println("Is duck number? " + isDuckNumber(num));
    }
}
