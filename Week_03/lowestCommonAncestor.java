package 第三周;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]

示例 1:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
date :2020-4-30 0:30
 */
public class lowestCommonAncestor {

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    // Stack for tree traversal
    Deque<TreeNode> stack = new ArrayDeque<>();
    // HashMap for parent pointers
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    parent.put(root, null);
    stack.push(root);
    // Iterate until we find both the nodes p and q
    while (!parent.containsKey(p) || !parent.containsKey(q)) {
      TreeNode node = stack.pop();
      // While traversing the tree, keep saving the parent pointers.
      if (node.left != null) {
        parent.put(node.left, node);
        stack.push(node.left);
      }
      if (node.right != null) {
        parent.put(node.right, node);
        stack.push(node.right);
      }
    }
    // Ancestors set() for node p.
    Set<TreeNode> ancestors = new HashSet<>();
    // Process all ancestors for node p using parent pointers.
    while (p != null) {
      ancestors.add(p);
      p = parent.get(p);
    }
    // The first ancestor of q which appears in
    // p's ancestor set() is their lowest common ancestor.
    while (!ancestors.contains(q)) {
      q = parent.get(q);
    }
    return q;
  }


}
