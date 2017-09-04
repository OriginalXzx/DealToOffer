package xzx.part2.string;

import java.util.Scanner;

public class Solution6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int k =sc.nextInt();
		sc.close();
		System.out.println(solution(arr, k));

	}
	
	public static int solution(int[] arr,int k){
		
		if(arr==null||arr.length==0){
			return 0;
		}
		if(k==1){
			return arr.length;
		}
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if(max >= arr.length-i+1){
				return max;
			}
			int sum = 0;
			for (int j = i; j < arr.length; j++) {
				sum += arr[j];
				if(sum%k==0){
					max = Math.max(max, j-i+1);
				}
			}
		}
		return max;
	}

}
