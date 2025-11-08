import java.util.Arrays;
import java.util.Random;

public class CountOccurOfNumber {
    public static void  main(String ...arg){
        int[] list = new int[100];
        for (int i = 0; i < list.length; i++) {
            list[i] = (int) (Math.random()*list.length);
        }
        int[] counts = countNumbers(list);
        System.out.println(Arrays.toString(counts));
        displayCount(counts);
    }

    private static void displayCount(int[] counts) {
        for (int i = 0; i < counts.length ; i++) {
            System.out.println(i +" has " +counts[i] +" occurences");
        }
    }

    private static int[] countNumbers(int[] list) {
        int[] counts = new int[100];
        for (int i = 0; i < list.length; i++) {
            counts[list[i]]++;
        }

        return counts;
    }

}
