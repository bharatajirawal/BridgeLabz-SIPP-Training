public class NumberClassificationChecker {

    public static int sumOfProperDivisors(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++)
            if (num % i == 0) sum += i;
        return sum;
    }

    public static boolean isPerfect(int num) {
        return sumOfProperDivisors(num) == num;
    }

    public static boolean isAbundant(int num) {
        return sumOfProperDivisors(num) > num;
    }

    public static boolean isDeficient(int num) {
        return sumOfProperDivisors(num) < num;
    }

    public static boolean isStrong(int num) {
        int sum = 0, temp = num;
        while (temp > 0) {
            sum += factorial(temp % 10);
            temp /= 10;
        }
        return sum == num;
    }

    private static int factorial(int n) {
        int f = 1;
        for (int i = 2; i <= n; i++) f *= i;
        return f;
    }

    public static void main(String[] args) {
        int num = 145;
        System.out.println(num + " is Perfect? " + isPerfect(num));
        System.out.println(num + " is Abundant? " + isAbundant(num));
        System.out.println(num + " is Deficient? " + isDeficient(num));
        System.out.println(num + " is Strong? " + isStrong(num));
    }
}
