package xzx.part2.string;

import java.util.Scanner;

/**
 * �������ʵı��밴�ֵ��������γ��������£�a, aa, aaa, aaaa, aaab, aaac, ..., b, ba, baa, baaa,
 * baab...yyyx, yyyy
 * 
 * ����a��������0��aa��������1��aaa��������2��aaaa��������3���Դ����ƣ�
 * 
 * 1������дһ������������������һ���Ϸ����ַ������������ַ�����Ӧ��������
 * 
 * 2������дһ������������������һ���Ϸ���������������������Ӧ���ַ�����
 * 
 * ˼·�� 1���۲�ͷ��������a-->0, aa->1, aaa->2��aaaa->3��Ӧ�ÿ��Կ�������������������ǣ��ַ������� - 1
 * 
 * 2����֪a����������b����������Ϊa��b֮�������������������ַ�����a���2�ַ��Ĵ���25����aa��ab��...ay����a���2�ַ��Ĵ���25*25��
 * (aaa,aab, ... ayy)��a�����3�ַ��Ĵ���25*25*25��(aaaa,aaab,...ayyy)��Ȼ�����b������b������ = a������ +
 * 25+25*25+25*25*25 + 1����1����Ϊb����a���м���ַ�֮��1��
 * 3����֪aa����������ab��������ͬ��ab������ = aa���� + 25 + 25* 25 + 1
 * 4����֪aaa����������aab��������ͬ��aab������ = aaa���� + 25 + 15����֪aaaa����������aaab������ = aaaa���� +1
 * 
 * ����aaaa��aaa��aa, a��������1: �ɹ���Ϊ �ַ������� - 1
 * ���ԣ�����һ��Ȩ����������ʾ������Ľ��ƣ�factor[4] = {1+25+25*25+25*25*25, 1+25+25*25, 1+25, 1}
 * 
 * Ȼ���ַ���string����������Ϊ��index(string) = (string.length - 1) + sum[ factor[i] *
 * (string[i] - 'a') , {i, 0, string.length-1 } ]
 * 
 * @author xzx
 *
 */
public class Solution9 {

	public static void main(String[] args) {
		/*Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(encode(str));*/
		int n = 16331;
		System.out.println(decode(n));

	}

	// 1������дһ������������������һ���Ϸ����ַ������������ַ�����Ӧ��������
	public static int encode(String str) {
		if (str.length() > 4) {
			return -1;
		}
		int len = 0;
		int index = 0;
		char[] chars = str.toCharArray();
		int[] factor = { 1 + 25 + 25 * 25 + 25 * 25 * 25, 1 + 25 + 25 * 25, 1 + 25, 1 };
		while (len < chars.length) {
			index += factor[len] * (chars[len++] - 'a');
		}
		return index + (len - 1);
	}
	//��дһ������������������һ���Ϸ���������������������Ӧ���ַ�����
	public static String decode(int index){
		int i = 0;
		String str = "";
		int[] factor = { 1 + 25 + 25 * 25 + 25 * 25 * 25, 1 + 25 + 25 * 25, 1 + 25, 1 };
		while(index >= 0){
			str += (char)('a' + index/factor[i]);
			index %= factor[i++];
			--index;
		}
		return str;
	} 

}
