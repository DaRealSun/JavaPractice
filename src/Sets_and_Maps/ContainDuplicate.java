import java.util.HashSet;

public class ContainDuplicate {
//Given an integer array nums, return true
// if any value appears at least twice, false
// if every element is distinct.
//Example: nums = [1, 2, 3, 1] → true
//Example: nums = [1, 2, 3, 4] → false
static void main(String[] args) {
    int[] nums = {4,1,2,3,1};
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
        if(set.add(nums[i]) ==  false){
            IO.println("true");
        }else{
            IO.println("false");
        }
    }
}

}
