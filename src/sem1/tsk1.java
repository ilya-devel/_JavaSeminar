package sem1;


public class tsk1 {
    public static void main(String[] args) {
        System.out.println(addStrings("123", "23"));
        System.out.println(addBinary("11", "1"));
        System.out.println(mergeAlternately("abc", "def"));
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int n1 = (i < 0) ? 0 : num1.charAt(i) - '0';
            int n2 = (j < 0) ? 0 : num2.charAt(j) - '0';
            int res = n1 + n2 + carry;
            sb.append(res % 10);
            carry = res / 10;
            i--;
            j--;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int ost = 0;
        while (i >= 0 || j >= 0) {
            int n1 = (i < 0) ? 0 : a.charAt(i) - '0';
            int n2 = (j < 0) ? 0 : b.charAt(j) - '0';
            int sum = ost + n1 + n2;
            if (sum == 3) {
                ost = 1;
                sb.append(1);
            }
            if (sum == 2) {
                ost = 1;
                sb.append(0);
            }
            if (sum == 1) {
                ost = 0;
                sb.append(1);
            }
            if (sum == 0) {
                ost = 0;
                sb.append(0);
            }
            i--;
            j--;
        }
        if (ost != 0) sb.append(ost);
        return sb.reverse().toString();
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
}