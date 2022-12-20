package sem5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class tsk4 {
    public static void main(String[] args) {
        int[] lst = new int[] {2, 7, 11, 15};
        int value = 9;
        System.out.println(twoSum(lst, value).toString());
    }

    public static int[] twoSum(int[] nums, int target) {
//        HashMap<Integer, Integer> values = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) values.put(nums[i], i);
//        for (int key: values.keySet()) {
//            if (values.containsKey(target - key)) {
//                return new int[] {values.get(key), values.get(target - key)};
//            }
//        }
//        return new int[] {};
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
