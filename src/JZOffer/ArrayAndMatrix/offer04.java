package JZOffer.ArrayAndMatrix;

import com.sun.org.apache.bcel.internal.generic.ARETURN;

/**
 * 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 *
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 *
 */
public class offer04 {
    /**
     * 站在右上角看。这个矩阵其实就像是一个Binary Search Tree。
     *
     * 时间复杂度O(m+n),空间复杂度O(1
     *
     * 从右上角开始走，利用这个顺序关系可以在O(m+n)的复杂度下解决这个题：
     *
     * 如果当前位置元素比target小，则row++
     * 如果当前位置元素比target大，则col--
     * 如果相等，返回true
     * 如果越界了还没找到，说明不存在，返回false)
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0,col = n-1;
        while (row < m && col >= 0){
            if (matrix[row][col] > target){
                col--;
            }else if (matrix[row][col] < target){
                row++;
            }else {
                return true;
            }
        }
        return false;
    }



}
