package 第八周;

public class isPowerOfTwo {
  //解法1:
  //当一个数字为2的幂次方时，它的二进制8位中只有一个1,而其他则有多个1，-x表示的二进制数其他位取反，只保留最后面的1（如果1后面为0，后面的0不取反）
  //这样当x&(-x)时如果是2的幂次方则与原数字相等，反之不相等
  public boolean isPowerOfTwo1(int n) {
    if(n==0){
      return false;
    }
    long lon=(long)n;
    return (lon&(-lon))==lon;
  }

  //解法2:
  //x-1会将一个数的二进制最后一个1改成0，然后后面的位取反
  //如果一个数是2的幂次方那么x&(x-1)的结果为全是0的二进制数即x&(x-1)=0;
  public boolean isPowerOfTwo2(int n) {
    if(n==0){
      return false;
    }
    long x=(long)n;
    return (x&(x-1))==0;
  }
}
