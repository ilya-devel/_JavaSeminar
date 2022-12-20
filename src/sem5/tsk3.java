package sem5;

import java.util.HashSet;
import java.util.Set;

public class tsk3 {
    public static void main(String[] args) {
        int[] lst = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(containsDuplicate(lst));
    }
    public static boolean containsDuplicate (int[] nums) {
        Set<Integer> tmp = new HashSet<>();
        for (int num: nums) {
            if (tmp.contains(num)) return true;
            tmp.add(num);
        }
        return false;
    }
}
