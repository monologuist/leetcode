package amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.cnblogs.com/katoMegumi/p/14462674.html
 *
 * 题目：
 * 给定一个范围在 1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 *
 * 解题思路：因为1 ≤ a[i] ≤ n，所以我们可以将数组的元素作为下标对对应下标的数字进行 +n的操作，之后对数组进行遍历，数值 <= n的则说明没有进行过 +n的操作即原数组中没有对应的下标的值
 */
public class missingNumber {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList();
        int len = nums.length;

        for(int num : nums) {
            int idx = (num - 1) % len;
            nums[idx] += len;
        }

        for(int i = 0; i < len; i++) {
            if(nums[i] <= len) {
                ans.add(i + 1);
            }
        }

        return ans;
    }
}
