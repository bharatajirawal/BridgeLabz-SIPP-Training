import java.util.Scanner;

public class ManualSplitCompare {

    public static int getLength(String str) {
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

    public static String[] manualSplit(String str) {
        int len = getLength(str);
        int wordCount = 1;

        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                wordCount++;
            }
        }

        String[] words = new String[wordCount];
        int index = 0;
        String word = "";

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (ch != ' ') {
                word += ch;
            } else {
                words[index++] = word;
                word = "";
            }
        }

        words[index] = word;
        return words;
    }

    public static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) return false;

        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        String[] builtInWords = input.split(" ");
        String[] manualWords = manualSplit(input);

        boolean isSame = compareArrays(manualWords, builtInWords);

        System.out.println("\nManual Split Result:");
        for (String word : manualWords) {
            System.out.println(word);
        }

        System.out.println("\nBuilt-in Split Result:");
        for (String word : builtInWords) {
            System.out.println(word);
        }

        System.out.println("\nAre both results same? " + (isSame ? "✅ Yes" : "❌ No"));

        sc.close();
    }
}
