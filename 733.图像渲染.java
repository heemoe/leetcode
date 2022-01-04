
/*
 * @lc app=leetcode.cn id=733 lang=java
 *
 * [733] 图像渲染
 */

// @lc code=start
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];

        if (color == newColor)
            return image;

        dfs(sr, sc, image, color, newColor);

        return image;
    }

    public void dfs(int r, int c, int[][] image, int color, int newColor) {
        // image[r][c] != color 当前格子渲染过了
        // 边界判断
        if (r < 0 || c < 0
                || r >= image.length || c >= image[0].length
                || image[r][c] != color)
            return;

        image[r][c] = newColor;

        dfs(r + 1, c, image, color, newColor);
        dfs(r - 1, c, image, color, newColor);
        dfs(r, c + 1, image, color, newColor);
        dfs(r, c - 1, image, color, newColor);
    }
}
// @lc code=end
