package xzx.wei;

import java.util.Scanner;

/**
 * ����һ��ʮ������M���Լ���Ҫת���Ľ�����N����ʮ������Mת��ΪN������
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
