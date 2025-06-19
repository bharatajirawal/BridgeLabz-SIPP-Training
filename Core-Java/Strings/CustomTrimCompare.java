import java.util.Scanner;

public class CustomTrimCompare {

    public static int[] findTrimIndexes(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start <= end && str.charAt(start) == ' ') {
            start++;
        }

        while (end >= start && str.charAt(end) == ' ') {
            end--;
        }

        return new int[] {start, end};
    }

    public static String customSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i <= end && i < str.length(); i++) {
            result += str.charAt(i);
        }
        return result;
    }

    public static boolean compareUsingCharAt(String a, String b) {
        if (a.length() != b.length()) return false;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text with spaces: ");
        String input = sc.nextLine();

        int[] indexes = findTrimIndexes(input);
        String trimmedCustom = customSubstring(input, indexes[0], indexes[1]);
        String trimmedBuiltIn = input.trim();

        boolean isEqual = compareUsingCharAt(trimmedCustom, trimmedBuiltIn);

        System.out.println("\nCustom Trimmed: [" + trimmedCustom + "]");
        System.out.println("Built-in Trimmed: [" + trimmedBuiltIn + "]");
        System.out.println("\nAre both trimmed results same? " + (isEqual ? "✅ Yes" : "❌ No"));

        sc.close();
    }
}
