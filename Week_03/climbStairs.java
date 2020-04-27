package 第三周;
/*
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
注意：给定 n 是一个正整数。
示例 1：
输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/climbing-stairs
date:2020/4/27 23:25
*/
public class climbStairs {

    public static int climbStairs(int n) {
      if (n<=2){
        return 2;
      }
      int f3=3,f1=1,f2=2;
      for (int i=3;i<n+1;i++){
        f3=f1+f2;
        f1=f2;
        f2=f3;
      }
      return f3;
    }
  public static void main(String[] args) {
    int k=climbStairs(4);
    System.out.print(k);
  }
}
