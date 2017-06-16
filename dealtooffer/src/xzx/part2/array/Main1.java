package xzx.part2.array;

import java.util.Scanner;

/**
 * ������ n ���˲μӣ����� n Ϊ2���ݣ���ÿ�������߸����ʸ�����Ԥ���������ĳɼ������в�ͬ�Ļ��֡�������ȡ���������ƣ����ִν��У���ĳһ���� m
 * ���˲μӣ���ô�����߻ᱻ��Ϊ m/2 �飬ÿ��ǡ�� 2 �ˣ�m/2
 * ����˷ֱ���ɱ�����Ǽٶ����ָߵ��˿϶���ʤ��������һ���������������ʤ�ߡ���ʤ�߻�òμ���һ�ֵ��ʸ�����˱���̭���ظ�������̣�ֱ�������ھ���
 * 
 * �������ʣ�������С�������Ի�ڼ��֣���ʼΪ��0�֣��� ��������: ��һ��һ������ n (1��n�� 2^20)����ʾ�μӱ�������������
 * 
 * ������ n �����֣����ַ�Χ��-1000000��1000000������ʾÿ�������ߵĻ��֡�
 * 
 * С���ǵ�һ�������ߡ�
 * 
 * 
 * �������: С�����������ִΡ�
 * 
 * ��������: 4 4 1 2 3
 * 
 * �������: 2
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
