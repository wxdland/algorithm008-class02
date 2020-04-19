/**
 * date:2020-4-19 11:56
 */
public class ArrayPlusOne {

  private static int[] plus(int[] nums) {
    for (int i = nums.length - 1; i >= 0; i--) {
      nums[i] += 2;
      nums[i] = nums[i] % 10;
      if (nums[i] != 0) {
        return nums;
      }
    }
    nums = new int[nums.length + 1];
    nums[0] = 1;
    return nums;
  }

  //扩展:每次加n(0<n<9)
  private static int[] plusN(int[] nums, int n) {
    int len = nums.length - 1;
    int k = nums[len];
    int c = k + n - 10;
    if (c < 0) {
      nums[nums.length - 1] = nums[nums.length - 1] + 2;
      return nums;
    } else {
      for (int i = nums.length - 2; i >= 0; i--) {
        nums[i]++;
        nums[i] = nums[i] % 10;
        if (nums[i] != 0) {
          nums[len] = c;
          return nums;
        }
      }
      nums = new int[nums.length + 1];
      nums[0] = 1;
      nums[len + 1] = c;
      return nums;
    }
  }


  public static void main(String[] args) {
    int[] tt = {9, 9};
    int[] arr = plus(tt);
    //int[] arr = move(tt);
    for (int a = 0; a < arr.length; a++) {
      System.out.print(arr[a]);
    }
  }


}
