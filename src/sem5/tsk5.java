package sem5;

import java.util.*;

public class tsk5 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2,};
        for (int val: intersection(nums1,nums2)) System.out.printf("%d\t", val);
        System.out.println();
        for (int val: intersect(nums1,nums2)) System.out.printf("%d\t", val);
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return intersection(nums2, nums1);
        Set<Integer> nums = new HashSet<>();
        for (int num : nums1) nums.add(num);
        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (nums.contains(num)) {
                result.add(num);
                nums.remove(num);
            }
        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) answer[i] = result.get(i);
        return answer;
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return intersect(nums2, nums1);
        HashMap<Integer, Integer> valCount = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            valCount.putIfAbsent(nums1[i], 0);
            valCount.put(nums1[i], valCount.get(nums1[i]) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int val : nums2) {
            if (valCount.containsKey(val) && valCount.get(val) > 0) {
                valCount.put(val, valCount.get(val) - 1);
                result.add(val);
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) answer[i] = result.get(i);
        return answer;
    }
}
