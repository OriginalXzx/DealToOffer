package xzx.part2.string;

/**
 * 给定一个句子（只包含字母和空格）， 将句子中的单词位置反转，单词用空格分割, 
 * 单词之间只有一个空格，前后没有空格。 比如： （1） “hello xiao mi”-> “mi xiao hello”
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

	// 先整体转换一次，然后对单个单词转换
	public static void totatlWord(char[] chas) {
		// 1.整体反转
		reverse(chas, 0, chas.length - 1);
		// 反转单个单词
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
