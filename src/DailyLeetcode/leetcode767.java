package DailyLeetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1。遍历字符串
 * 2。每个字母出现次数统计
 * 3。有大于（n+1）/2的返回空
 * 4。排布-最大堆
 *
 * 维护最大堆存储字母，堆顶元素为出现次数最多的字母。首先统计每个字母的出现次数，然后将出现次数大于0的字母加入最大堆。
 * 当最大堆的元素个数大于1时，每次从最大堆取出两个字母，拼接到重构的字符串，然后将两个字母的出现次数分别减1
 * 并将剩余出现次数大于0的字母重新加入最大堆。由于最大堆中的元素都是不同的，因此取出的两个字母一定也是不同的，将两个不同的字母拼接到重构的字符串，可以确保相邻的字母都不相同。
 *
 * 如果最大堆变成空，则已经完成字符串的重构。如果最大堆剩下1个元素，则取出最后一个字母，拼接到重构的字符串。
 *
 * 对于长度为n的字符串，共有n/2次每次从最大堆取出两个字母的操作，当n是奇数时，还有一次从最大堆取出一个字母的操作，因此重构的字符串的长度一定是n。
 *
 * 当n是奇数时，是否可能出现重构的字符串的最后两个字母相同的情况？如果最后一个字母在整个字符串中至少出现了2 次，则在最后一次从最大堆取出两个字母时，该字母会先被选出，因此不会成为重构的字符串的倒数第二个字母，也不可能出现重构的字符串最后两个字母相同的情况。
 * 因此，在重构字符串可行的情况下，基于最大堆的贪心算法可以确保得到正确答案。
 *
 */
public class leetcode767 {
    public String reorganizeString(String S) {
        if (S.length() < 2) {
            return S;
        }
        int[] counts = new int[26];
        int maxCount = 0;
        int length = S.length();
        /**
         * 26个英文字母每个字母出现的次数统计
         */
        for (int i = 0; i < length; i++) {
            /**
             * 品味这个  counts[c - 'a']++
             */
            char c = S.charAt(i);
            counts[c - 'a']++;
            /**
             * 不断更新出现次数最多的字母的出现次数
             */
            maxCount = Math.max(maxCount, counts[c - 'a']);
        }
        /**
         * 如果存在一个字母的出现次数大于(n+1)/2，则无法重新排布字母使得相邻的字母都不相同
         * 返回空
         */
        if (maxCount > (length + 1) / 2) {
            return "";
        }

        /**
         * 用队列实现最大堆
         */
        PriorityQueue<Character> queue = new PriorityQueue<Character>(new Comparator<Character>() {
            public int compare(Character letter1, Character letter2) {
                return counts[letter2 - 'a'] - counts[letter1 - 'a'];
            }
        });

        /**
         * 按照每个字母的出现次数排好队列
         */
        for (char c = 'a'; c <= 'z'; c++) {
            if (counts[c - 'a'] > 0) {
                queue.offer(c);
            }
        }

        /**
         * 构建出来的输出字符串
         */
        StringBuffer sb = new StringBuffer();
        while (queue.size() > 1) {
            /**
             * 获取并移除此队列的头
             */
            char letter1 = queue.poll();
            char letter2 = queue.poll();
            /**
             * Stringbuffer是动态字符串数组，append( )是往动态字符串数组添加
             */
            sb.append(letter1);
            sb.append(letter2);
            int index1 = letter1 - 'a', index2 = letter2 - 'a';
            counts[index1]--;
            counts[index2]--;
            if (counts[index1] > 0) {
                queue.offer(letter1);
            }
            if (counts[index2] > 0) {
                queue.offer(letter2);
            }
        }
        if (queue.size() > 0) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }
}
