package xzx.dongtaiguihua;

import java.util.Scanner;

/**
 * ������Ϸ����Ҹ������ӵĵ��������ߵĲ����������ӵ���Ϊ1ʱ������һ��������Ϊ2ʱ������������
 * ����Ϊnʱ������n����������ߵ���n����n<=�������������Ƿ�����Ψһ��Σ�ʱ���ܹ��ж�����Ͷ���ӵķ�����
 * ע����ѭ������ѭ����ѡ��
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
