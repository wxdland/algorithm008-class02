package 第三周;

import java.util.HashMap;
import java.util.Map;

public class buildTree {
  int pre_idx=0;
  int[] pre;
  int[] in;
  Map<Integer,Integer> map=new HashMap<Integer,Integer>();

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
     this.pre=preorder;
     this.in=inorder;

     int idx=0;
     for(Integer val:inorder){
       map.put(val,idx++);
     }

     return helper(0,inorder.length);
  }

  public TreeNode helper(int left_idx, int right_idx) {
    if(left_idx==right_idx){
      return null;
    }
    int root_val=pre[pre_idx];
    TreeNode node=new TreeNode(root_val);

    int index=map.get(root_val);
    pre_idx++;

    node.left=helper(left_idx,index);
    node.right=helper(index+1,left_idx);

    return node;
  }

}

