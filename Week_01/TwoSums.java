import java.util.HashMap;
import java.util.Map;

/**
 * date:2020-4-19 12:30
 */
public class TwoSums {

  //解法1：暴力求解
  private static int[] findSum1(int[] nums, int n) {
    int[] arr = new int[2];
    for (int i = 0; i < nums.length; i++) {
      for (int j = i; j < nums.length - 1; j++) {
        if (nums[i] + nums[j] == n) {
          arr[0] = nums[i];
          arr[1] = nums[j];
          return arr;
        }
      }
    }
    return arr;
  }

  //解法2：一遍hash法
  private static int[] findSum2(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int ele = target - nums[i];
      if (map.containsKey(ele)) {
        return new int[]{ele, nums[i]};
      }
      map.put(nums[i], ele);
    }
    return null;
  }

  public static void main(String[] args) {
    int[] tt = {1, 2, 7, 4, 10};
    int[] arr = findSum2(tt, 9);
    //int[] arr = move(tt);
    for (int a = 0; a < arr.length; a++) {
      System.out.print(arr[a]);
    }
  }

}
