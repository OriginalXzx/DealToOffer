package xzx.part2.array;


import java.util.Scanner;

/**
 * ����n��������������ִ������ڵ������鳤��һ����� ˼·�����ŵ�˼��
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
		// ���������˼�룬�ҵ�index = mid����
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

	// ����������������
	public static void exchange(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
