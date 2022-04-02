package JZOffer.ArrayAndMatrix;

import java.util.*;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 */
public class offer50 {
    /**
     * 算法1：思路：
     * 用字典做：同Daily每日一题练习中leetcode767
     *
     *
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        if (s.equals("")) return ' ';
        //创建‘a'-'z'的字典
        int[] target = new int[26];
        //第一次遍历，将字符统计到字典数组
        for (int i = 0; i < s.length(); i++) {
            target[s.charAt(i) - 'a']++;
        }
        //第二次遍历，从字典数组获取次数
        for (int i = 0; i < s.length(); i++) {
            if (target[s.charAt(i) - 'a'] == 1) return s.charAt(i);
        }

        return ' ';
    }

    /**
     * 算法2：思路：
     * 用哈希表处理：
     * 遍历字符串 s ，使用哈希表统计 “各字符数量是否>1 ”。
     * 再遍历字符串 s ，在哈希表中找到首个 “数量为1的字符”，并返回。
     *
     * 时间复杂度O(N) ：N 为字符串 s 的长度；需遍历 s 两轮，使用O(N) ；HashMap 查找操作的复杂度为O(1) ；
     * 空间复杂度：O(1) ： 由于题目指出 s 只包含小写字母，因此最多有 26 个不同字符，HashMap 存储需占用O(26)=O(1) 的额外空间。
     *
     * @param s
     * @return
     */
    public char firstUniqChar2(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(char c : sc)
            if(dic.get(c)) return c;
        return ' ';
    }

    /**
     * 解法3：思路：
     * 有序哈希表：在哈希表的基础上，有序哈希表中的键值对是 按照插入顺序排序 的。基于此，可通过遍历有序哈希表，实现搜索首个 “数量为1 的字符”。
     * 哈希表是 去重 的，即哈希表中键值对数量≤ 字符串 s 的长度。因此，本方法减少了第二轮遍历的循环次数。当字符串很长（重复字符很多）时，方法二的效率更高
     *
     * @param s
     * @return
     */
    public char firstUniqChar3(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(Map.Entry<Character, Boolean> d : dic.entrySet()){
            if(d.getValue()) return d.getKey();
        }
        return ' ';
    }


    public static void main(String[] args) {
        String s = "loveleetcode";
        offer50 offer50 = new offer50();
        System.out.println(offer50.firstUniqChar(s));
    }
}
