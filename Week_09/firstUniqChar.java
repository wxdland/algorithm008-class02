package 第九周;

import java.util.HashMap;
import java.util.Map;

/*
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

示例：
s = "leetcode"
返回 0
s = "loveleetcode"
返回 2

*/
public class firstUniqChar {
  //解法1
  public int firstUniqChar1(String s) {
    if(s==null||s==""){
      return -1;
    }
    HashMap<Character,Integer>map=new HashMap<>();
    for (int i=0;i<s.length();i++){
      char c=s.charAt(i);
      map.put(c,map.getOrDefault(c,0)+1);
    }
    for (int i=0;i<s.length();i++){
      if(map.get(s.charAt(i))==1){
        return i;
      }
    }
    return -1;
  }

  //解法2
  public int firstUniqChar2(String s) {
    if(s==null||s==""){
      return -1;
    }
    int len=s.length();
    int[]count=new int[26];
    for (int i = 0; i <len ; i++) {
      count[s.charAt(i)-'a']++;
    }
    for (int i = 0; i <len ; i++) {
      if(count[s.charAt(i)-'a']==1){
        return i;
      }
    }
    return -1;
  }
}
