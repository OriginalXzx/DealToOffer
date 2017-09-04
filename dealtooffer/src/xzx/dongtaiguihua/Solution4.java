package xzx.dongtaiguihua;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一个有n个正整数的数组A和一个整数sum,求选择数组A中部分数字和为sum的方案数。
 * 当两种选取方案有一个数字的下标不一样,我们就认为是不同的组成方案。
 * 
 * 可以采用回溯法,但是会超时
 * 
 * @author xzx
 *
 */
public class Solution4 {

	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		solution(arr, 0, m);
		System.out.println(count);

	}

	public static void solution(int[] arr, int index, int m) {
		
		if (arr == null || arr.length == 0) {
			return;
		}
		if (m == 0) {
			count++;
		} else {
			for (int i = index; i < arr.length&&arr[i] <= m; i++) {
				if (arr[i] > m) {
					break;
				}
			
				solution(arr, i + 1, m - arr[i]);
				
				System.out.println("m: "+m+"i:"+i+"count"+count);
			}
		}

	}

}
