package xzx.wei;

import java.math.BigDecimal;
import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m =sc.nextInt();
		System.out.println(String.format("%.2f", format(solution(n, m))));

	}
	
	public  static double solution(int n,int m){
		if(n==0){
			return 0;
		}
		if(n<0){
			return -1;
		}
		
		double sum = n;
		double a = n;
		for (int i = 1; i <= m-1; i++) {
			double temp = Math.sqrt(a);
			sum += temp;
			if(temp<0.005){
				break;
			}
			a = temp;
		}
		return sum;
	}
	
	public static double format(double f){
		BigDecimal bg = new BigDecimal(f);
		double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return f1;
	}

}
