package xzx.part2.string;
/**
 * 求最长公共子串
 * 思路：
	准备一个N+1 * N+1大小的二维数组dp，置0。
	dp[i][j]代表s1的0-i位置与s2的0-j位置中连续公共子串的最大长度。
	则有：
	    如果s1[i] == s2[j]，dp[i][j] = dp[i-1][j-1] + 1;
	    否则，dp[i][j] = 0;
	记录最大长度即可。
 */
import java.util.Scanner;

public class Solution5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		System.out.println(solution(str1, str2));

	}

	// 暴力解法
	public static int solution(String str1, String str2) {
		if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0) {
			return 0;
		}

		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();
		int max = 0;
		for (int i = 0; i < chars1.length; i++) {
			for (int j = 0; j < chars2.length; j++) {
				int index1 = i;
				int index2 = j;
				int count = 0;
				while (index1 < chars1.length && index2 < chars2.length && chars1[index1] == chars2[index2]) {
					count++;
					index1++;
					index2++;
				}
				max = Math.max(max, count);
			}
		}
		return max;
	}

}
