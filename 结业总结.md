第九周学习总结:
时间如流水，似白驹过隙，一转眼又迎来了人生的又一个"毕业季"
####
本周主要学习高级动态规范及字符串相关算法,也算是对之前学过的内容做一次小的提炼了

#### 总结点
```
从作业题目来看 常见的字符串操作问题包括如下几类:
1.公共子串
2.回文串
3.异或词问题
通过本周的学习，大体总结了这几类经典题的解题思路:1.滑动窗口算法,2.动态规划
```

#### 滑动窗口算法
```java
参考了leetcode上的总结:
 /* 滑动窗口算法框架 */
void slidingWindow(string s, string t) {
    HashMap<Character,Integer>need=new HashMap<>();
    HashMap<Character,Integer>window=new HashMap<>();
    for (int i = 0; i < s2.length(); i++) {
      need.put(s2.charAt(i),need.getOrDefault(s2.charAt(i),0)+1);
    }    
    int left = 0, right = 0;
    int valid = 0; 
    while (right < s.length()) {
        // c 是将移入窗口的字符
        char c = s.charAt(right);
        // 右移窗口
        right++;
        // 进行窗口内数据的一系列更新
        ...         
        // 判断左侧窗口是否要收缩
        while (window needs shrink) {
            // d 是将移出窗口的字符
            char d =s.charAt(left);
            // 左移窗口
            left++;
            // 进行窗口内数据的一系列更新
            ...
        }
    }
}
这是滑动窗口解题的java基础模板 算法复杂度为O(n),基本上可以解决公共子串及异或词问题
```
--
参考这个模板得出异或词的一个解法
```java
public static List<Integer> findAnagrams(String s, String p) {
    HashMap<Character, Integer> need = new HashMap<>();
    HashMap<Character, Integer> window = new HashMap<>();
    List<Integer> res = new ArrayList<>();

    for (int i = 0; i < p.length(); i++) {
      char c = p.charAt(i);
      need.put(c, need.getOrDefault(c, 0) + 1);
    }

    int left = 0, right = 0;
    int valid = 0;
    while (right < s.length()) {
      char r = s.charAt(right);
      right++;
      if (need.containsKey(r)) {
        window.put(r, window.getOrDefault(r, 0) + 1);
        if (window.get(r) == need.get(r)) {
          valid++;
        }
      }

      while (right - left >= need.size()) {
        if (valid == need.size()) {
          res.add(left);
        }
        char l = s.charAt(left);
        left++;
        if (need.containsKey(l)) {
          if (window.get(l) == need.get(l)) {
            valid--;
          }
          window.put(l, window.get(l) - 1);
        }
        //这样也可以
        //window.put(l, window.getOrDefault(l, 0) - 1);
      }
    }
    return res;
  }
 ```
 
#### 动态规划
```java
/* 常见的dp问题代码模板 */
public Object dp() {
    dp = [][]
    for (int i = 0; i <= m; i++) {
        for (int j = o; j <= n; j++) {
            dp[i][j] = _function(dp[_i][_j]...);
        }   
    }
    return dp[m][n];
}
```
--
参考这个模板总结下如下经典题的解法:
```java
1.斐波那契数列问题:
int fib(int N) {    
    int[]dp=new int[N+1];
    // base case
    dp[1] = dp[2] = 1;
    for (int i = 3; i <= N; i++)
        dp[i] = dp[i - 1] + dp[i - 2];
    return dp[N];
}
2.凑零钱问题:
 public static int coinChange(int[]coins,int amount){
    int[]dp=new int[amount+1];
    dp[0]=1;
    for (int x:coins) {
      for (int j =x; j <amount+1 ; j++) {
        dp[j]=dp[j]+dp[j-x];
      }
    }
    return dp[amount];
  }
3.最长公共子序列问题(应该还可以用滑动窗口算法，后面再补)
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
```


















