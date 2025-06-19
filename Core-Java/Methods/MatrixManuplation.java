import java.util.*;
public class MatrixManuplation {
    public static int[][] randommatrix(int rows,int col) {
        int[][] matrix = new int[rows][col];
        for (int i = 0; i<rows;i++)
        {
            for (int j = 0; j<col;j++){
                matrix[i][j]=1*Math.random(0,100);
            }
        }
        return matrix;
    }
    public static int[][] transpose(int [][]d){
        int[][] matrix = new int[d.length][d[0].length];
        for (int i = 0; i<d.length;i++){
            for (int j = 0; j<d[0].length;j++){
                matrix[j][i]=d[i][j];

            }
        }
        return matrix;
    }
    public static int determinant(int [][] matrix) {
        int n=matrix.length;
        if (n == 1) 
            return matrix[0][0];
            if (n == 2){
                return matrix[0][0]*matrix[1][1]-matrix[0][1]*matrix[1][0];
            }
           
                
            }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[][] arr=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        int d[][]=randommatrix( m, n);
        int tran[][]=transpose(d);
        determinant(tarn);
    }
}