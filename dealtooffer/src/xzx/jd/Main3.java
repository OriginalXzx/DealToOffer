package xzx.jd;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int sum = 0;
		for(int i = 2;i<= n-1;i++){
			sum += sum(n,i);
		}
		int gcd = gcd(sum,n-2);
		System.out.println(sum/gcd+"/"+(n-2)/gcd);

	}
	//n的k进制位数和
	public static int sum(int n,int k){
		if(n==1){
			return 1;
		}
		int res = 0;
		while(n>0){
			int d = n%k;
			n = n/k;
			res += d;
		}
		return res;
	}
	/**
	 * 求两个数的最大公约数
	 * @param x
	 * @param y
	 * @return
	 */
	public static int gcd(int x,int y){
		if(y==0){
			return x;
		}else{
			return gcd(y,x%y);
		}
	}

}
