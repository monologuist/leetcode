package JZOffer.DoublePointers;

/**
 * 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * 示例：输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 */
public class offer57a1 {
    /**
     * 典型的使用双指针的问题：数组有序
     * 使用双指针，一个指针指向元素较小的值，一个指针指向元素较大的值。指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
     *
     * 如果两个指针指向元素的和 sum == target，那么这两个元素即为所求。
     * 如果 sum > target，移动较大的元素，使 sum 变小一些；
     * 如果 sum < target，移动较小的元素，使 sum 变大一些。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int l = 0,r = nums.length - 1;
        while(l < r) {
            int sum = nums[l] + nums[r];
            if(target < sum) {
                r--;
            } else if (target > sum) {
                l++;
            } else {
                return new int[]{nums[l],nums[r]};
            }
        }

        return new int[]{};
    }
}
