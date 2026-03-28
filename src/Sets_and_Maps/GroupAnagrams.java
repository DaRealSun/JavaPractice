package Sets_and_Maps;

import java.util.*;

public class GroupAnagrams {
    static void main(String[] args) {
        String[] list = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(Arrays.toString(list));

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < list.length; i++) {

            char[] key = list[i].toCharArray();
            Arrays.sort(key);
            String keyString = String.valueOf(key);

            if(!map.containsKey(keyString)){
                ArrayList<String> list1 = new ArrayList<>();
                list1.add(list[i]);
                map.put(keyString, list1);
            }else {
                map.get(keyString).add(list[i]);

        }}
        System.out.println(map);

    }
}
