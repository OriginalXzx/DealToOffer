package xzx.lianjia;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		if (n == 0) {
			System.out.println(0);
			return;
		}
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		int n2 = sc.nextInt();
		if (n2 == 0) {
			System.out.println(0);
			return;
		}
		int[] arr2 = new int[n2];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = sc.nextInt();
		}
		sc.close();

		// System.out.println(Arrays.toString(arr));
		// System.out.println(Arrays.toString(arr2));
		int[] maxHao = maxHao(arr);
		//System.out.println(Arrays.toString(maxHao));
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(binarySearch(maxHao, maxHao.length, arr2[i]) + 1);
		}
	}

	// 每个组最大编号
	public static int[] maxHao(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		int[] dp = new int[arr.length];
		dp[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			dp[i] = arr[i] + dp[i - 1];
		}
		return dp;

	}

	// 二分判断在多少组
	public static int binarySearch(int[] arr, int n, int index) {
		int start = 0;
		int end = n - 1;
		int mid = 0;
		while (start < end) {
			mid = (start + end) / 2;
			if(mid==0){
				if(index<=arr[0]){
					return 0;
				}
			}
			if (arr[mid] > index && arr[mid - 1] > index) {
				end = mid - 1;
			} else if (arr[mid] < index && arr[mid + 1] < index) {
				start = mid + 1;
			} else if (arr[mid] >= index && arr[mid - 1] < index) {
				return mid;
			} else {
				return mid + 1;
			}
		}
		return -1;
	}

}
