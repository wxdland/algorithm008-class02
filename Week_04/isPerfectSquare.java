package 第四周;

public class isPerfectSquare {

  public static boolean isPerfectSquare(int num) {
    if (num < 2) {
      return true;
    }
    long x = num / 2;
    while (x * x > num) {
      x = (x + num / x) / 2;
    }
    return (x * x == num);
  }

  public static void main(String[] args) {
    System.out.println(isPerfectSquare(16));
  }
}
