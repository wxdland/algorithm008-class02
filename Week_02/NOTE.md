第二周总结
===========================
脑图+代码片段
****

作者：邬湘东-java<br>
概念图:
![image text](https://github.com/wxdland/algorithm008-class02/blob/master/Week_02/week02.png)

****
## 代码
#### 1.给定一个非空的整数数组，返回其中出现频率前 k 高的元素
输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]。
时间复杂度：O(nlogk)
空间复杂度：
O(n)
```java
public List<Integer> topKFrequent(int[] nums, int k) {
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer,Integer> map = new HashMap();
        for(int num : nums){
            if (map.containsKey(num)) {
               map.put(num, map.get(num) + 1);
             } else {
                map.put(num, 1);
             }
        }
        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        // 取出最小堆中的元素
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove());
        }
        return res;
    }
```

#### 2.给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位，返回滑动窗口中的最大值
输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7] 
时间复杂度：O(N)
空间复杂度：O(N)
```java
ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
  int [] nums;

  public void clean_deque(int i, int k) {
    // remove indexes of elements not from sliding window
    if (!deq.isEmpty() && deq.getFirst() == i - k)
      deq.removeFirst();

    // remove from deq indexes of all elements 
    // which are smaller than current element nums[i]
    while (!deq.isEmpty() && nums[i] > nums[deq.getLast()])                           deq.removeLast();
  }

  public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    if (n * k == 0) return new int[0];
    if (k == 1) return nums;

    // init deque and output
    this.nums = nums;
    int max_idx = 0;
    for (int i = 0; i < k; i++) {
      clean_deque(i, k);
      deq.addLast(i);
      // compute max in nums[:k]
      if (nums[i] > nums[max_idx]) max_idx = i;
    }
    int [] output = new int[n - k + 1];
    output[0] = nums[max_idx];

    // build output
    for (int i  = k; i < n; i++) {
      clean_deque(i, k);
      deq.addLast(i);
      output[i - k + 1] = nums[deq.getFirst()];
    }
    return output;
  }
```
#### 3.给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)
输入:![image text]()
输出: [
     [1],
     [3,2,4],
     [5,6]
      ]
时间复杂度：O(N)
空间复杂度：O(N)
```java
private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        if (root != null) traverseNode(root, 0);
        return result;
    }

    private void traverseNode(Node node, int level) {
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        for (Node child : node.children) {
            traverseNode(child, level + 1);
        }
    }
```
 
