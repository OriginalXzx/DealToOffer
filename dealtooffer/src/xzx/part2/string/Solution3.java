package xzx.part2.string;
/**
	 * 8λ���֤�ı�������ǣ�
	ǰ1��2λ���ֱ�ʾ������ʡ��ֱϽ�С����������Ĵ���
	��3��4λ���ֱ�ʾ�����ڵؼ��У������ݣ��Ĵ���
	��5��6λ���ֱ�ʾ�����������ء������ء��ؼ��У��Ĵ��룻
	��7��14λ���ֱ�ʾ�������ꡢ�¡��գ�
	��15��16λ���ֱ�ʾ�����ڵص��ɳ����Ĵ��룻
	��17λ���ֱ�ʾ�Ա�������ʾ���ԣ�ż����ʾŮ�ԣ�
	��18λ������У���룬�����������֤����ȷ�ԡ�
	�û����������֤�Ĺ����о������������Ϊ�˷����û���ȷ������Ҫ����������ж��û������밴�� 6+8+4 �ĸ�ʽ���з��飬
	ʵ��һ������������������е����֤�ţ����ط������ַ�
 */

import java.util.Scanner;

public class Solution3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String input = sc.nextLine();
			if (input.length() <= 6) {
				System.out.println(input);
			} else {
				if (input.length() > 6 && input.length() <= 14) {
					System.out.println(input.substring(0, 6) + " " + input.substring(6, input.length()));
				} else {
					System.out.println(input.substring(0, 6) + " " + input.substring(6, 14) + " "
							+ input.substring(14, input.length()));
				}
			}
		}
		sc.close();
	}
}