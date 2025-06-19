import java.util.Scanner;

public class StringLengthFinder {

    public static int getLengthWithoutUsingLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String input = sc.next();

        int manualLength = getLengthWithoutUsingLength(input);
        int builtInLength = input.length();

        System.out.println("\nLength (manual method): " + manualLength);
        System.out.println("Length (built-in method): " + builtInLength);

        sc.close();
    }
}
