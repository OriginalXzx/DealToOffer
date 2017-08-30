package xzx.part2.array;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 
 * @author xzx
 *
 */
public class ReOrderArray {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8,11,6,8,2};
		reOrderArray(arr);
		System.out.println(Arrays.toString(arr));
	}

	// 要保持奇数与奇数。偶数与偶数位置不变，应该两两比较
	public static void reOrderArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if(!changeTurn(arr, i)){
				break;
			}
		}
	}

	// 这个函数的作用是，把从前往后最近的奇数放在首位，偶数依次往后移
	public static boolean changeTurn(int[] arr, int start) {
		if (arr == null || arr.length == 0) {
			return false;
		}
        boolean result = false;
		for (int i = start; i < arr.length; i++) {
			if ((arr[i] & 1) == 1) {
				result =true;
				int temp = arr[i];
				while (i >= start + 1) {
					int j = i-1;
					arr[i] = arr[j];
					System.out.println(arr[i]);
					i--;
				}
				arr[start] = temp;
				break;
			}
		}
		return result;
	}

}
