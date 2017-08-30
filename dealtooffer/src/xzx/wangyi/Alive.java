package xzx.wangyi;

import java.util.Scanner;

public class Alive {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			int[] arr = new int[4];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
		}
		sc.close();
		
       System.out.println(aliveDays(arr[0], arr[1], arr[2], arr[3]));
	}

	public static int aliveDays(int x, int f, int d, int p) {
		if (d < x) {
			return 0;
		}
		if (f * x >= d) {
			return d / x;
		}
		return f + (d - f * x) / (p + x);
	}

}
