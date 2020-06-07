package 第七周;

/*
实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
示例:
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // 返回 true
trie.search("app");     // 返回 false
trie.startsWith("app"); // 返回 true
trie.insert("app");
trie.search("app");     // 返回 true
说明:

你可以假设所有的输入都是由小写字母 a-z 构成的。
保证所有输入均为非空字符串。
*/
public class Trie {

  private TreeNode root;

  public Trie() {
    root = new TreeNode();
  }

  /**
   * Inserts a word into the trie.
   */
  public void insert(String word) {
    TreeNode node = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (!node.containsKey(c)) {
        node.put(c, new TreeNode());
      }
      node = node.get(c);
    }
    node.setEnd();
  }

  /**
   * Returns if the word is in the trie.
   */
  public boolean search(String word) {
    TreeNode node = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (node.containsKey(c)) {
        node = node.get(c);
      } else {
        return false;
      }
    }
    return node != null && node.isEnd;
  }

  /**
   * Returns if there is any word in the trie that starts with the given prefix.
   */
  public boolean startsWith(String prefix) {
    TreeNode node = root;
    for (int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      if (!node.containsKey(c)) {
        return false;
      }
    }
    return node != null;
  }


  class TreeNode {

    public TreeNode[] links;
    private final int R = 26;
    private boolean isEnd;

    public TreeNode() {
      links = new TreeNode[R];
    }

    public boolean containsKey(char ch) {
      return links[ch - 'a'] != null;
    }

    public TreeNode get(char ch) {
      return links[ch - 'a'];
    }

    public void put(char ch, TreeNode node) {
      links[ch - 'a'] = node;
    }

    public void setEnd() {
      isEnd = true;
    }

    public boolean isEnd() {
      return isEnd;
    }
  }


  public static void main(String[] args) {
    Trie tre = new Trie();
    tre.insert("hello");
    System.out.println(tre.startsWith("helloa"));
  }

}
