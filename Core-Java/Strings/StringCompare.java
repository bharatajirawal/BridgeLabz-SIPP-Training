import java.util.Scanner;

public class StringCompare {

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

        System.out.print("Enter first string: ");
        String string1 = sc.next();

        System.out.print("Enter second string: ");
        String string2 = sc.next();

        boolean resultCharAt = compareUsingCharAt(string1, string2);
        boolean resultEquals = string1.equals(string2);

        System.out.println("\nResult using charAt(): " + resultCharAt);
        System.out.println("Result using equals(): " + resultEquals);

        if (resultCharAt == resultEquals) {
            System.out.println("✅ Both methods returned the same result.");
        } else {
            System.out.println("❌ Methods returned different results.");
        }

        sc.close();
    }
}
