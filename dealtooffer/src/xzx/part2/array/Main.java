package xzx.part2.array;

import java.util.Scanner;

/**
 * 美团外卖的品牌代言人袋鼠先生最近正在进行音乐研究。他有两段音频，每段音频是一个表示音高的序列。现在袋鼠先生想要在第二段音频中找出与第一段音频最相近的部分。
 * 
 * 具体地说，就是在第二段音频中找到一个长度和第一段音频相等且是连续的子序列，使得它们的 difference 最小。两段等长音频的 difference
 * 定义为： difference = SUM(a[i] - b[i])2 (1 ≤ i ≤ n),其中SUM()表示求和 其中 n 表示序列长度，a[i],
 * b[i]分别表示两段音频的音高。现在袋鼠先生想要知道，difference的最小值是多少？数据保证第一段音频的长度小于等于第二段音频的长度。
 * 
 * 输入描述: 第一行一个整数n(1 ≤ n ≤ 1000)，表示第一段音频的长度。 第二行n个整数表示第一段音频的音高（0 ≤ 音高 ≤ 1000）。
 * 第三行一个整数m(1
 * 
 * @author xzx
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr1Length = sc.nextInt();
		int[] arr1 = null;
		if (arr1Length > 0 && arr1Length <= 1000) {
			arr1 = new int[arr1Length];
			for (int i = 0; i < arr1Length; i++) {
				arr1[i] = sc.nextInt();
			}
		} else {
			System.out.println(0);
			return;
		}
		int arr2Length = sc.nextInt();
		int[] arr2 = null;
		if (arr2Length > 0 && arr2Length <= 1000) {
			arr2 = new int[arr2Length];
			for (int j = 0; j < arr2.length; j++) {
				arr2[j] = sc.nextInt();
			}
		} else {
			System.out.println(-1);
			return;
		}
		System.out.println(minDifference(arr1, arr2));
	}

	public static int minDifference(int[] arr1, int[] arr2) {
		if (arr1 == null && arr1.length == 0) {
			return 0;
		}
		if (arr2 == null && arr2.length == 0) {
			return -1;
		}
		int arr1Length = arr1.length;
		int arr2Length = arr2.length;
		int[] difference = new int[arr2Length - arr1Length + 1];
		int i = 0;
		while (i < arr2Length - arr1Length + 1) {
			if (difference(arr1, arr2, 0, i, arr1.length) == 0) {
				return 0;
			} else {
				difference[i] = difference(arr1, arr2, 0, i, arr1.length);
			}
			i++;
		}
		int minDifference = difference[0];
		;
		for (int j = 0; j < difference.length; j++) {
			if (difference[j] < minDifference) {
				minDifference = difference[j];
			}
		}
		return minDifference;

	}

	/**
	 * 计算两个序列dfference
	 * 
	 * @param arr1
	 * @param arr2
	 * @param beginIndex1
	 * @param beginIndex2
	 * @param n
	 * @return
	 */
	public static int difference(int[] arr1, int[] arr2, int beginIndex1, int beginIndex2, int n) {
		int sum = 0;
		if (arr1 == null) {
			return 0;
		}
		if (arr2 == null) {
			return -1;
		}
		int i = beginIndex1;
		int j = beginIndex2;
		for (; i < n + beginIndex1 && j < beginIndex2 + n; i++, j++) {
			sum += (arr1[i] - arr2[j]) * (arr1[i] - arr2[j]);
		}
		return sum;

	}

}
