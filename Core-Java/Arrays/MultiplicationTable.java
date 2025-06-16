import java.util.*;
public class MultiplicationTable{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = 10;
        int arr[]=new int[n];
        int mul=0;
        for (int i = 0; i <n;i++){
            arr[i]=sc.nextInt();
            mul*=arr[i];
        }
        System.out.println("Multiplication of all numbers is: "+mul);
    }
    
}