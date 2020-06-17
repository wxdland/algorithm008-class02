package 第九周;

/*
给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
你可以对一个单词进行如下三种操作：
插入一个字符
删除一个字符
替换一个字符

示例 1：

输入：word1 = "horse", word2 = "ros"
输出：3
解释：
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')

date:2020-06-18 0:49
*/
public class minDistance {

  public static int minDistance(String word1, String word2) {
    int m = word1.length(), n = word2.length();
    if (m * n == 0) {
      return m + n;
    }
    int[][] dp = new int[m + 1][n + 1];

    for (int i = 0; i < m+1; i++) {
      dp[i][0] = i;
    }
    for (int j = 0; j < n+1; j++) {
      dp[0][j] = j;
    }
    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        int left = dp[i - 1][j] + 1;
        int down = dp[i][j - 1] + 1;
        int left_down = dp[i - 1][j - 1];
        if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
          left_down += 1;
        }
        dp[i][j] = Math.min(left, Math.min(down, left_down));
      }
    }
    return dp[m][n];
  }


  public static void main(String[] args) {
    System.out.println(minDistance("pneumonoultramicroscopicsilicovolcanoconiosis",
        "ultramicroscopically"));
  }

}
