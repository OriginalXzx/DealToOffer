package xzx.dongtaiguihua;

import java.util.Scanner;

/**
 * 给你六种面额1、5、10、20、50、100元的纸币，假设每种币值的数量都足够多，编写程序求组成N员（N为0-10000的非负整数）的不同组合的个数。
 * 
	典型的动态规划问题，状态是总数为n时的可能性，用dp[]数组表示，状态转移的条件是j>=coins[i]，
	此时状态转移的方程为dp[j]+=dp[j-coins[i]]    注意内外循环，内循环是总数，外循环是面额，	
 * @author xzx
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		
		int[] coins = {1,5,10,20,50,100};//存储能用的的钱币面额
		
		long[] dp = new long[n+1];//用于储存拼出该索引数的种数
		dp[0] = 1L;
		
		for (int i = 0; i < coins.length; i++) {
			for (int j = 1; j < dp.length; j++) {
				if(j>=coins[i]){
					dp[j] += dp[j - coins[i]];
				}
			}
		}
		System.out.println(dp[n]);
	}
	

}
