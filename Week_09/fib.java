package 第九周;

public class fib {
   public static int count(int N){
     int[]dp=new int[N+1];
     dp[1]=dp[2]=1;
     for (int i = 3; i <=N ; i++) {
       dp[i]=dp[i-1]+dp[i-2];
     }
     return dp[N];
   }

  public static void main(String[] args) {
     int cc=count(5);
    System.out.println(cc);
  }
}
