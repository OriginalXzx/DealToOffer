package xzx.dongtaiguihua;

import java.util.Scanner;

public class Solution1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		sc.close();
		System.out.println(solution(x, y));

	}
	
	public static int solution(int x,int y){
		if(x <= 0||y <= 0){
			return 0;
		}
		
		int[][] dp = new int[x+1][y+1];
		for (int i = 0; i < x+1; i++) {
		    dp[i][0] = 1;
		}
		for (int i = 0; i < y+1; i++) {
			dp[0][i] = 1;
		}
		for (int i = 1; i < x+1; i++) {
			for (int j = 1; j < y+1; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		return dp[x][y];
	}

}
