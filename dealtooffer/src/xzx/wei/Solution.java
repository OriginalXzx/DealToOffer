package xzx.wei;

import java.util.Scanner;

/**
 * 春天是鲜花的季节，水仙花就是其中最迷人的代表，数学上有个水仙花数，他是这样定义的：
 * “水仙花数”是指一个三位数，它的各位数字的立方和等于其本身，比如：153=1^3+5^3+3^3。 现在要求输出所有在m和n范围内的水仙花数。
 * 
 * @author xzx
 *
 */
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean bl = false;
		StringBuffer sb = new StringBuffer();
		for (int i = n; i <= m; i++) {
			if(isF(i)){
				sb.append(i+" ");
				bl = true;
			}
		}
		if(!bl){
			System.out.println("no");
		}else{
			sb.deleteCharAt(sb.length()-1);
			System.out.println(sb);
		}

	}
	/**
	 * 判断n是不是水仙花数
	 * @param n
	 * @return
	 */
	public static boolean isF(int n){
		if(n==0){
			return true;
		}
		int de = n;
		int temp = 0;
		while(n>0){
			int r = n%10;
			temp += r*r*r;
			//System.out.println("n: "+n+"r: "+r+"temp: "+temp);
			n = n/10;
		}
		if(temp==de){
			return true;
		}else{
			return false;
		}
	}

}
