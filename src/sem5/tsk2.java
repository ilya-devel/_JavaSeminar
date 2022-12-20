package sem5;

import java.util.HashSet;
import java.util.Set;

public class tsk2 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        String[] words = "a b c d e f".split(" ");
        for (String word: words) {
            if (set.contains(word)) {
                System.out.println("true");
                return;
            }
            set.add(word);
        }
        System.out.println("false");
    }
}
