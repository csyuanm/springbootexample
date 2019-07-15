/**
 * @Date          2019年7月8日 上午10:43:04 

 * @version    V1.0 
 */
package sorts;

import java.util.Arrays;

/**
 * @author MML
 * @Date    2019-07-08
 * @version    V1.0 
 */
public class Sorts {

	/**
	 * 
	 * @param args
	 * @Date    2019-07-08
	 * @version 1.0
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {6,1,5,8,2,5,9,4,7};
//		arr = bubbleSort(arr);
//		arr = selectSort(arr);
		arr = insertSort(arr);
		System.out.print("排序结果为：");
		for (int i : arr) {
			System.out.print(i + "  ");
		}
	}
	
	public static void swap(int val1, int val2) {
		int temp = val1;
		val1 = val2;
		val2 = temp;
	}
	
	/**
	 * 冒泡排序
	 * @param arr
	 * @return
	 * @Date    2019-07-08
	 * @version 1.0
	 */
	public static int[] bubbleSort(int arr[]) {
		for(int i = 0;i < arr.length - 1;i++){ //控制循环次数
			for(int j = 0;j < arr.length - i -1;j++) {
				if(arr[j] > arr[j + 1]) {  //两两相邻比较，把大的冒出来
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
			System.out.print("第" + (i+1) + "次遍历结束后的结果为：");
			for (int x : arr) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
		return arr;
	}
	
	/**
	 * 每次选择最大或者最小的元素，放在开始或者末尾
	 * @param arr
	 * @return
	 * @Date    2019-07-08
	 * @version 1.0
	 */
	public static int[] selectSort(int arr[]) {
		
		for(int i = 0;i < arr.length - 1;i++) {  //每次选中一个数
			for(int j = i + 1;j < arr.length;j++) {  //剩下的数跟选中的数比较
				if(arr[i] > arr[j]) {  //选出比arr[i]小的元素，每次循环时，跟arr[i]比较，如果arr[j]比arr[i]小，则交换位置
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			System.out.print("第" + (i+1) + "次遍历结束后的结果为：");
			for (int x : arr) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
		return arr;
	}
	
	/**
	 * 
	 * @param arr
	 * @return
	 * @Date    2019-07-08
	 * @version 1.0
	 */
	public static int[] insertSort(int arr[]) {
		for(int i = 0; i < arr.length;i++) {  //假定arr[i]之前的都是排好队的
			for(int j = i;j > 0; j--) {  //i之后的元素跟排好队（i之前的）比较，并交换位置
				if(arr[j] < arr[j-1]) {  //用j代替i，判断i后边的是否比前一个小，如果小，则排到前面，依次直到第一个数，
					//越到后边，所需要循环次数越多
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
			System.out.print("第" + (i+1) + "次遍历结束后的结果为：");
			for (int x : arr) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
		return arr;
	}
	
	/*
	 * 选择一个增量序列 t1，t2，……，tk，其中 ti > tj, tk = 1；

		按增量序列个数 k，对序列进行 k 趟排序；

		每趟排序，根据对应的增量 ti，将待排序列分割成若干长度为 m 的子序列，
		分别对各子表进行直接插入排序。仅增量因子为 1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
	 */

}
