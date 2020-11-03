package Stack;
//给定一个由  '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
//思路：通过深度搜索遍历可能性（注意标记已访问元素）
public class leetcode200 {
    int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
    private int dfs (char[][] grid,boolean[][] visited,int x,int y,int count){
        if (x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y] != '1' || visited[x][y]){
            return count;
        }
        visited[x][y] = true;
        for (int i = 0;i<move.length;++i){
            count = dfs(grid,visited,x+move[i][0],y+move[i][1],count);
        }
        return count+1;
    }

    public int numIslands(char[][] grid) {
        if(grid.length == 0)
            return 0;
        int total = 0, row = grid.length, col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int count = 0;
        //二维数组遍历
        for(int i = 0; i < row; ++i){
            for(int j = 0; j < col; ++j){
                if(grid[i][j] == '1'){
                    count = dfs(grid, visited, i, j, 0);
                    if(count >= 1){
                        total++;
                    }
                }
            }
        }
        return total;
    }
}
