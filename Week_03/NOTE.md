第三周总结
--
本周主要学习二叉树遍历，递归，回溯算法<br>

二叉树遍历
---
* BFS 广度优先(搜索路径最短，但空间复杂度比DFS高)</br>
二叉树的最小深度</br>
```java
int minDepth(TreeNode root) {
    if (root == null) return 0;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    // root 本身就是一层，depth 初始化为 1
    int depth = 1;

    while (!q.isEmpty()) {
        int sz = q.size();
        /* 将当前队列中的所有节点向四周扩散 */
        for (int i = 0; i < sz; i++) {
            TreeNode cur = q.poll();
            /* 判断是否到达终点 */
            if (cur.left == null && cur.right == null) 
                return depth;
            /* 将 cur 的相邻节点加入队列 */
            if (cur.left != null)
                q.offer(cur.left);
            if (cur.right != null) 
                q.offer(cur.right);
        }
        /* 这里增加步数 */
        depth++;
    }
    return depth;
}
```
* DFS 广度优先(前,中，后序遍历)</br>
前序遍历:
--在第一次遍历到节点时就执行操作，一般只是想遍历执行操作（或输出结果）可选用先序遍历
```java
~递归法:
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        preorderHelper(root, result);
        return result;
    }

    private void preorderHelper(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val); // 访问根节点
        preorderHelper(root.left, result); // 递归遍历左子树
        preorderHelper(root.right, result); //递归遍历右子树
    }
}
~双栈法:
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;

        Stack<TreeNode> toVisit = new Stack<>();
        toVisit.push(root);
        TreeNode cur;

        while (!toVisit.isEmpty()) {
            cur = toVisit.pop();
            result.addFirst(cur.val);
            if (cur.left != null) toVisit.push(cur.left);
            if (cur.right != null) toVisit.push(cur.right);
        }
        return result;
    }
}
```

中序遍历:
--对于二分搜索树，中序遍历的操作顺序（或输出结果顺序）是符合从小到大（或从大到小）顺序的，故要遍历输出排序好的结果需要使用中序遍历(~迭代法)

```java
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> toVisit = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !toVisit.isEmpty()) {
            while (cur != null) {
                toVisit.push(cur); // 添加根节点
                cur = cur.left; // 循环添加左节点
            }
            cur = toVisit.pop(); // 当前栈顶已经是最底层的左节点了，取出栈顶元素，访问该节点
            result.add(cur.val);
            cur = cur.right; // 添加右节点
        }
        return result;
    }
}
```
后序遍历:
--后续遍历的特点是执行操作时，肯定已经遍历过该节点的左右子节点，故适用于要进行破坏性操作的情况，比如删除所有节点
```java
~迭代法:
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> toVisit = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;

        while (cur != null || !toVisit.isEmpty()) {
            while (cur != null) {
                toVisit.push(cur); // 添加根节点
                cur = cur.left; // 递归添加左节点
            }
            cur = toVisit.peek(); // 已经访问到最左的节点了
            //在不存在右节点或者右节点已经访问过的情况下，访问根节点
            if (cur.right == null || cur.right == pre) { 
                toVisit.pop();
                result.add(cur.val);
                pre = cur;
                cur = null;
            } else {
                cur = cur.right; // 右节点还没有访问过就先访问右节点
            }
        }
        return result;
    }
}
```
* 在二叉树中查找一个数可套用的代码：
```java
boolean isInBST(TreeNode root, int target) {
    if (root == null) return false;
    if (root.val == target)
        return true;
    if (root.val < target) 
        return isInBST(root.right, target);
    if (root.val > target)
        return isInBST(root.left, target);
    // root 该做的事做完了，顺带把框架也完成了，妙
}
```
* 插入一个数：
```java
TreeNode insertIntoBST(TreeNode root, int val) {
    // 找到空位置插入新节点
    if (root == null) return new TreeNode(val);
    // if (root.val == val)
    //     BST 中一般不会插入已存在元素
    if (root.val < val) 
        root.right = insertIntoBST(root.right, val);
    if (root.val > val) 
        root.left = insertIntoBST(root.left, val);
    return root;
}
```
* 删除一个数
```java
TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) return null;
    if (root.val == key) {
        // 这两个 if 把情况 1 和 2 都正确处理了
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;
        // 处理情况 3
        TreeNode minNode = getMin(root.right);
        root.val = minNode.val;
        root.right = deleteNode(root.right, minNode.val);
    } else if (root.val > key) {
        root.left = deleteNode(root.left, key);
    } else if (root.val < key) {
        root.right = deleteNode(root.right, key);
    }
    return root;
}

TreeNode getMin(TreeNode node) {
    // BST 最左边的就是最小的
    while (node.left != null) node = node.left;
    return node;
}
```

回溯法:
--
回溯法可以套用的代码模板:
```java
List<List<...>>result=new LinkedList<>();
void backtrack(路径, 选择列表):
    if 满足结束条件:
        result.add(路径)
        return;    
    for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择
```
* 典型问题----全排列
```java
有重复元素的全排列
private static List<List<Integer>>list=new ArrayList<>();

  public static List<List<Integer>> permuteUnique(int[] nums) {
    Arrays.sort(nums);
    findUnique(nums,new boolean[nums.length],new LinkedList<>());
    return list;
  }
  public static void findUnique(int[] nums,boolean[]used, LinkedList<Integer>trace){
    if(trace.size()==nums.length){
      list.add(new ArrayList<>(trace));
      return;
    }
    for (int i=0;i<nums.length;i++){
      if(used[i]){
        continue;
      }
      if(i>0&&nums[i]==nums[i-1]&&used[i-1]){
        continue;
      }
      trace.add(nums[i]);
      used[i]=true;
      findUnique(nums,used,trace);
      trace.removeLast();
      used[i]=false;
    }

  }
  ```
  **总结:</br>
  ---
  回溯法是递归的一种，目前刷的题基本是Stack，Queue加一个循环加一个递归，难点是有些题的边界条件是真的难找啊，只能先看题解，经验 还不足，没有形成肌肉记忆，后面还要加大刷题数
