import java.util.Scanner;

public class SumElementColumnByColumn {
    public static void main(String[] arg){
        Scanner input = new Scanner(System.in);
        System.out.println("enter matrix M * N:");
        int m = input.nextInt();
        System.out.print("*");
        int n = input.nextInt();
        System.out.println();
        double[][] matrix = new double[m][n];
        //initialize array 2D
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j]=input.nextDouble();
            }
            System.out.println();
        }
        //Print result
        for (int i = 0; i < n; i++) {
            double result =sumColumn(matrix, i);
            System.out.println("Sum of the element at column "+ i +" is " + result);

        }
    }

    public static double sumColumn(double[][] matrix, int columnIndex){
        double total=0;
        for (int i = 0; i < matrix.length; i++) {
           total += matrix[i][columnIndex];
        }

        return total;
    }

}
