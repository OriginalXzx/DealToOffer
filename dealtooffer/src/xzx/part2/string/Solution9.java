package xzx.part2.string;

import java.util.Scanner;

/**
 * 如果将五笔的编码按字典序排序，形成数组如下：a, aa, aaa, aaaa, aaab, aaac, ..., b, ba, baa, baaa,
 * baab...yyyx, yyyy
 * 
 * 其中a的索引是0，aa的索引是1，aaa的索引是2，aaaa的索引是3，以此类推：
 * 
 * 1）、编写一个函数，输入是任意一个合法的字符串，输出这个字符串对应的索引；
 * 
 * 2）、编写一个函数，输入是任意一个合法的索引，输出这个索引对应的字符串。
 * 
 * 思路： 1、观察头几个串：a-->0, aa->1, aaa->2，aaaa->3：应该可以看出来，这里的索引就是：字符串长度 - 1
 * 
 * 2、已知a的索引，求b的索引：因为a到b之间隔了以下四种情况的字符串：a后跟2字符的串有25个（aa，ab，...ay），a后跟2字符的串有25*25个
 * (aaa,aab, ... ayy)，a后面跟3字符的串有25*25*25个(aaaa,aaab,...ayyy)，然后才是b，所以b的索引 = a的索引 +
 * 25+25*25+25*25*25 + 1，加1是因为b排在a和中间的字符之后1个
 * 3、已知aa的索引，求ab的索引：同理，ab的索引 = aa索引 + 25 + 25* 25 + 1
 * 4、已知aaa的索引，求aab的索引：同理，aab的索引 = aaa索引 + 25 + 15、已知aaaa的索引，求aaab的索引 = aaaa索引 +1
 * 
 * 至于aaaa，aaa，aa, a的索引由1: 可归纳为 字符串长度 - 1
 * 所以：可用一个权重数组来表示修正后的进制：factor[4] = {1+25+25*25+25*25*25, 1+25+25*25, 1+25, 1}
 * 
 * 然后字符串string的索引函数为：index(string) = (string.length - 1) + sum[ factor[i] *
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

	// 1）、编写一个函数，输入是任意一个合法的字符串，输出这个字符串对应的索引；
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
	//编写一个函数，输入是任意一个合法的索引，输出这个索引对应的字符串。
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
