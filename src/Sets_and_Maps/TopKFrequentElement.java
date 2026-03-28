package Sets_and_Maps;

import java.util.*;

public class TopKFrequentElement {
    static void main(String[] args) {
        int[] nums = {4, 4, 4, 6, 6, 2, 2, 2, 2, 3, 3};
        int k = 2;

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
                map.put(key, map.getOrDefault(key, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entries : set){
            list.add(entries);
        }
        list.sort((x,y)->y.getValue()-x.getValue());

        System.out.println(list);

        for (int i = 0; i < k; i++) {
           IO.println( list.get(i).getKey());
        }
    }
}
