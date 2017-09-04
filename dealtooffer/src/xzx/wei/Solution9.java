package xzx.wei;

import java.util.Scanner;

public class Solution9 {
    static int count = 6; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(geohash(n,-90,90));

	}
	
	public static String geohash(int n,int pre,int end){
		String result = "";
		if(count==0){
			return result;
		}
		int mid = (pre+end)/2;
		if(n<mid){
			result += "0";
			count--;
			result += geohash(n, pre, mid);
		}else{
			result += "1";
			count--;
			result += geohash(n, mid, end);
		}
		return result;
	}
	

}
