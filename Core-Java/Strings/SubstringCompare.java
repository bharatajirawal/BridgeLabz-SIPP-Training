import java.util.Scanner;

public class SubstringCompare {

    public static String customSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i < end && i < str.length(); i++) {
            result += str.charAt(i);
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

        System.out.print("Enter a string: ");
        String text = sc.next();

        System.out.print("Enter start index: ");
        int start = sc.nextInt();

        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        String substringCustom = customSubstring(text, start, end);
        String substringBuiltIn = text.substring(start, end);

        System.out.println("\nSubstring using charAt(): " + substringCustom);
        System.out.println("Substring using substring(): " + substringBuiltIn);

        boolean isEqual = compareUsingCharAt(substringCustom, substringBuiltIn);

        if (isEqual) {
            System.out.println("✅ Both substrings are equal.");
        } else {
            System.out.println("❌ Substrings are different.");
        }

        sc.close();
    }
}
