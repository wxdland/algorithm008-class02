package 第四周;

/*
编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。
示例 1:
输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
输出: true
*/
public class search2dMatrix {

  public static boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    if (m == 0) {
      return false;
    }
    int n = matrix[0].length;

    int left = 0, right = m * n - 1;
    int midElementIdx, midElement;

    while (left <= right) {
      midElementIdx = (left + right) / 2;
      midElement = matrix[midElementIdx / n][midElementIdx % n];
      if (target == midElement) {
        return true;
      }
      if (target < midElement) {
        right = midElementIdx - 1;
      } else {
        left = midElementIdx + 1;
      }
    }
    return false;
  }


  public static void main(String[] args) {
    int[][] arr = new int[][]{
        {1, 3, 5, 7},
        {10, 11, 16, 20},
        {23, 30, 34, 50}
    };
    System.out.println(searchMatrix(arr, 35));
  }
}
