package xzx.part2.array;

import java.util.Scanner;

/**
 * 比赛有 n 个人参加（其中 n 为2的幂），每个参赛者根据资格赛和预赛、复赛的成绩，会有不同的积分。比赛采取锦标赛赛制，分轮次进行，设某一轮有 m
 * 个人参加，那么参赛者会被分为 m/2 组，每组恰好 2 人，m/2
 * 组的人分别厮杀。我们假定积分高的人肯定获胜，若积分一样，则随机产生获胜者。获胜者获得参加下一轮的资格，输的人被淘汰。重复这个过程，直至决出冠军。
 * 
 * 现在请问，参赛者小美最多可以活到第几轮（初始为第0轮）？ 输入描述: 第一行一个整数 n (1≤n≤ 2^20)，表示参加比赛的总人数。
 * 
 * 接下来 n 个数字（数字范围：-1000000…1000000），表示每个参赛者的积分。
 * 
 * 小美是第一个参赛者。
 * 
 * 
 * 输出描述: 小美最多参赛的轮次。
 * 
 * 输入例子: 4 4 1 2 3
 * 
 * 输出例子: 2
 * 
 * @author xzx
 *
 */
public class Main1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		int[] arr = new int[number];
		for (int i = 0; i < number; i++) {
			arr[i] = scanner.nextInt();
		}
		scanner.close();
		System.out.println(findMaxsort(arr, arr.length));
	}

	public static int findMaxsort(int[] arr, int n) {
		if (n == 1) {
			return 0;
		}
		int a1 = arr[0];
		int count1 = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] <= arr[0]) {
				count1++;
			}
		}
		// Math.log(1000*10000) / Math.log(2)
		int count2 = 0;
		while (count1 >> 1 > 0) {
			count2++;
			count1 = count1 >> 1;
		}
		return count2;
	}

}
