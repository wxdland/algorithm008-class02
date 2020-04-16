public class mergeTwoArray {

  private static int[] merge(int[] nums1, int m, int[] nums2, int n) {
    int p1 = m - 1;
    int p2 = n - 1;
    int p = n + m - 1;
    while ((p1 >= 0) && (p2 >= 0)) {
      nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
    }
    //System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    return nums1;
  }

  public static void main(String[] args) {
    int[] tt = {1, 2, 3, 4, 5, 6, 7};
    /*int[] num=rotate(tt,3);
    for(int a=0;a<num.length;a++){
      System.out.print(num[a]);
    }*/
    int[] arr = merge(new int[]{1, 2, 3,4,0,0,0}, 4, new int[]{2,4,5}, 3);
    for (int a = 0; a < arr.length; a++) {
      System.out.print(arr[a]);
    }
  }

}
