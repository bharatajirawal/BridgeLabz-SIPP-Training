import java.util.Scanner;

public class LowercaseCompare {

    public static String convertToLowercase(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
            }
            result += ch;
        }
        return result;
    }

    public static boolean compareUsingCharAt(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String input = sc.nextLine();

        String manualLower = convertToLowercase(input);
        String builtInLower = input.toLowerCase();

        boolean isSame = compareUsingCharAt(manualLower, builtInLower);

        System.out.println("\nManual lowercase: " + manualLower);
        System.out.println("Built-in lowercase: " + builtInLower);
        System.out.println("\nAre both lowercase results same? " + (isSame ? "✅ Yes" : "❌ No"));

        sc.close();
    }
}
