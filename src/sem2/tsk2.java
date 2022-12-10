package sem2;

import java.util.ArrayList;
import java.util.List;

public class tsk2 {
    public static void main(String[] args) {
        getLeaf(1, 5, 1, 2, "");
    }

    public static void getLeaf(int scr, int trg, int add, int mult, String path) {
        if (scr > trg) return;
        if (scr == trg) {
            System.out.println(path + " = " + trg);
            return;
        }
        getLeaf(scr + add, trg, add, mult, path + " => " + scr + " + " + add);
        getLeaf(scr * mult, trg, add, mult, path + " => " + scr + " * " + add);
    }
}
