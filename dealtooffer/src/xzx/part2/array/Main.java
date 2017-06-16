package xzx.part2.array;

import java.util.Scanner;

/**
 * ����������Ʒ�ƴ����˴�������������ڽ��������о�������������Ƶ��ÿ����Ƶ��һ����ʾ���ߵ����С����ڴ���������Ҫ�ڵڶ�����Ƶ���ҳ����һ����Ƶ������Ĳ��֡�
 * 
 * �����˵�������ڵڶ�����Ƶ���ҵ�һ�����Ⱥ͵�һ����Ƶ������������������У�ʹ�����ǵ� difference ��С�����εȳ���Ƶ�� difference
 * ����Ϊ�� difference = SUM(a[i] - b[i])2 (1 �� i �� n),����SUM()��ʾ��� ���� n ��ʾ���г��ȣ�a[i],
 * b[i]�ֱ��ʾ������Ƶ�����ߡ����ڴ���������Ҫ֪����difference����Сֵ�Ƕ��٣����ݱ�֤��һ����Ƶ�ĳ���С�ڵ��ڵڶ�����Ƶ�ĳ��ȡ�
 * 
 * ��������: ��һ��һ������n(1 �� n �� 1000)����ʾ��һ����Ƶ�ĳ��ȡ� �ڶ���n��������ʾ��һ����Ƶ�����ߣ�0 �� ���� �� 1000����
 * ������һ������m(1
 * 
 * @author xzx
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr1Length = sc.nextInt();
		int[] arr1 = null;
		if (arr1Length > 0 && arr1Length <= 1000) {
			arr1 = new int[arr1Length];
			for (int i = 0; i < arr1Length; i++) {
				arr1[i] = sc.nextInt();
			}
		} else {
			System.out.println(0);
			return;
		}
		int arr2Length = sc.nextInt();
		int[] arr2 = null;
		if (arr2Length > 0 && arr2Length <= 1000) {
			arr2 = new int[arr2Length];
			for (int j = 0; j < arr2.length; j++) {
				arr2[j] = sc.nextInt();
			}
		} else {
			System.out.println(-1);
			return;
		}
		System.out.println(minDifference(arr1, arr2));
	}

	public static int minDifference(int[] arr1, int[] arr2) {
		if (arr1 == null && arr1.length == 0) {
			return 0;
		}
		if (arr2 == null && arr2.length == 0) {
			return -1;
		}
		int arr1Length = arr1.length;
		int arr2Length = arr2.length;
		int[] difference = new int[arr2Length - arr1Length + 1];
		int i = 0;
		while (i < arr2Length - arr1Length + 1) {
			if (difference(arr1, arr2, 0, i, arr1.length) == 0) {
				return 0;
			} else {
				difference[i] = difference(arr1, arr2, 0, i, arr1.length);
			}
			i++;
		}
		int minDifference = difference[0];
		;
		for (int j = 0; j < difference.length; j++) {
			if (difference[j] < minDifference) {
				minDifference = difference[j];
			}
		}
		return minDifference;

	}

	/**
	 * ������������dfference
	 * 
	 * @param arr1
	 * @param arr2
	 * @param beginIndex1
	 * @param beginIndex2
	 * @param n
	 * @return
	 */
	public static int difference(int[] arr1, int[] arr2, int beginIndex1, int beginIndex2, int n) {
		int sum = 0;
		if (arr1 == null) {
			return 0;
		}
		if (arr2 == null) {
			return -1;
		}
		int i = beginIndex1;
		int j = beginIndex2;
		for (; i < n + beginIndex1 && j < beginIndex2 + n; i++, j++) {
			sum += (arr1[i] - arr2[j]) * (arr1[i] - arr2[j]);
		}
		return sum;

	}

}
