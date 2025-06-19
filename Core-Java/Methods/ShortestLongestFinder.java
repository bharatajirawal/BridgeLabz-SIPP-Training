import java.util.Scanner;

public class ShortestLongestFinder {

    public static String[] manualSplit(String text) {
        String[] words = new String[100];
        String word = "";
        int count = 0;

        for (int i = 0; i < getLength(text); i++) {
            char ch = text.charAt(i);
            if (ch != ' ') {
                word += ch;
            } else if (!word.equals("")) {
                words[count++] = word;
                word = "";
            }
        }

        if (!word.equals("")) {
            words[count++] = word;
        }

        String[] result = new String[count];
        for (int i = 0; i < count; i++) {
            result[i] = words[i];
        }
        return result;
    }

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

    public static String[][] getWordLengthArray(String[] words) {
        String[][] wordLengths = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            wordLengths[i][0] = words[i];
            wordLengths[i][1] = String.valueOf(getLength(words[i]));
        }
        return wordLengths;
    }

    public static int[] findShortestLongest(String[][] wordLengths) {
        int shortestIndex = 0;
        int longestIndex = 0;

        for (int i = 1; i < wordLengths.length; i++) {
            int len = Integer.parseInt(wordLengths[i][1]);
            int minLen = Integer.parseInt(wordLengths[shortestIndex][1]);
            int maxLen = Integer.parseInt(wordLengths[longestIndex][1]);

            if (len < minLen) {
                shortestIndex = i;
            }
            if (len > maxLen) {
                longestIndex = i;
            }
        }
        return new int[]{shortestIndex, longestIndex};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        String[] words = manualSplit(input);
        String[][] wordLengths = getWordLengthArray(words);
        int[] indexes = findShortestLongest(wordLengths);

        String shortestWord = wordLengths[indexes[0]][0];
        String longestWord = wordLengths[indexes[1]][0];

        System.out.println("\nWord Length Table:");
        System.out.println("--------------------");
        for (String[] entry : wordLengths) {
            System.out.println(entry[0] + " -> " + entry[1]);
        }

        System.out.println("\nShortest Word: " + shortestWord);
        System.out.println("Longest Word: " + longestWord);

        sc.close();
    }
}
