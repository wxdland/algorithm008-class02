package 第三周;
/*
实现 pow(x, n) ，即计算 x 的 n 次幂函数。
示例 1:
输入: 2.00000, 10
输出: 1024.00000
date：2020-4-28 23.55
*/
public class powxn {

  private static double myPow(double x, long n) {
    if (n==0){
      return 1.0;
    }
    double half=myPow(x,n/2);
      if(n%2==1){
        return half*half*x;
      }else{
        return half*half;
      }
  }

  public static double fastPow(double x, long n) {
    long N=n;
    if (N<0){
      N=-N;
      x=1/x;
    }
    return myPow(x,N);
  }


  public static void main(String[] args) {
    double sum=fastPow(2,-3);
    System.out.print(sum);
  }

}
