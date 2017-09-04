package xzx.part2.string;
/**
 * ��������Ӵ�
 * ˼·��
	׼��һ��N+1 * N+1��С�Ķ�ά����dp����0��
	dp[i][j]����s1��0-iλ����s2��0-jλ�������������Ӵ�����󳤶ȡ�
	���У�
	    ���s1[i] == s2[j]��dp[i][j] = dp[i-1][j-1] + 1;
	    ����dp[i][j] = 0;
	��¼��󳤶ȼ��ɡ�
 */
import java.util.Scanner;

public class Solution5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		System.out.println(solution(str1, str2));

	}

	// �����ⷨ
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
