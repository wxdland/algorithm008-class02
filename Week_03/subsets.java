package 第三周;

import java.util.ArrayList;
import java.util.List;
/*
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
说明：解集不能包含重复的子集。
示例:
输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
date：2020-4-28 23.55
*/
public class subsets {
  public static List<List<Integer>>sumSubsets(int[]nums){

    List<List<Integer>>sums=new ArrayList<>();
    sums.add(new ArrayList<Integer>());

    for (int num:nums){
      List<List<Integer>>subouts=new ArrayList<>();
      for(List<Integer>curr:sums){
        subouts.add(new ArrayList<Integer>(curr){{add(num);}});
      }
       for (List<Integer>sum:subouts){
         sums.add(sum);
       }
    }
    return sums;
  }

  public static void main(String[] args) {
    List<List<Integer>>list=sumSubsets(new int[]{1,2,3});
    System.out.print(list.toString());
  }
}
