package Sets_and_Maps;

import java.util.*;

public class CountConsonantsAndVowels {
    static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter: ");
        String line = input.next().toUpperCase();
        Set<Character> vowels = new HashSet<>(Arrays.asList('A', 'U', 'I', 'O', 'E'));

        int vowelsCount = 0;
        int consonantsCount = 0;
        for (char c : line.toCharArray()) {
            if (vowels.contains(c)) {
                vowelsCount++;
            } else {
                consonantsCount++;
            }
        }
        System.out.println("consonantsCount = " + consonantsCount);
        System.out.println("vowelsCount = " + vowelsCount);
    }
}


