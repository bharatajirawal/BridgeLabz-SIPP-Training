import java.util.Scanner;

public class CollinearityChecker {

    public static boolean areCollinearBySlope(
            double x1, double y1, double x2, double y2, double x3, double y3) {
        double slopeAB = (y2 - y1) / (x2 - x1);
        double slopeBC = (y3 - y2) / (x3 - x2);
        return Double.compare(slopeAB, slopeBC) == 0;
    }

    public static boolean areCollinearByArea(
            double x1, double y1, double x2, double y2, double x3, double y3) {
        double area = 0.5 * (x1*(y2 - y3) + x2*(y3 - y1) + x3*(y1 - y2));
        return area == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter x1, y1, x2, y2, x3, y3:");
        double x1 = sc.nextDouble(), y1 = sc.nextDouble();
        double x2 = sc.nextDouble(), y2 = sc.nextDouble();
        double x3 = sc.nextDouble(), y3 = sc.nextDouble();

        System.out.println("Collinear (slope method)? " + areCollinearBySlope(x1,y1,x2,y2,x3,y3));
        System.out.println("Collinear (area method)? " + areCollinearByArea(x1,y1,x2,y2,x3,y3));
    }
}
