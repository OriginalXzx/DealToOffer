package xzx.wei;

import java.util.Scanner;

/*
 * ��������m�Լ�n������A1,A2,..An��������A������Ԫ��������򣬹��ܵõ�n(n-1)/2��������������Щ����д���m���ж��ٸ���
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
