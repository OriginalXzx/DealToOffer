package xzx.part2.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ��MIUI8�Ƴ��ֻ�������֮��MIUI9�ƻ��Ƴ�һ���绰�������Ĺ��ܣ����Ƚ��绰�����е�ÿ�����ּ���8ȡ��λ��Ȼ��ʹ�ö�Ӧ�Ĵ�д��ĸ����
 * ��"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT",
 * "NINE"���� Ȼ�����������Щ��ĸ�������ɵ��ַ�����Ϊ�绰�����Ӧ�ķ���
 * 
 * @author xzx
 *
 */
public class Solution2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String[] strs = new String[n];
		for (int i = 0; i < strs.length; i++) {
			strs[i] = sc.nextLine();
		}
		for (int i = 0; i < strs.length; i++) {
			// System.out.println(solution(strs[i]));
			handle(strs[i]);
		}

	}

	public static String solution(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}
		char[] chars = str.toCharArray();
		ArrayList<Character> list = new ArrayList<Character>();
		for (int i = 0; i < chars.length; i++) {
			list.add(chars[i]);
		}
		String result = "";
		String[] strs = { "EIGHT", "NINE", "ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SECEN" };
		for (int i = 0; i < strs.length; i++) {
			int count = isInclude(list, strs[i]);
			if (count > 0) {
				while (count > 0) {
					result += i;
					count--;
				}
			}

		}
		return result;
	}

	/**
	 * �ж�strList���Ƿ����str2��ȫ���ַ�����������ж��м���str2���������������Ƴ���Ӧ�ַ����������������0��
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static int isInclude(List<Character> strList, String str2) {
		if (strList == null || strList.size() == 0) {
			return -1;
		}

		char[] chars = str2.toCharArray();
		int count = 0;
		while (!strList.isEmpty()) {
			boolean bl = true;
			for (int i = 0; i < chars.length; i++) {
				if (!strList.contains(chars[i])) {
					bl = false;
					break;
				}
			}
			if (bl) {
				count++;
				for (int i = 0; i < chars.length; i++) {
					strList.remove(strList.indexOf(chars[i]));
				}
			} else {
				break;
			}
		}
		return count;
	}

	// ˼·��,�ȴ��������ַ���Ҳ����ÿ�����ʶ��е��ַ�������������û�е�
	/**
	 * Ҫ�����ν�����ж�һ�޶��ַ������֣����������ص������������ֱ���FOUR(U),SIX(X),
	 * TWO(W),EIGHT(G),ZERO(Z),���Ը��ݶ����ַ��ĸ���ֱ���ж��ж��ٸ���Ӧ�����֣�������
	 * 3��U��ô��һ����3��FOUR...,����������������֮�����������Ҳ��������Щ���ֵ��Ƴ�
	 * �������˶�һ�޶����ַ���������������FIVE(F)��THREE(T),FIVE�ҵ�֮��ֻ��SEVEN��
	 * ��V,�����ֿ�������V�ַ��ĸ�������SEVEN�ĸ��������ʣ�µ�ONE��NINEҲ�������Լ���
	 * ��־���ַ��ֱ���ONE(O),NINE(I)����Ҫע�����ԭʼ���ֺ����ճ��ֵ����ֻ���һ��ת��
	 * �Ĺ��̣���8ȡ��λ���������Ի�Ҫ��Ӧת����ȥ�����Ҫע����ǣ�Ҫ��ÿ���ַ�����Ӧ��
	 * ����ǰ����С�绰���룬��Ҫɵɵ�İ����ֵ�����������ʱ�临�Ӷȹ��ߣ������������
	 * ������Ͱ����10��bucket�ֱ�����ͳ��0-9���ֵĴ���������Ͱ�д洢�Ľ������������� �����������С�����֡�
	 * 
	 * @param str
	 */
	public static void handle(String str) {
		str = str.toLowerCase();
		int[] hash = new int[10];
		StringBuffer sb = new StringBuffer(str);
		while (sb.toString().contains("z")) {// zero
			// 2
			hash[2]++;
			sb.deleteCharAt(sb.indexOf("z"));
			sb.deleteCharAt(sb.indexOf("e"));
			sb.deleteCharAt(sb.indexOf("r"));
			sb.deleteCharAt(sb.indexOf("o"));
		}
		while (sb.toString().contains("x")) {// six
			hash[8]++;
			sb.deleteCharAt(sb.indexOf("s"));
			sb.deleteCharAt(sb.indexOf("i"));
			sb.deleteCharAt(sb.indexOf("x"));
		}
		while (sb.toString().contains("s")) {// seven
			hash[9]++;
			sb.deleteCharAt(sb.indexOf("s"));
			sb.deleteCharAt(sb.indexOf("e"));
			sb.deleteCharAt(sb.indexOf("v"));
			sb.deleteCharAt(sb.indexOf("e"));
			sb.deleteCharAt(sb.indexOf("n"));
		}
		while (sb.toString().contains("u")) {// four
			hash[6]++;
			sb.deleteCharAt(sb.indexOf("f"));
			sb.deleteCharAt(sb.indexOf("o"));
			sb.deleteCharAt(sb.indexOf("u"));
			sb.deleteCharAt(sb.indexOf("r"));
		}
		while (sb.toString().contains("f")) {// five
			hash[7]++;
			sb.deleteCharAt(sb.indexOf("f"));
			sb.deleteCharAt(sb.indexOf("i"));
			sb.deleteCharAt(sb.indexOf("v"));
			sb.deleteCharAt(sb.indexOf("e"));
		}
		while (sb.toString().contains("g")) {// eight
			hash[0]++;
			sb.deleteCharAt(sb.indexOf("e"));
			sb.deleteCharAt(sb.indexOf("i"));
			sb.deleteCharAt(sb.indexOf("g"));
			sb.deleteCharAt(sb.indexOf("h"));
			sb.deleteCharAt(sb.indexOf("t"));
		}
		while (sb.toString().contains("w")) {// two
			hash[4]++;
			sb.deleteCharAt(sb.indexOf("t"));
			sb.deleteCharAt(sb.indexOf("w"));
			sb.deleteCharAt(sb.indexOf("o"));
		}
		while (sb.toString().contains("h") && !sb.toString().contains("g")) {// three
			hash[5]++;
			sb.deleteCharAt(sb.indexOf("t"));
			sb.deleteCharAt(sb.indexOf("h"));
			sb.deleteCharAt(sb.indexOf("r"));
			sb.deleteCharAt(sb.indexOf("e"));
			sb.deleteCharAt(sb.indexOf("e"));
		}
		while (sb.toString().contains("o") && !sb.toString().contains("z")) {// one
			hash[3]++;
			sb.deleteCharAt(sb.indexOf("o"));
			sb.deleteCharAt(sb.indexOf("n"));
			sb.deleteCharAt(sb.indexOf("e"));
		}
		while (sb.toString().contains("n")) {// nine
			hash[1]++;
			sb.deleteCharAt(sb.indexOf("n"));
			sb.deleteCharAt(sb.indexOf("i"));
			sb.deleteCharAt(sb.indexOf("n"));
			sb.deleteCharAt(sb.indexOf("e"));
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 1; j <= hash[i]; j++) {
				System.out.print(i);
			}
		}
		System.out.println();
	}
}
