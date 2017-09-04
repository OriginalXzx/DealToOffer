package xzx.wei;

import java.util.Scanner;

/**
 * 输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2
 * @author xzx
 *
 */
public class Solution14 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int i = 1;
		int count = 0;
		while(Math.pow(5, i)<=n){
			count += n/Math.pow(5, i);
			i++;
		}
		System.out.println(count);
	}

}
