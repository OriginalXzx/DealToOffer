package xzx.jd;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if(countTen(i)==countTwo(i)){
				count++;
			}
		}
		System.out.println(count);
	}

	public static int countTwo(int n) {
		int res = 0;
		while (n != 0) {
			n &= (n - 1);
			res++;
		}
		return res;
	}
	
	public static int countTen(int n){
		int res = 0;
		while(n>0){
			int d = n%10;
			n = n/10;
			res += d;
		}
		return res;
	}
}
