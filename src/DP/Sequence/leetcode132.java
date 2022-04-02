package DP.Sequence;

import java.util.Arrays;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回符合要求的最少分割次数。
 *
 * 方法：预处理+dp
 */
public class leetcode132 {
    boolean[][] can;
    public int minCut(String s) {
        int len = s.length();
        can = new boolean[len][len];
        for(int i = 0; i < len; i++){
            prePro(can, s, i, i, len);
            prePro(can, s, i, i + 1, len);
        }
        /*

         */
        int[] dp = new int[len + 1];
        Arrays.fill(dp, len);
        dp[0] = 0;
        //遍历字符串的整个位置，这里以 i 作为子串的结尾， 即获取 [0, i] 子串分割为回文串的最少切割数
        for(int i = 0; i < len; i++){
            /**
             * 这里遍历 子串的所有位置，寻找切割点
             *         如果 can[j][i] = true，那么表示 [j, i] 可以切分为一个回文串，
             *         那么这样的话 dp[i] = dp[j - 1] + 1，意思是在 j 位置切一刀，分为 [0, j - 1] 和 [j, i] 子串
             *         然后 dp[j - 1] 就表示将 [0, j - 1] 切分为回文串的最少切割数
             *         一步步进行状态转移
             *         遍历所有的切割点，寻找 i 的最少切割数
             */
            for(int j = 0; j <= i; j++){
                if(can[j][i]){
                    dp[i + 1] = Math.min(dp[j] + 1, dp[i + 1]);
                }
            }
        }
        return dp[len] - 1;
    }
    /*
         预处理，先找到所有能够形成回文串的位置
         中心扩展，最坏情况下整个字符串都是回文，那么是 O（n^2）
     */
    private void prePro(boolean[][] dp, String str, int left, int right, int len){

        while(left >= 0 && right < len && str.charAt(left) == str.charAt(right)){
            dp[left][right] = true;
            left--;
            right++;
        }
    }

}
