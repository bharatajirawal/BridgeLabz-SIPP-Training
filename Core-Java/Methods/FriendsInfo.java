import java.util.Scanner;

public class FriendsInfo {

    public static int findYoungest(int[] ages) {
        int minIndex = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int findTallest(double[] heights) {
        int maxIndex = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        System.out.println("Enter age and height of Amar:");
        ages[0] = scanner.nextInt();
        heights[0] = scanner.nextDouble();

        System.out.println("Enter age and height of Akbar:");
        ages[1] = scanner.nextInt();
        heights[1] = scanner.nextDouble();

        System.out.println("Enter age and height of Anthony:");
        ages[2] = scanner.nextInt();
        heights[2] = scanner.nextDouble();

        int youngestIndex = findYoungest(ages);
        int tallestIndex = findTallest(heights);

        System.out.println("The youngest friend is: " + names[youngestIndex]);
        System.out.println("The tallest friend is: " + names[tallestIndex]);

        scanner.close();
    }
}
