package xzx.dongtaiguihua;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ����һ����n��������������A��һ������sum,��ѡ������A�в������ֺ�Ϊsum�ķ�������
 * ������ѡȡ������һ�����ֵ��±겻һ��,���Ǿ���Ϊ�ǲ�ͬ����ɷ�����
 * 
 * ���Բ��û��ݷ�,���ǻᳬʱ
 * 
 * @author xzx
 *
 */
public class Solution4 {

	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		solution(arr, 0, m);
		System.out.println(count);

	}

	public static void solution(int[] arr, int index, int m) {
		
		if (arr == null || arr.length == 0) {
			return;
		}
		if (m == 0) {
			count++;
		} else {
			for (int i = index; i < arr.length&&arr[i] <= m; i++) {
				if (arr[i] > m) {
					break;
				}
			
				solution(arr, i + 1, m - arr[i]);
				
				System.out.println("m: "+m+"i:"+i+"count"+count);
			}
		}

	}

}
