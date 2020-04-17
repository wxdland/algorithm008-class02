public class moveZero {

  private static int[] move(int[] nums) {
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[j] = nums[i];
        if (i != j) {
          nums[i] = 0;
        }
        j++;
      }
    }
    return nums;
  }


  public static void main(String[] args) {
    int[] tt = {1, 2, 3, 0, 0, 4};
    int[] arr = move(tt);
    for (int a = 0; a < arr.length; a++) {
      System.out.print(arr[a]);
    }
  }

}
