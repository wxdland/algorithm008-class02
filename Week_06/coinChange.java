package 第五周;

/*
给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
示例 1:
输入: coins = [1, 2, 5], amount = 11
输出: 3
解释: 11 = 5 + 5 + 1
*/
public class coinChange {
  public int coinChange(int[] coins, int amount) {
    return coinChange(0, coins, amount);
  }

  private int coinChange(int idxCoin, int[] coins, int amount) {
    if (amount == 0)
      return 0;
    if (idxCoin < coins.length && amount > 0) {
      int maxVal = amount / coins[idxCoin];
      int minCost = Integer.MAX_VALUE;
      for (int x = 0; x <= maxVal; x++) {
        if (amount >= x * coins[idxCoin]) {
          int res = coinChange(idxCoin + 1, coins, amount - x * coins[idxCoin]);
          if (res != -1)
            minCost = Math.min(minCost, res + x);
        }
      }
      return (minCost == Integer.MAX_VALUE)? -1: minCost;
    }
    return -1;
  }

}
