package 第四周;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
示例：
二叉树：[3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：
[
  [3],
  [9,20],
  [15,7]
]
date:2020/5/12 22:58
 */
public class levelOrder {

  List<List<Integer>> result = new ArrayList<>();
  Queue<TreeNode> q = new LinkedList<>();

  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) {
      return result;
    }
    q.offer(root);
    while (!q.isEmpty()) {
      int size = q.size();
      ArrayList<Integer> tmp = new ArrayList<Integer>();
      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();
        tmp.add(node.val);
        if (node.left != null) {
          q.offer(node.left);
        }
        if (node.right != null) {
          q.offer(node.right);
        }
      }
      result.add(tmp);
    }
    return result;
  }


  public static void main(String[] args) {

  }


}
