package 第八周;

import java.util.Arrays;

public class mergeInterval {
/*
 给出一个区间的集合，请合并所有重叠的区间。
 示例 1:
 输入: [[1,3],[2,6],[8,10],[15,18]]
 输出: [[1,6],[8,10],[15,18]]
 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

 示例 2:
 输入: [[1,4],[4,5]]
 输出: [[1,5]]
 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
*/
  public int[][] merge(int[][] intervals) {
   if(intervals.length==0){
     return intervals;
   }
   //先排序
    Arrays.sort(intervals,(a,b)->a[0]-b[0]);
    int pointer=0;
    for (int i = 0; i <intervals.length ; i++) {

      int[]intervel=intervals[i];
      int[]point=intervals[pointer];

      //如果前面一个区间的起点大于第二个区间的终点，那这两个区间没有重叠，复制当前interval到下一个pointer
      if(intervel[0]>point[1]){
        intervals[++pointer]=intervel;
      }else{
        intervals[pointer][1]=Math.max(intervel[1],point[1]);
      }
    }
    return Arrays.copyOfRange(intervals,0,pointer+1);
  }
}
