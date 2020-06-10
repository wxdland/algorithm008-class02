package 第八周;

/*
颠倒给定的 32 位无符号整数的二进制位。
示例 1：
输入: 00000010100101000001111010011100
输出: 00111001011110000010100101000000
解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
     因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
示例 2：

输入：11111111111111111111111111111101
输出：10111111111111111111111111111111
解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
     因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。
*/
public class reverseBits {
  /*
  取当前 n 的最后一位：n & 1
  将最后一位移动到对应位置，第一次为 31 位，第二次是 30 位，即：31、30、29... 1、0，写作代码 bit << 31;
  退出条件，二进制反转时，如果剩余位数全位 0，则可以不用再反转。
  >>> 表示无符号右移，也叫逻辑右移，即若该数为正，则高位补0，而若该数为负数，则右移后高位同样补0
  */
  public int reverseBits(int n){
    int ans=0;
    for (int bitSizes = 31;n!=0;n=n>>>1,bitSizes--) {
       ans+=(n&1)<<bitSizes;
    }
    return ans;
  }

  public static void main(String[] args) {
    reverseBits rev=new reverseBits();
    System.out.println(rev.reverseBits(43261596));
  }

}