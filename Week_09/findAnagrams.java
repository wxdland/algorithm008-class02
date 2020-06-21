package 第九周;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

说明：

字母异位词指字母相同，但排列不同的字符串。
不考虑答案输出的顺序。
示例 1:
输入:
s: "cbaebabacd" p: "abc"
输出:
[0, 6]

解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。

示例 2:
输入:
s: "abab" p: "ab"

输出:
[0, 1, 2]
解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。

*/
public class findAnagrams {

  public static List<Integer> findAnagrams(String s, String p) {
    HashMap<Character, Integer> need = new HashMap<>();
    HashMap<Character, Integer> window = new HashMap<>();
    List<Integer> res = new ArrayList<>();

    for (int i = 0; i < p.length(); i++) {
      char c = p.charAt(i);
      need.put(c, need.getOrDefault(c, 0) + 1);
    }

    int left = 0, right = 0;
    int valid = 0;
    while (right < s.length()) {
      char r = s.charAt(right);
      right++;
      if (need.containsKey(r)) {
        window.put(r, window.getOrDefault(r, 0) + 1);
        if (window.get(r) == need.get(r)) {
          valid++;
        }
      }

      while (right - left >= need.size()) {
        if (valid == need.size()) {
          res.add(left);
        }
        char l = s.charAt(left);
        left++;
        if (need.containsKey(l)) {
          if (window.get(l) == need.get(l)) {
            valid--;
          }
          window.put(l, window.get(l) - 1);
        }
        //这样也可以
        //window.put(l, window.getOrDefault(l, 0) - 1);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    List<Integer> list = findAnagrams("abab", "ab");
    System.out.println(list);
  }
}
