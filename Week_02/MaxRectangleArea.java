package 第二周;

import java.util.Stack;

/*
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
求在该柱状图中，能够勾勒出来的矩形的最大面积。
输入: [2,1,5,6,2,3]
输出: 10
date:2020-4-24 23:44
 */
public class MaxRectangleArea {

  //解法1：暴力求解
  private static int maxArea(int[] heights) {
    int maxArea = 0;
    for (int i = 0; i < heights.length; i++) {
      for (int j = i; j < heights.length; j++) {
        int minh = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
          minh = Math.min(heights[k], minh);
        }
        maxArea = Math.max(maxArea, minh * (j - i + 1));
      }
    }
    return maxArea;
  }

  private static int maxAreaWithSatck(int[] heights) {
    Stack<Integer> stack = new Stack<>();
    stack.push(-1);
    int maxarea = 0;
    for (int i = 0; i < heights.length; i++) {
      while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
        maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
      }
      stack.push(i);
    }
    while (stack.peek() != -1) {
      maxarea = Math.max(maxarea, heights[stack.peek()] * (heights.length - stack.pop() - 1));
    }
    return maxarea;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{2, 1, 5, 6, 2, 3};
    /*for (int j = 0; j < arr.length; j++) {
      System.out.print(arr[j]);
    }*/
    int ares = maxAreaWithSatck(arr);
    System.out.print(ares);
  }

}
