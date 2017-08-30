package xzx.wei;

/**
 * 一只袋鼠要从河这边跳到河对岸，河很宽，但是河中间打了很多桩子，每隔一米就有一个，
 * 每个桩子上都有一个弹簧，袋鼠跳到弹簧上就可以跳的更远。每个弹簧力量不同，用一个数字代表它的力量，
 * 如果弹簧力量为5，就代表袋鼠下一跳最多能够跳5米，如果为0，就会陷进去无法继续跳跃。
 * 河流一共N米宽，袋鼠初始位置就在第一个弹簧上面，要跳到最后一个弹簧之后就算过河了，给定每个弹簧的力量，求袋鼠最少需要多少跳能够到达对岸。
 * 如果无法到达输出-1
 * 
 * @author xzx
 *
 */

import java.util.Scanner;

public class Solution3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scan.nextInt();
		}
		int Fmin[] = new int[n + 1];
		Fmin[0] = 0;
		for (int i = 1; i < n + 1; i++) {
			Fmin[i] = 10000;
			if (i != n && a[i] == 0)
				continue;
			for (int j = 0; j < i; j++) {
				if (a[j] != 0 && a[j] >= i - j && Fmin[j] < Fmin[i] - 1) {
					Fmin[i] = Fmin[j] + 1;
				}
			}
		}
		if (Fmin[n] == 10000)
			System.out.println(-1);
		else
			System.out.println(Fmin[n]);
	}

}
