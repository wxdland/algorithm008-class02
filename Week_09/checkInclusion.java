package 第九周;

import java.util.HashMap;

/*
给定两个字符串s1,s2写一个函数判断字符串s1是否包含s2的排列
*/
public class checkInclusion {
  public static boolean isContain(String s1,String s2){
    HashMap<Character,Integer>need=new HashMap<>();
    HashMap<Character,Integer>window=new HashMap<>();

    int left=0,right=0;
    for (int i = 0; i < s2.length(); i++) {
      need.put(s2.charAt(i),need.getOrDefault(s2.charAt(i),0)+1);
    }

    int valid=0;
    while (right<s1.length()){
      char r=s1.charAt(right);
      right++;
      if(need.containsKey(r)){
        window.put(r,window.getOrDefault(r,0)+1);
        if(window.get(r)==need.get(r)){
          valid++;
        }
      }

      while (right-left>=s2.length()){
        if(valid==need.size()){
          return true;
        }
        char l=s1.charAt(left);
        left++;
        if(need.containsKey(l)){
          if(window.get(l)==need.get(l)){
            valid--;
          }
          window.put(l,window.get(l)-1);
        }
      }
    }
    return false;
  }


  public static void main(String[] args) {
    System.out.println(isContain("eadcvvaa","av"));
  }
}
