package 第九周;

/*
给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
若这两个字符串没有公共子序列，则返回 0。

示例 1:

输入：text1 = "abcde", text2 = "ace"
输出：3
解释：最长公共子序列是 "ace"，它的长度为 3。
date:2020-6-18 0:48
*/
public class longestCommonSubsequence {


  public static int longestCommonSubsequence(String text1, String text2) {
    int len1 = text1.length(), len2 = text2.length();

    if (text1.length() == 0 || text2.length() == 0) {
      return 0;
    }
    char[] cha1 = text1.toCharArray();
    char[] cha2 = text2.toCharArray();
    int[][] dp = new int[len1+1][len2+1];
    for (int i = 1; i < len1+1; i++) {
      for (int j = 1; j < len2+1; j++) {
        if (cha1[i-1] == cha2[j-1]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[len1][len2];
  }

  public static void main(String[] args) {
    System.out.println(longestCommonSubsequence("abcde", "ace"));
  }

}
