package xzx.todayNews;

import java.util.Scanner;

/**
 * 给定整数m以及n个数字A1, A2, …, An，将数列A中所有元素两两异或，共能得到n(n-1)/2个结果。请求出这些结果中大于m的有多少个。
 * @author xzx
 *
 */
public class Solution2 {
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(count(arr, m));

	}
	 
	public static int count(int[] array,int m){
		if(array==null || array.length == 0){
			return 0;
		}
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i+1; j < array.length; j++) {
				if((array[i]^array[j])>m){
					count ++;
				}
			}
		}
		return count;
	} 

}
