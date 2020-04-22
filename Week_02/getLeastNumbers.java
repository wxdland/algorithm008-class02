package 第二周;

import java.util.PriorityQueue;

/*
输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
输入：arr = [3,2,1], k = 2
输出：[1,2] 或者 [2,1]
date:2020-4-22 23:44
 */
public class getLeastNumbers {

  private static int[] getLeast(int[] nums, int k) {
    PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
    for (int i = 0; i < nums.length; i++) {
      heap.add(nums[i]);
    }
    int[] res = new int[k];
    for (int j = 0; j < res.length; j++) {
      res[j] = heap.poll();
    }
    return res;
  }

  public static void main(String[] args) {
    int[] arr = getLeast(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 3);
    for (int j = 0; j < arr.length; j++) {
      System.out.print(arr[j]);
    }
  }
}
