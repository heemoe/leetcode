import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=695 lang=java
 *
 * [695] 岛屿的最大面积
 */

// @lc code=start
class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        return 0;
    }

    private int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public void bfs() {
        Queue<int[]> q = new LinkedList<>();

        while (!q.isEmpty()) {

            q.poll();

        }

    }
}
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
// @lc code=end
