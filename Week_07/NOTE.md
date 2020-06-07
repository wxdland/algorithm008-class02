## 本周主要学习了
- Trie树、并查集
- 双向BFS
- A\*搜索
- 红黑树、AVL树

## 字典树与并查集  
**字典树**，  
哈希表虽然可以在 O(1)时间内寻找键值，却无法高效的完成以下操作：
1.找到具有同一前缀的全部键值。
2.按词典序枚举字符串的数据集。

Trie 树优于哈希表的另一个理由是，随着哈希表大小增加，会出现大量的冲突，时间复杂度可能增加到 O(n)O(n)，其中 nn 是插入的键的数量。与哈希表相比，Trie 树在存储多个具有相同前缀的键时可以使用较少的空间。此时 Trie 树只需要 O(m)O(m) 的时间复杂度，其中 mm 为键长。而在平衡树中查找键值需要 O(m \log n)O(mlogn) 时间复杂度。

**基本性质：**  
1、结点本身不存完整单词  
2、从根结点到某一结点，路径上经过的字符连接起来，为该结点对应的字符串  
3、每个结点的所有子结点路径代表的字符都不相同  
 
trie代码模板：  
```java
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
```
```java
双向BFS模板
public String twoEndBFS(Object begin, Object end) {
    Queue<Object> startQ = new LinkedList<>();
    Queue<Object> endQ = new LinkedList<>();
    Set<Object> sVisited = new HashSet<>();
    Set<Object> eVisited = new HashSet<>();

    startQ.offer(begin);
    sVisited.add(begin);
    endQ.offer(end);
    eVisited.add(end);

    while (!startQ.isEmpty() && !endQ.isEmpty()) {
      // 从 begin 往 end 方向搜索
      if (!startQ.isEmpty()) {
        Object x = startQ.poll();
        if (x.equals(end) || eVisited.contains(x)) {
          // 找到了
          return "SUCCESS";
        }
        for (Object nextX : getNextPossible(x)) {
          if (!sVisited.contains(nextX)) {
            sVisited.add(nextX);
            startQ.offer(nextX);
          } else {
            // 已经搜索过了，看情况要不要处理
          }
        }
      }

      // 从 end 往 begin 方向搜索
      if (!endQ.isEmpty()) {
        Object y = endQ.poll();
        if (y.equals(begin) || sVisited.contains(y)) {
          // 找到了
          return "SUCCESS";
        }
        for (Object nextY : getNextPossible(y)) {
          if (!eVisited.contains(nextY)) {
            eVisited.add(nextY);
            endQ.offer(nextY);
          } else {
            // 已经搜索过了
          }
        }
      }
    }
    // 如果走到这里，说明没找到
    return "FAIL";
  }
```
### 红黑树<hr>
近似平衡二叉搜索树：<br>
1. 节点是红色或者黑色。<br>
2. 根节点是黑色。<br>
3. 每个叶子的节点都是黑色的空节点。<br>
4. 每个红色节点的两个子节点都是黑色的。<br>
5. 从任意节点到其每个叶子的所有路径都包含相同的黑色节点。<br>
