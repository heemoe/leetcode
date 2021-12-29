import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=567 lang=java
 *
 * [567] 字符串的排列
 */

// @lc code=start
class Solution {
    public static boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) {
            return false;
        }
        HashMap<Character, Integer> mapS1 = new HashMap<>();
        HashMap<Character, Integer> mapS2 = new HashMap<>();

        for (char ch : s1.toCharArray()) {
            /**
             * 把s1放入map集合mapS1中, s1是被比较的字符串(短的)
             * */
            mapS1.put(ch, mapS1.getOrDefault(ch, 0) + 1);
            /**
             * hash.put(c,hash.getOrDefault(c,0)+1); //若没有就是0，若有就是原有值增一。
             */
        }
        int window = 0;
        for (int i = 0; i < len1; i++, window++) {
            /**
             * 设置滑动窗口，window长度等于滑动窗口长度
             */
            char ch = s2.charAt(i);
            mapS2.put(ch, mapS2.getOrDefault(ch, 0) + 1);
        }
        while (window < len2) {
            /**
             * HashMap自带的方法，可以直接比较(自动比较key-value是否相等)
             * */
            if (mapS1.equals(mapS2)) {
                return true;
            }
            /**
             * 下面开始进行窗口移动
             * before: 窗口移动前的左端字符
             * after: 窗口移动后新加入的字符元素
             * */
            char before = s2.charAt(window - len1);
            char after = s2.charAt(window);
            /***
             * 右移一位，before删除，键不动，将 (value -1) 即可  ----- 移除
             */
            mapS2.put(before, mapS2.get(before) - 1);
            if (mapS2.get(before) == 0) {
                mapS2.remove(before);
            }
            /***
             * 将窗口外的邻位移动到窗口里，mapS2.getOrDefault(after, 0) + 1  ----- 添加
             */
            mapS2.put(after, mapS2.getOrDefault(after, 0) + 1);
            window++;
        }
        return mapS2.equals(mapS1);
    }

}
// @lc code=end

