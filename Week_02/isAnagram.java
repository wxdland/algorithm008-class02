package 第二周;

import java.util.HashMap;
import java.util.Map;

/**
 * date:2020-4-20 22:06
 */
public class isAnagram {
  //错误的解法，由于hash计数器用的比较少，没想到
  private static boolean unCorrectAnagaram(String s, String t) {
    if (s == null || s == "" || t == null || s == "") {
      return false;
    }
    char[] ca = s.toCharArray();
    char[] ct = t.toCharArray();
    if (ca.length != ct.length) {
      return false;
    }
    Map<Character, Integer> cmap = new HashMap();
    for (char c : ca) {
      if (cmap.containsKey(c)) {
        cmap.put(c, cmap.get(c) + 1);
      }
      cmap.put(c, 1);
    }
    for (char a : ct) {
      if (cmap.containsKey(a)) {
        cmap.put(a, cmap.get(a) - 1);
      }
      if (cmap.get(a) != null && cmap.get(a) == 0) {
        cmap.remove(a);
      }
    }
    return cmap.isEmpty();
  }
  public static  boolean correctAnagrams(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int[] counter = new int[26];
    for (int i = 0; i < s.length(); i++) {
      counter[s.charAt(i) - 'a']++;
      counter[t.charAt(i) - 'a']--;
    }
    for (int count : counter) {
      if (count != 0) {
        return false;
      }
    }
    return true;
  }


  public static void main(String[] args) {
    boolean is = correctAnagrams("aacc","ccac");

    System.out.print(is);
  }

}
