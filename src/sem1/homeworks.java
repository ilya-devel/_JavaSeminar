package sem1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class homeworks {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "def"));
        int[] tmp = {3, 2, 2, 3};
        System.out.println(removeElement(tmp, 3));
        int[] tmp1 = {1, 2, 3, 0, 0, 0};
        int[] tmp2 = {2, 5, 6};
        merge(tmp1, 3, tmp2, 3);
        System.out.println(Arrays.toString(tmp1));
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
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

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[i + m] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] tmp = s.split(" ");
        for (int i = tmp.length - 1; i >= 0; i--) if (tmp[i].trim() != "") sb.append(tmp[i] + ' ');
        return sb.toString().trim();
    }

    public static boolean isPalindrome(String s) {
        char[] ss = s.toLowerCase().toCharArray();
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (Character.isLetterOrDigit(ss[l])) {
                while (r >= 0) {
                    if (Character.isLetterOrDigit(ss[r])) {
                        if (ss[l] != ss[r]) return false;
                        r--;
                        break;
                    }
                    r--;
                }
            }
            l++;
        }
        return true;
    }
}
