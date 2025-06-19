import java.util.Scanner;

public class UppercaseCompare {

    public static String convertToUppercase(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char)(ch - 32);
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

        String manualUpper = convertToUppercase(input);
        String builtInUpper = input.toUpperCase();

        boolean isSame = compareUsingCharAt(manualUpper, builtInUpper);

        System.out.println("\nManual uppercase: " + manualUpper);
        System.out.println("Built-in uppercase: " + builtInUpper);
        System.out.println("\nAre both uppercase results same? " + (isSame ? "✅ Yes" : "❌ No"));

        sc.close();
    }
}
