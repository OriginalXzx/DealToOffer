package xzx.part2.string;

/**
 * ����һ�����ӣ�ֻ������ĸ�Ϳո񣩣� �������еĵ���λ�÷�ת�������ÿո�ָ�, 
 * ����֮��ֻ��һ���ո�ǰ��û�пո� ���磺 ��1�� ��hello xiao mi��-> ��mi xiao hello��
 */
import java.util.Scanner;

public class Solution1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] chars = str.toCharArray();
		totatlWord(chars);
		for (int i = 0; i < chars.length; i++) {
			System.out.print(chars[i]);
		}
	}

	// ������ת��һ�Σ�Ȼ��Ե�������ת��
	public static void totatlWord(char[] chas) {
		// 1.���巴ת
		reverse(chas, 0, chas.length - 1);
		// ��ת��������
		int l = -1;
		int r = -1;
		for (int i = 0; i < chas.length; i++) {
			if (chas[i] != ' ') {
				l = i == 0 || chas[i - 1] == ' ' ? i : l;
				r = i == chas.length - 1 || chas[i + 1] == ' ' ? i : r;
			}
			if (l != -1 && r != -1) {
				reverse(chas, l, r);
				l = -1;
				r = -1;
			}
		}
	}

	public static void reverse(char[] chars, int start, int end) {
		if (chars == null || chars.length == 0) {
			return;
		}
		char temp = 0;
		while (start < end) {
			temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;
			start++;
			end--;
		}

	}

}
