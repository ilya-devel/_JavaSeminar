package sem1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class homeworks {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "def"));
        int[] tmp = {3, 2, 2, 3};
        System.out.println(removeElement(tmp, 3));
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length()) res.append(word1.charAt(i));
            if (j < word2.length()) res.append(word2.charAt(j));
            i++;
            j++;
        }
        return res.toString();
    }

    public static int removeElement(int[] nums, int val) {
        for (int i = 0; i < nums.length; i++) if (nums[i] == val) nums[i] = -1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = tmp;
        }
        for (int i = 0; i < nums.length; i++) if (nums[i] == -1) return i;
        return nums.length;
    }
}
