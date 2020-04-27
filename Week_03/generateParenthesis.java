package 第三周;

import java.util.ArrayList;
import java.util.List;
/*
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
示例：
输入：n = 3
输出：[
       "((()))",
       "(()())",
       "(())()",
       "()(())",
       "()()()"
     ]
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/generate-parentheses
date:2020/4/27 23:25
*/
public class generateParenthesis {
  private List<String>list;
  public List<String> generateParenthesis(int n) {
    list=new ArrayList<>();
    _generate(0,0,3,"");
     return null;
  }

  private void _generate(int left,int right,int max,String s) {
    if(left==max&&right==max){
      list.add(s);
      return;
    }
    if (left<max){
      _generate(left+1,right,max,s+"(");
    }
    if (left>right){
      _generate(left,right+1,max,s+")");
    }
  }


  public static void main(String[] args) {
    generateParenthesis ss=new generateParenthesis();
    ss.generateParenthesis(3);
    System.out.print(ss.list.toString());
  }
}
