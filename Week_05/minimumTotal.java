package 第五周;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class minimumTotal {

  public static int minimumTotal(List<List<Integer>> triangle) {
    int row = triangle.size();
    int[] dp = new int[row + 1];
    for (int level = row - 1; level >= 0; level--) {
      for (int i = 0; i < level + 1; i++) {
        dp[i] = Math.min(dp[i], dp[i + 1]) + triangle.get(level).get(i);
      }
    }
    return dp[0];
  }

  public static void main(String[] args) {
    List<List<Integer>>result=new ArrayList<>();
    result.add(Arrays.asList(2));
    result.add(Arrays.asList(3,4));
    result.add(Arrays.asList(6,5,7));
    result.add(Arrays.asList(4,1,8,3));
    System.out.println(minimumTotal(result));
  }
}
