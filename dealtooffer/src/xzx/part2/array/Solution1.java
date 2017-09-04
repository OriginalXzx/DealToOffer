package xzx.part2.array;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
        System.out.println(solution(arr)==true? "Yes":"No");
	}
	
	public static boolean solution(int[] arr){
		if(arr==null||arr.length==0){
			return false;
		}
		Arrays.sort(arr);
		int sum = 0;
		for (int i = 0; i < arr.length-1; i++) {
			sum += arr[i];
		}
		if(arr[arr.length-1]<=sum){
			return true;
		}
		return false;
		
	}

}
