package sem5;

import java.util.HashMap;

public class tsk1 {
    public static void main(String[] args) {
//        посчитать сколько каждое слово встречается в тексте
        HashMap<String, Integer> test = new HashMap<>();
        String text = "asdfa lakjdf kjad kk kk ajdfl kjal kjfalsdkjf kk";
        String[] words = text.split(" ");
        for (String word: words) {
//            if (test.containsKey(word)) {
//                test.put(word, test.get(word) + 1);
//            } else {
//                test.put(word, 1);
//            }
            test.putIfAbsent(word, 0);
            test.put(word, test.get(word) + 1);
        }
        System.out.println(test);
    }
}
