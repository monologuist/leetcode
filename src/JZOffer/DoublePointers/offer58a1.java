package JZOffer.DoublePointers;

/**
 * 注意：本题与主站 151 题相同：https://leetcode-cn.com/problems/reverse-words-in-a-string/
 *
 * 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 */
public class offer58a1 {
    /**
     * 先翻转每个单词，再翻转整个字符串。
     *
     * 题目应该有一个隐含条件，就是不能用额外的空间。
     * 虽然 Java 的题目输入参数为 String 类型，
     * 需要先创建一个字符数组使得空间复杂度为 O(N)，
     * 但是正确的参数类型应该和原书一样，为字符数组，并且只能使用该字符数组的空间。
     * 任何使用了额外空间的解法在面试时都会大打折扣，包括递归解法。
     * @param str
     * @return
     */
    public String ReverseSentence(String str) {
        int n = str.length();
        char[] chars = str.toCharArray();
        int i = 0, j = 0;
        while (j <= n) {
            if (j == n || chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        reverse(chars, 0, n - 1);
        return new String(chars);
    }

    private void reverse(char[] c, int i, int j) {
        while (i < j)
            swap(c, i++, j--);
    }

    private void swap(char[] c, int i, int j) {
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }


    /**
     * 思路2：双指针
     * 算法解析：
     * 1.倒序遍历字符串s ，记录单词左右索引边界i ,j ；
     * 2.每确定一个单词的边界，则将其添加至单词列表res ；
     * 3.最终，将单词列表拼接为字符串，并返回即可。
     * 复杂度分析：
     * 时间复杂度O(N) ： 其中N 为字符串s 的长度，线性遍历字符串。
     * 空间复杂度O(N) ： 新建的 list(Python) 或 StringBuilder(Java) 中的字符串总长度≤N ，占用O(N) 大小的额外空间。
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        s = s.trim(); // 删除首尾空格
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while(i >= 0) {
            while(i >= 0 && s.charAt(i) != ' ') i--; // 搜索首个空格
            res.append(s.substring(i + 1, j + 1) + " "); // 添加单词
            while(i >= 0 && s.charAt(i) == ' ') i--; // 跳过单词间空格
            j = i; // j 指向下个单词的尾字符
        }
        return res.toString().trim(); // 转化为字符串并返回
    }


    /**
     * 至于那种利用 “字符串分割”、“列表倒序”，就不要使用了
     */

}
