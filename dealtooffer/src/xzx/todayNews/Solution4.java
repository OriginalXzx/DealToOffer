package xzx.todayNews;

import java.util.Scanner;

/**
 * 给定一个数组序列, 需要求选出一个区间, 使得该区间是所有区间中经过如下计算的值最大的一个： 区间中的最小数 * 区间所有数的和
 * 
 * @author xzx
 *
 */
public class Solution4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
        System.out.println(solution(arr));
	}

	public static int solution(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}

		int[][] dp = new int[arr.length][arr.length];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp.length; j++) {
				dp[i][j] = min(arr,i,j)*and(arr,i,j);
			}
		}
		int max = dp[0][0];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp.length; j++) {
				if(dp[i][j]>max){
					max= dp[i][j];
				}
			}
		}
       
		return max;
	}

	public static int and(int[] arr, int pre, int last) {
		int result = 0;
		for (int i = pre; i <= last; i++) {
			result += arr[i];
		}
		return result;
	}

	public static int min(int[] arr, int pre, int last) {
		int min = arr[pre];
		for (int i = pre; i <= last; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}
}
