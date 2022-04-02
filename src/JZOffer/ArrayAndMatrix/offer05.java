package JZOffer.ArrayAndMatrix;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class offer05 {

    /**
     * 算法1：
     * 思路：遍历添加
     * 初始化一个StringBuilder (Java) ，记为 res ；
     * 遍历列表 s 中的每个字符 c ：
     * 当 c 为空格时：向 res 后添加字符串 "%20" ；
     * 当 c 不为空格时：向 res 后添加字符 c ；
     * 将列表 res 转化为字符串并返回。
     *
     * 时间复杂度：O(n)。
     * 空间复杂度：O(n)
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' ') sb.append("%20");
            else sb.append(c);
        }
        return sb.toString();
    }


    /**
     * 算法2：静态数组
     * 熟悉 StringBuilder 的朋友，应该知道它本质上是一个 char 类型的动态数组：
     *
     * 当初始化 StringBuilder 的时候，会初始化一个固定长度的 char 类型的数组
     * 当往 StringBuilder 中 append 数据的时候，其实就是往 char 类型的数组最后追加数据
     *
     * 那么，当追加的数据的个数超过了数组的大小的时候，就需要对 char 类型的数据进行扩容了，所以这里的扩容还是有点性能损耗的，那么我们能不能减少这个性能损耗呢？
     *
     * 答案是可以的，我们可以通过使用静态数组来解决这个问题，从而可以消除数组动态扩容带来的性能损耗。
     * @param s
     * @return
     */
    public String replaceSpace2(String s) {
        /**
         * 由于每次替换从 1 个字符变成 3 个字符，使用字符数组可方便地进行替换。建立字符数组地长度为 s 的长度的 3 倍，这样可保证字符数组可以容纳所有替换后的字符。
         *
         * 获得 s 的长度 length
         * 创建字符数组 array，其长度为 length * 3
         * 初始化 size 为 0，size 表示替换后的字符串的长度
         * 从左到右遍历字符串 s
         * 获得 s 的当前字符 c
         * 如果字符 c 是空格，则令 array[size] = '%'，array[size + 1] = '2'，array[size + 2] = '0'，并将 size 的值加 3
         * 如果字符 c 不是空格，则令 array[size] = c，并将 size 的值加 1
         * 遍历结束之后，size 的值等于替换后的字符串的长度，从 array 的前 size 个字符创建新字符串，并返回新字符串
         *
         *
         */
        int n = s.length();
        char[] newArr = new char[3 * n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                newArr[j++] = '%';
                newArr[j++] = '2';
                newArr[j++] = '0';
            } else {
                newArr[j++] = c;
            }
        }
        return new String(newArr, 0, j);
    }


    public String replaceSpace3(String s) {
        return s.replace(" ","%20");
    }
}
