package xzx.souhu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Protice2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		solution(str);

	}
	
	public static void solution(String str){
		if(str.length()<=5||str==null){
			System.out.println(0);
		}
		
		char[] arr = str.toCharArray();
		ArrayList<Character> list;
		int[] dp = new int[arr.length];//表示已arr【i】开头的可以得到的最大宝石数
		for (int i = 0; i < arr.length; i++) {
			list = new ArrayList<Character>();
			list.add('A');
			list.add('B');
			list.add('C');
			list.add('D');
			list.add('E');
			int index = i+1;
			int count = 1;
			while(index!=i){
				if(index==arr.length){
					index=0;
				}
				if(list.isEmpty()){
					dp[i] = arr.length - count;
					break;
				}
				if(list.contains(arr[i])){
					list.remove(list.indexOf(arr[i]));
				}
				if(list.contains(arr[index])){
					list.remove(list.indexOf(arr[index]));
					count++;
					index++;
				}else{
					index++;
					count++;
				}
				if(index==arr.length){
					index=0;
				}
			}
			if(!list.isEmpty()){
				dp[i] = 0;
			}
		}
		Arrays.sort(dp);
		
		System.out.println(dp[arr.length-1]);
	}

}
