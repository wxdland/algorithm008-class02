/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3 输出: [5,6,7,1,2,3,4] 解释: 向右旋转 1 步: [7,1,2,3,4,5,6] 向右旋转 2 步:
 * [6,7,1,2,3,4,5] 向右旋转 3 步: [5,6,7,1,2,3,4] 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2 输出: [3,99,-1,-100] 解释: 向右旋转 1 步: [99,-1,-100,3] 向右旋转 2 步:
 * [3,99,-1,-100] 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/rotate-array 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * date:2020-4-14 21:45
 */
public class RotateArray {

  //解法1 暴力求解(有点忘了，像之前的冒泡排序，交换指针，时间复杂度为O(k*n))
  private static int[] rotate(int[] nums, int k) {
    int prev, temp;
    for (int i = 0; i < k; i++) {
      prev = nums[nums.length - 1];
      for (int j = 0; j < nums.length; j++) {
        temp = nums[j];
        nums[j] = prev;
        prev = temp;
      }
    }
    return nums;
  }

  //解法2:
  private static void rotates(int[] nums, int k) {
    int[] arr = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
      arr[(i + k) % nums.length] = nums[i];
    }

    for (int j = 0; j < nums.length; j++) {
      nums[j] = arr[j];
    }
  }

  public static void main(String[] args) {
    int[] tt = {1, 2, 3, 4, 5, 6, 7};
    /*int[] num=rotate(tt,3);
    for(int a=0;a<num.length;a++){
      System.out.print(num[a]);
    }*/
    rotates(tt, 3);
    for (int a = 0; a < tt.length; a++) {
      System.out.print(tt[a]);
    }
  }
}
