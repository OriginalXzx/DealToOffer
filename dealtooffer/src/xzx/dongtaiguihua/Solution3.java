package xzx.dongtaiguihua;

import java.util.Scanner;

/**
 * 大富翁游戏，玩家根据骰子的点数决定走的步数，即骰子点数为1时可以走一步，点数为2时可以走两步，
 * 点数为n时可以走n步。求玩家走到第n步（n<=骰子最大点数且是方法的唯一入参）时，总共有多少种投骰子的方法。
 * 注意内循坏和外循环的选定
 * 
 * @author xzx
 *
 */
public class Solution3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] coins = { 1, 2, 3, 4, 5, 6 };

		int[] dp = new int[n + 1];
		dp[0] = 1;
		for (int j = 1; j < dp.length; j++) {
			for (int i = 0; i < coins.length; i++) {
				if (j >= coins[i]) {
					dp[j] += dp[j - coins[i]];
				}
			}
		}
		System.out.println(dp[n]);

	}

}
