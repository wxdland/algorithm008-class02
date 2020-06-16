package 第九周;

/*
给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:

输入: [10,9,2,5,3,7,101,18]
输出: 4
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
说明:

可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
你算法的时间复杂度应该为 O(n2) 。
date:2020-6-16 23:44
*/
public class lengthOfLIS {

  //解法1:动态规划时间复杂度O(n^2)
  public static int lengthOfLIS(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int[] dp = new int[nums.length];

    int maxans = 0;
    for (int i = 1; i < nums.length; i++) {
      int maxval = 0;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          maxval = Math.max(maxval, dp[j]);
        }
      }
      dp[i] = maxval + 1;
      maxans = Math.max(maxans, dp[i]);
    }
    return maxans;
  }


  /*
  解法2:贪心+二分法
  最后整个算法流程为：
    设当前已求出的最长上升子序列的长度为 \textit{len}len（初始时为 11），从前往后遍历数组 \textit{nums}nums，在遍历到 \textit{nums}[i]nums[i] 时：

    如果 \textit{nums}[i] > d[\textit{len}]nums[i]>d[len] ，则直接加入到 dd 数组末尾，并更新 \textit{len} = \textit{len} + 1len=len+1；

    否则，在 dd 数组中二分查找，找到第一个比 \textit{nums}[i]nums[i] 小的数 d[k]d[k] ，并更新 d[k + 1] = \textit{nums}[i]d[k+1]=nums[i]。

    以输入序列 [0, 8, 4, 12, 2][0,8,4,12,2] 为例：

    第一步插入 00，d = [0]d=[0]；

    第二步插入 88，d = [0, 8]d=[0,8]；

    第三步插入 44，d = [0, 4]d=[0,4]；

    第四步插入 1212，d = [0, 4, 12]d=[0,4,12]；

    第五步插入 22，d = [0, 2, 12]d=[0,2,12]。

    最终得到最大递增子序列长度为 33。
 */
  public static int lengthOfLIS2(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int len = 1, length = nums.length;
    int[] d = new int[length + 1];
    d[len] = nums[0];
    for (int i = 1; i < length; i++) {
      if (nums[i] > d[len]) {
        d[++len] = nums[i];
      } else {
        int l = 1, pos = 0, r = len;
        while (l <= r) {
          int mid = (r + l) >> 1;
          if (d[mid] < nums[i]) {
            pos = mid;
            l = mid + 1;
          } else {
            r = mid - 1;
          }
          d[pos + 1] = nums[i];
        }
      }
    }
    return len;
  }

  public static void main(String[] args) {
    int[] ni = {10, 9, 2, 5, 3, 7, 101, 18};
    System.out.println(lengthOfLIS2(ni));
  }

}
