import java.util.Scanner;

public class AssignGrade {
    public static void main(String[] args) {
        char[] grades = {'A', 'B', 'C', 'D'};
        int[] cutoffs = {10, 20, 30, 40};

        System.out.print("Enter number of students: ");
        Scanner input = new Scanner(System.in);
        int studentNumber = input.nextInt();
        int[] scores= new int[studentNumber];
        System.out.println("Enter " + studentNumber + " scores: ");
        for (int i = 0; i < studentNumber; i++) {
            scores[i]= input.nextInt();
        }
        int best=0;

        for (int i = 0; i < studentNumber; i++) {
            if(best<scores[i]){
                best=scores[i];
            }
        }
        for (int i = 0; i < studentNumber; i++) {
            int diff = best - scores[i];
            char grade = 'F';
            for (int j = 0; j < cutoffs.length; j++) {
                if(diff <= cutoffs[j]){
                    grade = grades[j];
                    break;
                }
            }
            System.out.println("Student " + i + "score is " + scores[i] +
                    " and grade is " + grade);
        }


    }

    static void assignGrade(){

    }
}
