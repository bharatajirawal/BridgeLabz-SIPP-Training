import java.util.Scanner;

public class CalendarUtility {

    public static String getMonthName(int month) {
        String[] months = {"January","February","March","April","May","June",
                "July","August","September","October","November","December"};
        return months[month - 1];
    }

    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 100 != 0 && year % 4 == 0);
    }

    public static int getDaysInMonth(int month, int year) {
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        if (month == 2 && isLeapYear(year)) return 29;
        return days[month-1];
    }

    public static int getFirstDayOfMonth(int month, int year) {
        // Using Zeller's congruence
        if (month < 3) {
            month += 12;
            year--;
        }
        int k = year % 100;
        int j = year / 100;
        int h = (1 + (13*(month+1))/5 + k + k/4 + j/4 + 5*j) % 7;
        int d = ((h + 5) % 7); // 0=Saturday ... shift to 0=Sunday
        return d;
    }

    public static void printCalendar(int month, int year) {
        int firstDay = getFirstDayOfMonth(month, year);
        int daysInMonth = getDaysInMonth(month, year);

        System.out.println("\n     " + getMonthName(month) + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }

        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%3d ", day);
            if ((firstDay + day) % 7 == 0) System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month and year: ");
        int month = sc.nextInt();
        int year = sc.nextInt();
        printCalendar(month, year);
    }
}
