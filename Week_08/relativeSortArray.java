package 第八周;

/*
给你两个数组，arr1 和 arr2，

arr2 中的元素各不相同
arr2 中的每个元素都出现在 arr1 中
对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 
示例：
输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
输出：[2,2,2,1,4,3,3,9,6,7,19]
 
提示：
arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
arr2 中的元素 arr2[i] 各不相同
arr2 中的每个元素 arr2[i] 都出现在 arr1 中
*/
public class relativeSortArray {


  public int[] relativeSortArray(int[] res,int[] arr1, int[] arr2) {

    //初始化两个数组
    int[] arr=new int[1001];
    res=new int[arr1.length];

    //对数组1进行计数
    for (int ele:arr1){
      arr[ele]++;
    }

    int index=0;
    //将数组2中的元素按序放入新数组
    for (int item:arr2) {
      while(arr[item]-->0){
        res[index]=item;
        index++;
      }
    }

    //将数组1中元素放入,下标值即为arr1元素值
    for (int i = 0; i < 1001; i++) {
      while(arr[i]-->0){
        res[index]=i;
        index++;
      }

    }
    return res;
  }

  public static void main(String[] args) {
    relativeSortArray sort=new relativeSortArray();
    int[] arr1=new int[]{2,3,1,3,2,4,6,7,9,2,19};
    int[] arr2=new int[]{2,1,4,3,9,6};
    int[] arr=new int[]{};
    arr=sort.relativeSortArray(arr,arr1,arr2);
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]);
    }

  }
}
