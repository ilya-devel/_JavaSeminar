package sem5.homeworks;

import java.util.*;

public class hwtsk1 {
    public static void main(String[] args) {
//        String[] words1 = new String[]{"leetcode", "is", "amazing", "as", "is"};
        String[] words1 = new String[]{"ibxyatvglhltxngewrcrqbbnew", "towokpjpkccmob", "kdmtwngzpebwpnvlazhdcmtwpjh", "muh", "fzzlmacbbvoqdueutjqoutwd", "ylluspdftxxqbwadivfdzulghq", "hioiacezaiptpsvcojzckhxz", "nzcjhjomaupevyekennyrfwyd", "tdwtuinstwsfyjnfkxkbnsptisuifo", "wrdwoxzsczzlnwjugopohxh", "p", "jkez", "drisymx", "fsva", "myqc", "aovjoxzpkylpecltwtottzidq", "wqspbhpberqjabockesc", "f", "qostobxgfliil", "gsekmhjpuedeivioudx", "tzelzowtgnvjsxgbw", "zgmpazgnioprk", "fucybddarjcve", "ldacfviysy", "yxyjairoxtvbkljaokca", "vxpiohhvjuwcpiceafcdzobalgpz", "wyflbpmkfwftndgtnftajgla", "xbxvvk", "bnrwyshimjamltmlugeiviu", "wsgqysmuakedrrmjk", "ppqmgibqljkwgmiwi", "fly", "uf", "tvvttzrsjbojve", "ztxtnmljdhyz", "vxonvloufeksfvg", "wql", "kotdenqjrdlgofubocb", "wlaqceczd", "mtmhtgvqwr", "aymzxpfvbqxydmilafyqvapuxtnqe", "ig", "atetjlhdcigunmmit", "enkdcxqnw", "gtlcmkxwvdhumgfurxkesmekmnhjo", "hurihasxncgtzleerslvwxkz", "zked", "xiaqvclhuhggcgoouzjgi", "mzejuubgyhvlfbecpmggddby", "boyotuukuiprtlvktypxboosw", "vwfceei", "gopsxsihawzhtlmdyiggljzggrhqr", "bckuuqszgncdhkeghudflczm", "e", "yvhwysrunkxsppbqjf", "lo", "bze", "kuzoqvgugnrpfkelktfg", "ntjtlwwmuevtsqujpxswgx", "zkdwtpdlvrfkbyktqsellmghaxj", "u", "rpmpq", "ajhlzwfrbysqloduofr", "gyfmhcskcrjepgeplbbj", "fe", "zyolvtetrdffy", "apbkyczsuvde", "fnkqf", "qwwxpwbr", "krkbnww", "zkvqkugfpziawiokdzlpjomfarkor", "jg", "l", "srbvxsnuhyqzmycvavmmakh", "dhkgzjrstir", "smaaptkzpwhukebwboysbnawgzgot"};
//        String[] words2 = new String[]{"amazing", "leetcode", "is"};
        String[] words2 = new String[]{"p", "towokpjpkccmob", "vflbjyecpzxnuay", "fzas", "fzzlmacbbvoqdueutjqoutwd", "bwjjzw", "va", "manrvuldjzrdnwihzct", "tdwtuinstwsfyjnfkxkbnsptisuifo", "wrdwoxzsczzlnwjugopohxh", "p", "tylcyihdjruhaayzcwxrynnkch", "uojzddpgyvqslha", "fsva", "rucvbjzfewjlhddxefhf", "tfihr", "wqspbhpberqjabockesc", "f", "bmfo", "zsjbzjmbloaybdofsrqvzwoizz", "tzelzowtgnvjsxgbw", "tproznqma", "lmryjiyvkgsxsaylkdmmxeub", "ldacfviysy", "xpamoswlugwjxyny", "rmfvgm", "wm", "xbxvvk", "ubawz", "jbrabb", "rgegpb", "fly", "aofydpklgjqmxhvxuhq", "tvvttzrsjbojve", "wj", "vxonvloufeksfvg", "wql", "vu", "nhuxqdfyftrbbodztyydb", "mtmhtgvqwr", "aymzxpfvbqxydmilafyqvapuxtnqe", "fqksatpfo", "ylzkfvvzdsryl", "enkdcxqnw", "gtlcmkxwvdhumgfurxkesmekmnhjo", "nccwybkxuawwdqyhrhmbt", "zked", "eyzwtvsjt", "qy", "boyotuukuiprtlvktypxboosw"};
        System.out.println(countWords(words1, words2));
    }

    public static int countWords(String[] words1, String[] words2) {
        if (words1.length > words2.length) {
            return countWords(words2, words1);
        }
        Map<String, Integer> lstWords = new HashMap<>();
        for (String word : words1) {
            lstWords.putIfAbsent(word, 0);
            lstWords.put(word, lstWords.get(word) + 1);
        }
        for (String word : words2) {
            if (lstWords.containsKey(word) && lstWords.get(word) <= 1) {
                lstWords.put(word, lstWords.get(word) - 1);
            }
        }
        int count = 0;
        for (String word : lstWords.keySet()) {
            if (lstWords.get(word) == 0) count++;
        }
        return count;
    }
}
