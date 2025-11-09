import java.util.Scanner;

public class PrintReverse {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            System.out.print("Enter an integer: ");
            int n = input.nextInt();

            System.out.print("Reversed: ");
            reverseDisplay(n);
            System.out.println();
            System.out.print("Enter a String: ");
            String s = input.next();
            System.out.print("Reversed: ");
            reverseDisplay(s);

            System.out.println();
        }
    public static void reverseDisplay(String s) {
        reverseDisplay(s, s.length() - 1);
    }
    public static void reverseDisplay(String value, int last) {
        if(last==0){
            System.out.println(value.charAt(0));;
        }else {
            System.out.print(value.charAt(last));

            reverseDisplay(value,last-1);
        }

    }

        public static void reverseDisplay(int value) {
            // handle negative numbers
            if (value < 0) {
                System.out.print("-");
                value = -value;
            }

            if (value < 10) {              // base case: one digit
                System.out.print(value);
            } else {
                System.out.print(value % 10);      // print last digit
                reverseDisplay(value / 10);        // recurse on the rest
            }
        }
    }


