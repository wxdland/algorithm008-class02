package 第三周;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
给定一个可包含重复数字的序列，返回所有不重复的全排列。
示例:
输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 date:2020-5-9 0:01
 */
public class permuteUnique {

  private static List<List<Integer>>list=new ArrayList<>();

  public static List<List<Integer>> permuteUnique(int[] nums) {
    Arrays.sort(nums);
    findUnique(nums,new boolean[nums.length],new LinkedList<>());
    return list;
  }
  public static void findUnique(int[] nums,boolean[]used, LinkedList<Integer>trace){
    if(trace.size()==nums.length){
      list.add(new ArrayList<>(trace));
      return;
    }
    for (int i=0;i<nums.length;i++){
      if(used[i]){
        continue;
      }
      if(i>0&&nums[i]==nums[i-1]&&used[i-1]){
        continue;
      }
      trace.add(nums[i]);
      used[i]=true;
      findUnique(nums,used,trace);
      trace.removeLast();
      used[i]=false;
    }

  }

  public static void main(String[] args) {
    List<List<Integer>>ll=permuteUnique(new int[]{1,1,3});
    System.out.print(ll);
  }
}
