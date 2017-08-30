package xzx.lianjia;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 10;
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int highOfPeople = sc.nextInt();
		sc.close();
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if(canGet(arr[i], 30, highOfPeople)){
				count++;
			}
		}
		System.out.println(count);

	}
	
	public static boolean canGet(int highOfTree,int highOfDesk,int highOfPeople){
		if(highOfDesk+highOfPeople>=highOfTree){
			return true;
		}else{
			return false;
		}
	}

}
