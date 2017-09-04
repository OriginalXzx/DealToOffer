package xzx.dongtaiguihua;


/**
 * ����һ����n��������������A��һ������sum,��ѡ������A�в������ֺ�Ϊsum�ķ�������
 * ������ѡȡ������һ�����ֵ��±겻һ��,���Ǿ���Ϊ�ǲ�ͬ����ɷ�����
 * 
 * ���ö�̬�滮�ķ��� dp[i][j]��ʾ��ǰi��ֵ��ɺ�Ϊj�ķ������� if(p[i]<=j) dp[i][j] =
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

	// ��������
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
