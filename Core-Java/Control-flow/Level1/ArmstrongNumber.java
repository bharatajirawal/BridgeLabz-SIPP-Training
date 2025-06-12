import java.util.Scanner;
public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int original = number, result = 0;
        while(number != 0) {
            int digit = number % 10;
            result += digit * digit * digit;
            number /= 10;
        }
        if(original == result)
            System.out.println("Armstrong number");
        else
            System.out.println("Not Armstrong number");
    }
}
