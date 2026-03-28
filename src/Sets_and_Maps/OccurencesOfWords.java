package Sets_and_Maps;

import java.util.*;

public class OccurencesOfWords
{
    static void main(String[] args) {
        String text = "Good morning. Have a good class. "
                + "Have a good visit. Have fun! ";
        Map<String,Integer> map = new HashMap<>();
        String[] word = text.split("[ \n\t\r.,;:!?/><]");
        for (String s : word) {
            String key = s.toLowerCase();
            if (!key.isEmpty()) {
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                } else {
                    int newVal = 1 + map.get(key);
                    map.put(key, newVal);
                }

            }
        }
        Set<Map.Entry<String,Integer>> entry = map.entrySet();
        for(String s : map.keySet()){
            System.out.println(s+" "+map.get(s));
        }
        System.out.println(map);
    }
}
