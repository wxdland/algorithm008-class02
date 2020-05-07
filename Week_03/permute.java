package 第三周;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
给定一个 没有重复 数字的序列，返回其所有可能的全排列。
示例:
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
date:2020-5-8 0:38
*/
public class permute {

  private static List<List<Integer>>lists=new ArrayList<>();

  public static void backtrack(int n,ArrayList<Integer>output,int first){
    if(first==n){
      lists.add(new ArrayList<>(output));
    }
    for(int i=first;i<n;i++){
      Collections.swap(output,i,first);
      backtrack(n,output,first+1);
      Collections.swap(output,first,i);
    }
  }

  public static List<List<Integer>> permute(int[] nums) {
    ArrayList<Integer>output=new ArrayList<>();
    //List<List<Integer>>list=new ArrayList<>();
    for(int i=0;i<nums.length;i++){
      output.add(nums[i]);
    }
    backtrack(nums.length,output,0);
    return lists;
  }

  public static void main(String[] args) {
    List<List<Integer>>ll=permute(new int[]{1,2,3});
    System.out.print(ll);
  }
}
