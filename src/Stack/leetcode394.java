package Stack;
//给定一个经过编码的字符串，返回它解码后的字符串。 s = "3[a]2[bc]", 返回 "aaabcbc". s = "3[a2[c]]", 返回 "accaccacc". s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
//思路：数字一个栈，字母一个栈，取出来计算就可以了。

import java.util.LinkedList;

public class leetcode394 {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stackMulti = new LinkedList<>();
        LinkedList<StringBuilder> stackRes = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '[') {
                stackMulti.addLast(multi);
                stackRes.addLast(res);
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = stackRes.removeLast();
                int curMulti = stackMulti.removeLast();
                for (int i = 0; i < curMulti; ++i) {
                    tmp.append(res);
                }
                res = tmp;
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
