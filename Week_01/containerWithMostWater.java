public class containerWithMostWater {

  private static int getMaxContain(int[] nums) {
    int max = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        int area = (j - i) * Math.min(nums[i], nums[j]);
        max = Math.max(max, area);
      }
    }
    return max;
  }


  public static void main(String[] args) {
    int[] tt = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    int max = getMaxContain(tt);
    System.out.print(max);
  }

}
