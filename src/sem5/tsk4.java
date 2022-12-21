package sem5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class tsk4 {
    public static void main(String[] args) {
        int[] lst = new int[] {2, 7, 11, 15};
        int value = 9;
        System.out.println(Arrays.toString(twoSum(lst, value)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[] {map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
