import java.util.Arrays;

public class ComputeTheWeeklyHours {
    public static void main(String []arg){
        int[][] calender = {
                {2,4,5,6,7,8,9},
                {7,3,4,3,4,4,3},
                {3,3,4,3,3,2,2,},
                {9,3,4,7,4,5,1},
        };
        int[] total = new int[4];
        for (int row = 0; row <calender.length ; row++) {
            int sum =0;
            for (int column = 0; column < calender[row].length; column++) {
                sum+= calender[row][column];
            }
            total[row]=sum;
        }

        int[][] empTotal = new int[4][2];
        for (int i = 0; i < empTotal.length; i++) {
            empTotal[i][0]=i;
                empTotal[i][1]=total[i];
        }



        for (int i = 0; i < empTotal.length; i++) {

            for (int j = i+1; j < empTotal.length; j++) {
                if(empTotal[i][1]<empTotal[j][1]){
                    int temp = empTotal[i][1];
                    empTotal[i][1]=empTotal[j][1];
                    empTotal[j][1]=temp;
                }
            }
        }
        for (int i = 0; i < empTotal.length; i++) {

                System.out.println("employee number = "+ empTotal[i][0] +" Salary = "+ empTotal[i][1] );
            }
    }
}
