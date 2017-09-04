package xzx.part2.array;


import java.util.Scanner;

/**
 * 输入n个整数，输出出现次数大于等于数组长度一半的数 思路：快排的思想
 * 
 * @author xzx
 *
 */
public class Solution3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] strs = str.split(" ");
		int[] arr = new int[strs.length];
		int index = 0;
		for (String s : strs) {
			arr[index++] = Integer.parseInt(s);
		}
		solution(arr);

	}

	public static void solution(int[] arr) {
		// 快速排序的思想，找到index = mid的数
		if (arr == null || arr.length == 0) {
			return;
		}
		int temp = arr[0];
		int index = 0;
		while (index != arr.length / 2 - 1) {
			int start = 0;
			int end = arr.length - 1;
			while (start < end) {
				while (start < end && arr[start] < temp) {
					start++;
				}
				while (start < end && arr[end] > temp) {
					end--;
				}
				if (start < end) {
					exchange(arr, start, end);
					start++;
					end--;
				}
			}
			index = start;
			exchange(arr, 0, start);
			if (index < arr.length / 2) {
				temp = arr[start + 1];
			}
			if (index > arr.length / 2) {
				temp = arr[start - 1];
			}
		}
		System.out.println(arr[index]);

	}

	// 交换数组中两个数
	public static void exchange(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
