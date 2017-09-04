package xzx.dongtaiguihua;


/**
 * 给定一个有n个正整数的数组A和一个整数sum,求选择数组A中部分数字和为sum的方案数。
 * 当两种选取方案有一个数字的下标不一样,我们就认为是不同的组成方案。
 * 
 * 采用动态规划的方法 dp[i][j]表示用前i个值组成和为j的方案个数 if(p[i]<=j) dp[i][j] =
 * dp[i-1][j]+dp[i-1][j-p[i]]; else dp[i][j] = dp[i-1][j];
 * 
 * @author xzx
 *
 */
public class Solution4_1 {
	public static void main(String[] args) {
		int[] arr = { 2, 3, 5, 5, 10 };
		solution(arr, 15,5);
	}

	public static void solution(int[] arr,int m,int n) {

		long[][] dp = new long[n][m + 1];
		dp[0][0] = 1;
		if (arr[0] <= m) {
			dp[0][arr[0]] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= m; j++) {
				if (j - arr[i] < 0) {
					dp[i][j] += dp[i - 1][j];
				} else {
					dp[i][j] += dp[i - 1][j - arr[i]] + dp[i - 1][j];
				}
			}
		}
		System.out.println(dp[n - 1][m]);
	}

	// 方法二：
	public static long bag(int[] weight, int n, int sum) {
		long dp[] = new long[sum + 1];
		dp[0] = 1;
		int i, j;
		for (i = 0; i < n; i++) {
			for (j = sum; j >= weight[i]; j--) {
				dp[j] = dp[j - weight[i]] + dp[j];
			}
		}
		return dp[sum];
	}

}
