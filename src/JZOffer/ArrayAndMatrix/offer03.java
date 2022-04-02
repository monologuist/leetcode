package JZOffer.ArrayAndMatrix;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 找出数组中重复的数字。
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 *
 */
public class offer03 {
    /**
     * 解法3：哈希查找：利用set集合特性 遍历数组
     * 如果添加失败，说明该元素已经在集合中，它是一个重复元素，将这个值赋给repeat，结束遍历，返回repeat
     *
     * 时间复杂度分析：
     * 时间复杂度：O(n)。遍历数组一遍。使用哈希集合(HashSet)，添加元素的时间复杂度为O(1),故总的时间复杂度为O(n)。
     * 空间复杂度：O(n)。不重复的每个元素都可能存入集合，因此占用O(n)额外空间。
     * @param nums
     * @return
     */
    public int findRepeatNumber3(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)){
                repeat = num;
                break;
            }
        }
        return repeat;
    }

    /**
     * 解法2：数组代替哈希表
     * 注意题目信息：数组中每个元素的大小在 0 ~ n - 1 的范围内
     * 同样的时空复杂度，数组比哈希表有性能提升
     * ->哈希表 (HashSet) 底层是使用数组 + 链表或者红黑树组成的，而且它的数组也是用不满的，有加载因子的。所以使用数组来代替哈希表，能节省空间
     * ->哈希表在判重的时候需要经过哈希计算，还可能存在哈希冲突的情况，而使用数组则可以直接计算得到 index 的内存位置，所以使用数组访问性能更好。
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber2(int[] nums) {
        // 1. 初始化一个数组
        int[] bucket = new int[nums.length];
        Arrays.fill(bucket, -1);
        for (int i = 0; i < nums.length; i++) {
            // 2. 判断当前元素是否已经存在
            if (bucket[nums[i]] != -1){
                // 如果存在，则直接返回
                return nums[i];
            }
            // 否则的话，将当前元素作为索引，当前元素的下标作为值，填入数组中，
            // 方便后续的查找判重
            bucket[nums[i]] = i;
        }
        return -1;
    }

    /**
     * 最优解法：时间复杂度O(n)，空间复杂度O(1)
     * @param nums
     * @return
     */
    public int findRepeatNumber1(int[] nums){
        for (int i = 0; i < nums.length; i++){
            while (i != nums[i]){
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }

                // 交换
                int tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            }
        }

        return -1;
    }

    /**
     * 解法4 ：暴力解法
     * 遍历数组中的每个元素，然后在剩下的元素中寻找是否存在相同的元素
     * 时间复杂度O(n^2),空间复杂度O(1),性能很差
     * @param nums
     * @return
     */
     public int findRepeatNumber4(int[] nums) {
         for (int i = 0; i < nums.length; i++) {
             for (int j = i+1; j < nums.length; j++) {
                 if (nums[i] == nums[j]){
                     return nums[i];
                 }
             }
         }
         return -1;
     }

}
