package xzx.part2.array;

import java.util.Arrays;

/**
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣�
 * ���е�ż��λ��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
 * 
 * @author xzx
 *
 */
public class ReOrderArray {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8,11,6,8,2};
		reOrderArray(arr);
		System.out.println(Arrays.toString(arr));
	}

	// Ҫ����������������ż����ż��λ�ò��䣬Ӧ�������Ƚ�
	public static void reOrderArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if(!changeTurn(arr, i)){
				break;
			}
		}
	}

	// ��������������ǣ��Ѵ�ǰ�������������������λ��ż������������
	public static boolean changeTurn(int[] arr, int start) {
		if (arr == null || arr.length == 0) {
			return false;
		}
        boolean result = false;
		for (int i = start; i < arr.length; i++) {
			if ((arr[i] & 1) == 1) {
				result =true;
				int temp = arr[i];
				while (i >= start + 1) {
					int j = i-1;
					arr[i] = arr[j];
					System.out.println(arr[i]);
					i--;
				}
				arr[start] = temp;
				break;
			}
		}
		return result;
	}

}
