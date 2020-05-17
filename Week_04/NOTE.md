本周主要学习贪心算法与二分查找算法

# 一、贪心算法
适用场景:问题能够分解成子问题来解决，如：求图中的最小生成树、求哈夫曼编码等,子问题的最优解能递推到最终问题的最优解。这种子问题最优解称为最优子结构。

贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，
不能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前
进行选择，有回退功能。

------
**贪心算法解决问题实例**
```java
买卖股票问题:
public static int maxProfit(int[] prices) {
    int profit = 0;
    for (int i = 0; i < prices.length - 1; i++) {
      if (prices[i + 1] > prices[i]) {
        profit += prices[i + 1] - prices[i];
      }
    }
    return profit;
  }
```

# 二、二分查找算法
适用场景:
1. 目标函数单调性（单调递增或者递减）
2. 存在上下界（bounded）
3. 能够通过索引访问（index accessible)

**二分查找算法代码模板**
```java
模板：
int left=0,right=nums.length-1,mid;
while(left<=right){
mid=(left+right)/2;
if(nums[mid]==target);
return ...
else if(nums[mid]<target){
left=mid+1;
else if(nums[mid]>target){
right=mid-1;
else ...
```
------
二分查找典型实例:
```java
牛顿迭代法求一个数的平方根
 /*
    迭代式:Xn+1=Xn-f(xn)/f`(xn);
    求平方根的方程为Xn^2-m=0;
    代入上式得：
    Xn+1=Xn-(Xn^2-m)/2Xn
    ~~~
    Xn+1=Xn-(Xn-m/Xn)/2
    ~~
    Xn+1=(Xn+m/Xn)/2;
   */
  public static double NewtonIteration1(double x) {
    if (x < 0) {
      return Double.NaN;
    }
    double err = 1e-15;
    double t = x;
    while (Math.abs(t - x / t) > err * t) {
      t = (x / t + t) / 2.0;
    }
    return t;
  }
```




