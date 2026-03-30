//Given an unsorted integer array nums, return the
//length of the longest consecutive sequence of elements.
//Must run in O(n) time — so you can't sort.
//Example: nums = [100, 4, 200, 1, 3, 2] → 4 (the sequence is [1, 2, 3, 4])
//Example: nums = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1] → 9 (the sequence is [0, 1, 2, 3, 4, 5, 6, 7, 8])

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    static int longestSeq = 0;

    static void main(String[] args) {
        int[] nums = new int[]{100, 4, 200, 1, 3, 11,12,13,14,14};
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        IO.println(set);
        //start counting from numbers that are the
        // beginning of a sequence — meaning num - 1
        // does NOT exist in the set

        for(Integer i : set){
            if(!set.contains(i-1)){
                int count =1;
                while(set.contains(i+1)){

                    count++;
                    i++;
                    if(count>longestSeq){
                        longestSeq=count;
                    }
                }
            }else {
                continue;
            }
        }
        IO.println(longestSeq);
    }
}
