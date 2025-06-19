import java.util.Scanner;

public class IllegalArgumentDemo {

    public static void generateException(String text) {
        System.out.println("Substring from index 5 to 2: " + text.substring(5, 2)); // start > end
    }

    public static void handleException(String text) {
        try {
            System.out.println("Substring from index 5 to 2: " + text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("⚠️ Caught IllegalArgumentException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("⚠️ Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("\n---- Generating Exception ----");
        try {
            generateException(input);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e);
        }

        System.out.println("\n---- Handling Exception ----");
        handleException(input);

        sc.close();
    }
}
