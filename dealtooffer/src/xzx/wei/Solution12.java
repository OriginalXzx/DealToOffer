package xzx.wei;

import java.util.Scanner;

/**
 * 给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数
 * 
 * @author xzx
 *
 */
public class Solution12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long m =sc.nextLong();
		int n =sc.nextInt();
		System.out.println(solution(m, n));

	}

	public static String solution(long m, int n) {
		if (m == 0) {
			return "0";
		}
		if(m<0){
			return "-"+solution(-m, n);
		}
		StringBuffer sb = new StringBuffer();
		char[] chars = { 'A', 'B', 'C', 'D', 'E', 'F' };
		while (m != 0) {
			long q = m / n;
			long r = m % n;
			if (r > 9) {
              sb.append(chars[(int) (r-10)]);
			} else {
				sb.append(r);
			}

			m = q;
		}
		StringBuffer resb = sb.reverse();
		return resb.toString();
	}
    
	
}
