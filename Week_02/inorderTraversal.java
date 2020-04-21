package 第二周;

import java.util.ArrayList;
import java.util.List;

public class inorderTraversal {

  class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static List<Integer> traversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    helper(root, res);
    return res;
  }

  private static void helper(TreeNode root, List<Integer> list) {
    if (root != null) {
      if (root.left != null) {
        helper(root.left, list);
      }
      list.add(root.val);
      if (root.right != null) {
        helper(root.right, list);
      }
    }
  }

  public static void main(String[] args) {

    System.out.print("");
  }
}
