package xzx.wei;

import java.util.Scanner;

/*
 * 给定整数m以及n各数字A1,A2,..An，将数列A中所有元素两两异或，共能得到n(n-1)/2个结果，请求出这些结果中大于m的有多少个。
 */
public class Solution7 {

	public static void main(String[] args) {
		/*Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(solution(arr, m));*/
		System.out.println(3^8);
				

	}
	
	public static int solution(int[] arr,int m){
		if(arr==null || arr.length ==0){
			return 0;
		}
		int count=0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if((arr[i]^arr[j])>m){
					count++;
				}
			}
		}
		return count;
	}

}
