package 第二周;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class groupAnagrams {

  //解法1 时间复杂度 N*K*O(LogK)
  public static List<List<String>> groupAnagrams(String[] strs) {
    if (strs.length == 0) {
      return null;
    }
    Map<String, List<String>> map = new HashMap<>();
    for (int i = 0; i < strs.length; i++) {
      String s = strs[i];
      char[] cha = s.toCharArray();
      Arrays.sort(cha);
      String st = String.valueOf(cha);
      if (!map.containsKey(st)) {
        map.put(st, new ArrayList<>());
      }
      map.get(st).add(s);
    }
    return new ArrayList(map.values());
  }
  //解法2：时间复杂度 O(N*K*26)
  public static List<List<String>> anthorGroupAnagrams(String[] strs) {
    if (strs.length == 0) {
      return null;
    }
    Map<String, List<String>> map = new HashMap<>();
    int[] counter = new int[26];
    for (String str : strs) {
      Arrays.fill(counter, 0);
      char[] cha = str.toCharArray();
      for (char c : cha) {
        counter[c - 'a']++;
      }
      StringBuilder sb = new StringBuilder("");
      for (int i = 0; i < 26; i++) {
        sb.append("*");
        sb.append(counter[i]);
      }
      String key = sb.toString();
      if (!map.containsKey(key)) {
        map.put(key, new ArrayList<>());
      }
      map.get(key).add(str);
    }
    return new ArrayList(map.values());
  }

  public static void main(String[] args) {
    String[] stt = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> list = anthorGroupAnagrams(stt);
    for (int j = 0; j < list.size(); j++) {
      System.out.print(list.get(j).toString());
    }
  }

}
