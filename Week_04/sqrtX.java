package 第四周;

public class sqrtX {
  public static int Sqrt(int x) {
    if(x==0||x==1){
      return x;
    }
    long left=0;
    long right=x;
    long mid=1;
    while(left<=right){
      mid=left+(right-left)/2;
      if(mid*mid>x){
        right=mid-1;
      }else{
        left=mid+1;
      }
    }
    return Integer.parseInt(String.valueOf(right));
  }

  public static void main(String[] args) {
    System.out.println( NewtonIteration2(10));

  }
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
   if(x<0){
     return Double.NaN;
   }
   double err=1e-15;
   double t=x;
   while (Math.abs(t-x/t)>err*t){
    t=(x/t+t)/2.0;
   }
    return t;
  }

  public static double NewtonIteration2(double m){
    if(m<0){
      return Double.NaN;
    }
    double x1=m/2;
    //迭代一千次
    for (int i=0;i<1000;i++){
      double x2=(x1+m/x1)/2;
      if(x1-x2<=0.0001){
        return x2;
      }
      x1=x2;
    }
    return 0;
  }


}
