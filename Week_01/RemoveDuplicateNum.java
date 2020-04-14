import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1)
 * 额外空间的条件下完成。
 *
 * 示例 1: 给定数组 nums = [1,1,2], 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2: 给定 nums = [0,0,1,1,1,2,2,3,3,4], 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * date:2020-4-14 21:45
 */
public class RemoveDuplicateNum {

  //解法1(Java程序员的第一思路)可针对无序数组
  private static Integer[] removeRepeate(int[] mnums) {
    //初始化一个set
    LinkedHashSet<Integer> set = new LinkedHashSet<>();
    for (int i = 0; i < mnums.length; i++) {
      set.add(mnums[i]);
    }
    return Arrays.copyOfRange(set.toArray(), 0, set.size(), Integer[].class);
  }


  //解法2 双指针法
  private static int removeDuplicates(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
      if (nums[j] != nums[i]) {
        i++;
        nums[i] = nums[j];
      }
    }
    //这里返回的实际上是原来数组未重复元素的下标,后面如果我们想要获得去重的数组直接拿这个下标去原数组取就可以了(个人理解)为什么是i+1？因为快指针是从1开始的
    return i + 1;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 2, 3, 4, 4};
    int noneDupNums = removeDuplicates(nums);
    for (int a = 0; a < noneDupNums; a++) {
      System.out.print(nums[a]);
    }
  }
}