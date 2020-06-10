package 第八周;

public class nQueen {

  private int size;
  private int count;


  private void solve(int row, int ld, int rd) {

    if (row == size) {
      count++;
      return;
    }
    int k=~(row | ld | rd);
    int pos = size & (~(row | ld | rd));
    while (pos != 0) {
      int p = pos & (-pos);
      pos -= p;
      solve(row | p, (ld | p) << 1, (rd | p) >> 1);
    }
  }

  public int totalNqueen(int n) {
    count = 0;
    size = (1 << n) - 1;
    solve(0, 0, 0);
    return count;
  }

  public static void main(String[] args) {
    nQueen queen = new nQueen();
    System.out.println(queen.totalNqueen(8));
  }

}
