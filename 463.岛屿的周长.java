
/*
 * @lc app=leetcode.cn id=463 lang=java
 *
 * [463] 岛屿的周长
 */

// @lc code=start
class Solution {
    private final int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    // static int[] dx = { 0, 1, 0, -1 };
    // static int[] dy = { 1, 0, -1, 0 };

    public int islandPerimeter(int[][] grid) {
        /// 一共有多少行
        int rowMax = grid.length;
        /// 一共有多少列
        int colMax = grid[0].length;

        int ans = 0;

        for (int i = 0; i < rowMax; i++) {
            for (int j = 0; j < colMax; j++) {
                if (grid[i][j] == 1) { // 是个陆地
                    ans += dfs(grid, i, j, rowMax, colMax);
                }
            }
        }

        return ans;

    }

    public int dfs(int[][] grid, int row, int col, int rowMax, int colMax) {
        int res = 0;

        // 判断边界且水域
        if (row < 0 || col < 0 || row >= rowMax || col >= colMax || grid[row][col] == 0) {
            return 1;
        }

        if (grid[row][col] == 2) {
            // 防止陆地格子在深度优先搜索中被重复遍历导致死循环
            return 0;
        }

        // 标记访问过了
        grid[row][col] = 2;

        // 像四周扩展
        for (int[] d : directions) {
            int newRow = row + d[0];
            int newCol = col + d[1];
            res += dfs(grid, newRow, newCol, rowMax, colMax);
        }

        return res;
    }

    // public int bfs(int[][] grid, int row, int col) {
    // int[] start = { row, col };

    // Queue<int[]> q = new LinkedList<>();
    // q.offer(start);
    // // 第一个标记一下
    // grid[row][col] = 0;

    // int count = 1;
    // int borders = 0;

    // while (!q.isEmpty()) {
    // for (int k = 0; k < q.size(); k++) {

    // // 访问过的poll掉
    // int[] cur = q.poll();

    // for (int[] d : directions) { // 拿出上下左右放入队列
    // int newRow = cur[0] + d[0];
    // int newCol = cur[1] + d[1];

    // // 判断边界 且 是陆地 则放进队列
    // if (newRow >= 0 && newRow < grid.length
    // && newCol >= 0 && newCol < grid[0].length
    // && grid[newRow][newCol] == 1) {

    // count++;

    // for (int[] d2 : directions) {
    // int newRow2 = newRow + d2[0];
    // int newCol2 = newCol + d2[1];
    // if (newRow2 >= 0 && newRow2 < grid.length
    // && newCol2 >= 0 && newCol2 < grid[0].length) {
    // if (grid[newRow2][newCol2] == 1) {
    // // 边界是0则+1
    // borders++;
    // }
    // }

    // }

    // q.offer(new int[] { newRow, newCol });
    // // 标记访问过了，不然会死循环
    // grid[newRow][newCol] = 0;

    // }
    // }
    // }
    // }
    // return 4 * count - 2 * borders;
    // }

}

/**
 * 广度优先，
 * 从第一个为1的网格开始搜索，先默认边长为4，接着搜索其周边的四个方向：
 * 如果为1且没有访问过，加入队列，然后减去重叠的1个边；
 * 如果为1已经访问过，不再加入队列，然后减去重叠的1个边；
 * 直到队列为空，说明没有相邻的陆地，返回总周长。题目说只有一个岛屿，所以可此时可以直接返回。
 * 
 */
// @lc code=end
