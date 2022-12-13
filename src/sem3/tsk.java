package sem3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class tsk {
    public static void main(String[] args) {
//        Замерить добавление 10000 элементов в начало ArrayList, в начало LinkedList
        getTimeArray();
        getTimeLinked();
//        Создайте массив с “сырым типом”, добавьте туда разные типы данных. Удалите только числа.
        ArrayList<Object> lst = new ArrayList<>();
        lst.add(1);
        lst.add("adfa");
        lst.add(1);
        lst.add("adfjla");
        delNumInArray(lst);
// Создайте массив String[]. Из него получите ArrayList<String> используйте метод Arrays.asList. Попробуйте в получившийся ArrayList<String> добавить новую строку, что произойдет?
        checkArrayList();
// На вход приходят два ArrayList<Integer> напишите метод, который проверяет два массива на равенство.
        checkTwoArrayLst();
// На вход методу приходят два ArrayList<Integer> и целое число num. Проверьте, что число num встречается в обоих массивах одинаковое кол-во раз.
        List<Integer> lst1 = Arrays.asList(3, 2, 3, 4, 5, 6, 7);
        List<Integer> lst2 = Arrays.asList(1, 2, 3, 2, 3, 6, 9, 7);
        checkValueInArray(lst1, lst2, 2);
// На вход приходит ArrayList<Integer>. Отсортируйте в нем только четные числа. Пример: [10, 4, 5, 6, 7, 2, 2, 9] -> [2, 2, 5, 4, 7, 6, 10, 9]
        ArrayList<Integer> sortLst = new ArrayList<>(Arrays.asList(10, 4, 5, 6, 7, 2, 2, 9, 13, 66, 71, 32));
        sortEvenValueInArray(sortLst);
        System.out.println(sortLst);
    }

    public static void getTimeArray() {
        ArrayList<Integer> tmp = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            tmp.add(0, i);
        }
        long fin = System.currentTimeMillis();
        System.out.println(fin - start);
    }

    public static void getTimeLinked() {
        LinkedList<Integer> tmp = new LinkedList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            tmp.add(0, i);
        }
        long fin = System.currentTimeMillis();
        System.out.println(fin - start);
    }

    public static void delNumInArray(ArrayList<Object> lst) {
        for (int i = lst.size() - 1; i >= 0; i--) {
//            if (lst.get(i).getClass().getName() == "java.lang.Integer") {
            if (lst.get(i) instanceof Integer) {
                lst.remove(i);
            }
        }
        System.out.println(lst);
    }

    public static void checkArrayList() {
        String[] slst = {"abc", "def", "ghi", "jkl"};
        List<String> newStrLst = Arrays.asList(slst);
        List<String> chgeLst = new ArrayList<>(newStrLst);
        chgeLst.add(0, "___");
        System.out.printf("Orig = %s\n", newStrLst);
        System.out.printf("Change = %s\n", chgeLst);
    }

    public static void checkTwoArrayLst() {
        ArrayList<Integer> lst1 = new ArrayList<>();
        ArrayList<Integer> lst2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lst1.add(i);
            lst2.add(i);
        }
        System.out.println(lst1 == lst2);
        System.out.println(lst1.equals(lst2));
    }

    public static void checkValueInArray(List<Integer> lst1, List<Integer> lst2, int val) {
        int res = 0;
        int l1 = lst1.size() - 1, l2 = lst2.size() - 1;
        while (l1 >= 0 || l2 >= 0) {
            if (l1 >= 0 && lst1.get(l1) == val) res++;
            if (l2 >= 0 && lst2.get(l2) == val) res--;
            l1--;
            l2--;
        }
        System.out.printf("Указанное значение встречается%s равное количество раз в обоих списках\n", (res == 0 ? "" : " не"));
    }

    public static void sortEvenValueInArray(List<Integer> lst) {
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i) % 2 == 0) {
                int ind = i, tmp;
                for (int j = i + 1; j < lst.size(); j++) {
                    if (lst.get(i) > lst.get(j) && lst.get(ind) > lst.get(j) && lst.get(j) % 2 == 0) {
                        ind = j;
                    }
                }
                tmp = lst.get(i);
                lst.set(i,lst.get(ind));
                lst.set(ind, tmp);
            }
        }
    }
}
