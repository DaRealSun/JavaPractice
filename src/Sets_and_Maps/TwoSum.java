package Sets_and_Maps;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    static void main(String[] args) {
        int[] a = {2,2,4,-3};
        int target = 4;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if(map.containsKey(target- a[i])){
                IO.println(""+map.get(target-a[i])+i);

                break;
            }
            map.put(a[i],i);

        }
    }
}
