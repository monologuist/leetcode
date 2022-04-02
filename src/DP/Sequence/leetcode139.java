package DP.Sequence;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个非空字符串  s  和一个包含非空单词列表的字典  wordDict，判定  s  是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * dict 中的单词没有使用次数的限制，因此这是一个完全背包问题。
 * 该问题涉及到字典中单词的使用顺序，也就是说物品必须按一定顺序放入背包中，例如下面的 dict 就不够组成字符串 “leetcode”： ["lee", "tc", "cod"]
 * 求解顺序的完全背包问题时，对物品的迭代应该放在最里层，对背包的迭代放在外层，只有这样才能让物品按一定顺序放入背包中。
 *
 * 定义dp[i]表示字符串s前i个字符组成的字符串s[0..i-1]是否能被空格拆分成若干个字典中出现的单词 是一个boolean类型
 * 那么考虑转移方程：需要枚举s[0,i-1]中的分割点j,看s[0..j-1]组成的字符串s1（默认j=0时s1为空串）和s[j..i-1]组成的字符串s2是否都合法
 * 计算到dp[i]时我们已经计算出dp[0..i-1]的值，所以s1是否合法可以直接由dp[j]得知，问题的关键在剩余子串s2是否为字典中的合法单词
 *
 */
public class leetcode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0;i <= n;i++){
            /**
             * 这里实际是只判断字典中有的单词的长度
             * 比如字典中单词都由3个字母组成，那1和2的情况直接不用判断
             */
            for (String word : wordDict){
                /**
                 * len就是我们思路分析里的j
                 */
                int len = word.length();
                /**
                 * 截取字符串
                 */
                if (len <= i && word.equals(s.substring(i-len,i))){
                    /**
                     *
                     */
                    dp[i] = dp[i] || dp[i-len];
                }
            }
        }
        return dp[n];
    }



    public boolean wordBreak0(String s, List<String> wordDict) {
        /**
         * 直接按分析思路来写：性能不好
         */
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


}
