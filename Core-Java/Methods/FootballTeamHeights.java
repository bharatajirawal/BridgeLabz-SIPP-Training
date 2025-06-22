import java.util.Random;

public class FootballTeamHeights {
    public static int sumOfHeights(int[] heights) {
        int sum = 0;
        for (int h : heights) sum += h;
        return sum;
    }

    public static double meanHeight(int[] heights) {
        return (double) sumOfHeights(heights) / heights.length;
    }

    public static int shortestHeight(int[] heights) {
        int min = Integer.MAX_VALUE;
        for (int h : heights) if (h < min) min = h;
        return min;
    }

    public static int tallestHeight(int[] heights) {
        int max = Integer.MIN_VALUE;
        for (int h : heights) if (h > max) max = h;
        return max;
    }

    public static void main(String[] args) {
        int[] heights = new int[11];
        Random rand = new Random();

        for (int i = 0; i < heights.length; i++) {
            heights[i] = 150 + rand.nextInt(101); // range 150 to 250
        }

        System.out.println("Player heights: ");
        for (int h : heights) System.out.print(h + " ");

        System.out.println("\nSum of heights: " + sumOfHeights(heights));
        System.out.printf("Mean height: %.2f\n", meanHeight(heights));
        System.out.println("Shortest height: " + shortestHeight(heights));
        System.out.println("Tallest height: " + tallestHeight(heights));
    }
}
