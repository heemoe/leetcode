import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    // 把这个区域变成 0
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    // 方向数组 dirs
    private int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    // 把 grid[i][j] 相连的所有岛屿淹掉（相连的 1 变成 0）
    private void bfs(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        // 把初始位置放入
        q.offer(new int[] { i, j });
        grid[i][j] = '0';

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int k = 0; k < sz; k++) {
                int[] cur = q.poll();
                // 横纵坐标

                // 将上下左右的四个位置（子节点）放入队列中
                // 注意索引不能越界
                for (int[] d : dirs) {
                    int newX = cur[0] + d[0];
                    int newY = cur[1] + d[1];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n
                            && grid[newX][newY] == '1') {
                        q.offer(new int[] { newX, newY });
                        grid[newX][newY] = '0';
                    }
                }
            }
        }
    }
}

// @lc code=end

/**
 * 
 * BFS 算法
 * 
 * 把二维数组的上下左右可以看作类似于二叉树的子节点，可以在二维数组上使用 BFS 算法（或者说层序遍历）。
 * 首先，我们需要遍历这个二维数组
 * 其次，在找到一个岛屿后，从这个点开始使用 BFS 算法，把和这个岛屿相连的所有的岛屿都变成水（也就是把和这个 1 相连的所有的 1 都变成 0）
 * 本题的 BFS 算法的理解
 * 把一个格子的上下左右四个位置理解为四个子节点，二叉树的层级遍历框架是把一个节点的非空子节点放入队列中，同理，我们把这个节点的非空子节点（值为 1
 * 的岛屿）也放入队列中。
 * 在判断子节点是否能加入队列中，除了要求该子节点的值为1之外还要注意索引是否越界。（可以使用方向数组）
 * 
 * 
 */