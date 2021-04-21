package leetcode.template.Stack;

import sun.awt.image.ImageWatched;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/19 15:00
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * [2,1,5,6,2,3]
 */
public class Q84_LargestRectangle {
    // 暴力1 :枚举所有的宽度
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int area = 0;
        for(int i = 0; i < n; i++) {
            int minHeight = heights[i];
            for(int j = i; j >= 0; j--) {
                minHeight = Math.min(minHeight, heights[j]);
                area = Math.max(area, minHeight * (i - j + 1));
            }
        }
        return area;
    }
    public int largestRectangleArea3(int[] heights) {
        int n = heights.length;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            int h = heights[i];
            // [1, 4]
            for(int w = 1; w <= i + 1; w++) {
                // [3, 0]
                h = Math.min(h, heights[i - w + 1]);
                ans = Math.max(ans, w * h);
            }
        }
        return ans;
    }
    // 暴力2：枚举所有的高度
    //
    // 遍历每个柱子，以当前柱子的高度作为矩形的高 h，
    // 从当前柱子向左右遍历，找到矩形的宽度 w。
    public int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        int area = 0;
        for(int i = 0; i < n; i++) {
            int l, r;
            l = r = i;
            int h = heights[i];
            //   2 1 2 3 2 1 2
            //   2 5 4 3 4 5 2
            while(l >= 0 && heights[l] >= h) {
                l--;
            }
            while(r < n && heights[r] >= h) {
                r++;
            }
            area = Math.max(area, h * (r - l - 1));
        }
        return area;
    }
    public int largestRectangleArea_b2(int[] heights) {
        int n = heights.length;
        int area = 0;
        for(int i = 0; i < n; i++) {
            int l, r;
            l = r = i;
            int h = heights[i];
            int w = 1;
            while (--l >= 0 && heights[l] >= h) {
                w++;
            }
            while (++r < n && heights[r] >= h) {
                w++;
            }
            area = Math.max(area, w * h);
        }
        return area;
    }
    // 上述写法中，我们需要再嵌套一层 while 循环来向左找到第一个比柱体 i 高度小的柱体，
    // 这个过程是 O(N) 的；
    // 那么我们可以 O(1) 的获取柱体 i 左边第一个比它小的柱体吗？
    // 因为对于栈中的柱体来说，栈中下一个柱体就是左边第一个高度小于自身的柱体。

    // 单调栈
    public int largestRectangleArea1(int[] hh) {
        int[] heights = new int[hh.length + 1];
        System.arraycopy(hh, 0, heights, 0, hh.length);
        int n = heights.length;
        int area = 0;
        Deque<Integer> s = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            // 我们遍历每个柱体，若当前的柱体高度大于等于栈顶柱体的高度，就直接将当前柱体入栈，
            //  1 2 3
            // 否则若当前的柱体高度小于栈顶柱体的高度，说明当前栈顶柱体找到了右边的第一个小于自身的柱体，
            // 1 2 3 2
            // 那么就可以将栈顶柱体出栈来计算以其为高的矩形的面积了。
            while(!s.isEmpty() && heights[i] < heights[s.peek()]) {
                int mid = s.pop();
                int h = heights[mid];
                if(!s.isEmpty()) {
                    int l = s.peek();
                    area = Math.max(area, (i - l - 1) * h);
                } else {
                    area = Math.max(area, i * h);
                }
            }
            s.push(i);
        }
        return area;
    }
    // [2,1,3,4,2,3]
    public int largestRectangleArea_s1(int[] heights) {
        // 这里为了代码简便，在柱体数组的头和尾加了两个高度为 0 的柱体。
        // 头加0不需要判断栈为空，尾加0可以使前面的都出栈。
        int[] tmp = new int[heights.length + 2];
        System.arraycopy(heights, 0, tmp, 1, heights.length);

        Deque<Integer> stack = new LinkedList<>();
        int area = 0;
        for (int i = 0; i < tmp.length; i++) {
            // 对栈中柱体来说，栈中的下一个柱体就是其「左边第一个小于自身的柱体」；
            // 若当前柱体 i 的高度小于栈顶柱体的高度，说明 i 是栈顶柱体的「右边第一个小于栈顶柱体的柱体」。
            // 因此以栈顶柱体为高的矩形的左右宽度边界就确定了，可以计算面积🌶️ ～
            while (!stack.isEmpty() && tmp[i] < tmp[stack.peek()]) {
                int h = tmp[stack.pop()];
                area = Math.max(area, (i - stack.peek() - 1) * h);
            }
            stack.push(i);
        }
        return area;
    }
    public int largestRectangleArea_s2(int[] arr) {
        Deque<Integer> s = new LinkedList<>();
        int ans = 0;
        int n = arr.length;
        int[] tmp = new int[n + 2];
        for(int i = 1; i <= n; i++) {
            tmp[i] = arr[i - 1];
        }
        for(int i = 0; i <= n + 1; i++) {
            // 1 2 3 2
            // 1 5 6 2
            // idx:
            // 1 2 3 4

            // 1 2
            //
            while(!s.isEmpty() && tmp[i] < tmp[s.peek()]) {
                int r = i;
                int h = tmp[s.pop()];
                // s.isEmpty() ?
                int l = s.peek();
                ans = Math.max(ans, (r - l - 1) * h);
            }
            s.push(i);
        }

        return ans;
    }
}
