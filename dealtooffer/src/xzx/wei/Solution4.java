package xzx.wei;

/**
 * �Ƶ귿��ļ۸�¼����ͨ��ʱ�����¼��ģ�����10��1����10��7��800Ԫ��10��8����10��20��500Ԫ��
 * ��ʵ�����º���int[][] merge(int[][] dateRangePrices)��������ĳ���Ƶ������ڶεļ۸�
 * ÿ�����ڶΣ���ֹ���ڴ��ڵ�����ʼ���ڣ��Ͷ�Ӧ�ļ۸�ʹ�ó���Ϊ3����������ʾ��
 * ����[0,19, 300], [10, 40,250]�ֱ��ʾ��ĳ�쿪ʼ��1�쵽��20��۸���300��
 * ��11�쵽��41��۸���250����Щ���ڶ��п����ظ����ظ������ڵļ۸��Ժ����Ϊ׼��
 * �������¹���ϲ�������ϲ������ 
 * 1.��������ļ۸������ͬ����ô���������ڶ�Ӧ�úϲ� 
 * 2.�ϲ��Ľ��Ӧ������ʼ���ڴ�С��������
 * 
 * @author xzx
 *
 */

import java.util.*;

public class Solution4 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNextInt()) {
			int[] price = new int[10001];

			int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
			while (cin.hasNextInt()) {
				int b = cin.nextInt(), e = cin.nextInt(), p = cin.nextInt();
				for (int i = b; i <= e; ++i) {
					price[i] = p;
				}
				if (b < min) {
					min = b;
				}
				if (e > max) {
					max = e;
				}
			}

			System.out.print("[" + min + ", ");
			for (int i = min + 1, pre = price[min]; i < max; ++i) {
				int cur = price[i];
				// �Ƚ�ǰһ�����ǰ��ļ۸������һ����˵������һ�����ֵ�
				if (cur != pre) {
					// ǰһ���㲻Ϊ0��˵��ǰһ������һ���ұ�����
					if (pre != 0) {
						System.out.print(i - 1 + ", " + pre + "],");
					}
					// ��ǰ�㲻Ϊ0��˵����ǰ����һ���������
					if (cur != 0) {
						System.out.print("[" + i + ", ");
					}
				}
				pre = cur;
			}
			System.out.println(max + ", " + price[max] + "]");
		}
	}
}
