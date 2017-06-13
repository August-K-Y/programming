package kang.interview.programming.array;

import kang.interview.programming.util.AlgorithmTestUtil;

public class OrderingArrayAroundAElement {

	public void orderAround(int[] array, int index) {
		int pivot = array[index];
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
              
			while(array[left] < pivot) left ++;
			while(array[right] > pivot) right --;
			if(left <= right) 
			{
				swap(array, left, right);
				left++;
				right--;
			}
		}
	}

	private void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	public static void main(String[] arg) {
		System.out.println("run");
		int[] array = { 5, 7, 8, 1, 2, 39, 8, 6, 8 };
		AlgorithmTestUtil.printArray(array);
		OrderingArrayAroundAElement ora = new OrderingArrayAroundAElement();
		ora.orderAround(array, 8);
		AlgorithmTestUtil.printArray(array);
	}


}
