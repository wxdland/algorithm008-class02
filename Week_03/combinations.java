package 第三周;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
示例:
输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
date: 2020-5-7 0:28
 */
public class combinations {

  private static List<List<Integer>>list=new ArrayList<>();

  public static List<List<Integer>> combine(int n, int k) {
     if(n<=0||k<=0||n<k){
       return list;
     }
    findCombinations(n,k,1,new Stack<Integer>());
    return list;
  }

  private static void findCombinations(int n,int k,int index, Stack<Integer>s){
    if(s.size()==k){
      list.add(new ArrayList<>(s));
      return;
    }
    for (int i=index;i<n-(k-s.size())+1;i++){
      s.push(i);
      findCombinations(n,k,i+1,s);
      s.pop();
    }
  }

  public static void main(String[] args) {
    List<List<Integer>>ll=combine(6,2);
    System.out.print(ll);
  }
}
