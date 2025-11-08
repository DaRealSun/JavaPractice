import java.util.Scanner;

public class SumMajorDiagonalInMatrix {
    public static void main(String... emIu){
        Scanner input = new Scanner(System.in);
        System.out.println("enter matrix N * N:");
        int n = input.nextInt();
        System.out.println();
        double[][] matrix = new double[n][n];
        //initialize array 2D
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j]=input.nextDouble();
            }
            System.out.println();
        }
        //Print result
        double result =sumMajorDiagonal(matrix);
        System.out.println("Sum of the element in the major diagonal is  " + result);

        }

    public static double sumMajorDiagonal(double[][] matrix) {
        double total =0;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if(row==column){
                    total+=matrix[row][column];
                }
            }
        }


        return total;
    }
}
