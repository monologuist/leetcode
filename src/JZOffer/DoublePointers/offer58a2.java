package JZOffer.DoublePointers;

/**
 * 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 *
 */

/**
 * 这类字符串翻转问题，考点在双指针，难点在隐含了不能使用额外的空间
 * 所以我们都是考虑原地翻转的做法 比如offer58a1和offer58a2
 * 模版：先做一个翻转函数 reverse(char[] chars, int i, int j)，再来一个交换函数swap(char[] chars, int i, int j)
 * 这两个都是固定要有的
 * 然后思考怎么调用reverse()函数
 */
public class offer58a2 {
    /**
     * Input:
     * S="abcXYZdef"
     * K=3
     *
     * Output:
     * "XYZdefabc"
     * 思路：先将 "abc" 和 "XYZdef" 分别翻转，得到 "cbafedZYX"，然后再把整个字符串翻转得到 "XYZdefabc"。
     */
    public String LeftRotateString(String str, int n) {
        if (n >= str.length())
            return str;
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j)
            swap(chars, i++, j--);
    }

    private void swap(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }


    /**
     * 方法2、3、4均见
     * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/solution/mian-shi-ti-58-ii-zuo-xuan-zhuan-zi-fu-chuan-qie-p/
     * 不建议使用 会增加额外空间
     */
}
