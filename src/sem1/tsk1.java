package sem1;


public class tsk1 {
    public static void main(String[] args) {
        System.out.println(addStrings("123", "23"));
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
}