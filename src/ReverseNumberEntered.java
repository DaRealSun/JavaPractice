import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumberEntered {
    public static void main(String... arg){
        int[] list = new int[10];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < list.length; i++) {
            list[i]=input.nextInt();
        }
        for (int i = 0, j = list.length-1; i < list.length/2; i++,j--) {
            int temp = list[i];
            list[i]=list[j];
            list[j]=temp;

        }
        System.out.println("list = " + Arrays.toString(list));


    }
}
