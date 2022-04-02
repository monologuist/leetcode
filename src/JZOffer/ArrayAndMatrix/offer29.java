package JZOffer.ArrayAndMatrix;

/**
 * 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
 *
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class offer29 {
    /**
     * 算法1：按照四个顺序遍历打印
     * 每个顺序要做三件事：1。打印；2。收缩边界；3。执行边界判断
     * 画一张图会非常清晰
     *
     * 算法流程：
     *
     * 空值处理： 当 matrix 为空时，直接返回空列表 [] 即可。
     * 初始化： 矩阵 左、右、上、下 四个边界 l , r , t , b ，用于打印的结果列表 res 。
     * 循环打印： “从左向右、从上向下、从右向左、从下向上” 四个方向循环，每个方向打印中做以下三件事 （各方向的具体信息见下表） ；
     *  1。根据边界打印，即将元素按顺序添加至列表 res 尾部；
     *  2。边界向内收缩 1 （代表已被打印）；
     *  3。判断是否打印完毕（边界是否相遇），若打印完毕则跳出。
     * 返回值： 返回 res 即可。
     *
     * 打印方向	1. 根据边界打印	2. 边界向内收缩	3. 是否打印完毕
     * 从左向右	左边界l ，右边界r	 上边界 t 加1	是否 t > b
     * 从上向下	上边界t ，下边界b	 右边界 r 减1	是否 l > r
     * 从右向左	右边界r ，左边界l	 下边界 b 减1	是否 t > b
     * 从下向上	下边界b ，上边界t	 左边界 l 加1	是否 l > r
     *
     *
     *
     *
     * 时间复杂度O(MN) ：M,N 分别为矩阵行数和列数。
     * 空间复杂度O(1) ： 四个边界 l , r , t , b 使用常数大小的 额外 空间（ res 为必须使用的空间）。
     *
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        int row = matrix.length;
        if(row == 0){
            return new int[0];
        }
        int col = matrix[0].length;
        int[] res = new int[row*col];
        int index = 0;
        int left = 0,up = 0,right = col-1,down = row -1;

        while (true){
            //从左向右
            for (int i = left; i <= right ; i++) {
                res[index++] = matrix[up][i];
            }
            if (++up > down)break;

            //从上向下
            for (int i = up; i <= down; i++) {
                res[index++] = matrix[i][right];
            }
            if (--right < left)break;

            //从右向左
            for (int i = right; i >= left ; i--) {
                res[index++] = matrix[down][i];
            }
            if (--down < up)break;

            //从下向上
            for (int i = down; i >= up; i--) {
                res[index++] = matrix[i][left];
            }
            if (++left > right)break;
        }
        return res;
    }
}
