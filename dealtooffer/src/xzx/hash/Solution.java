package xzx.hash;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 给定一个英文字符串,请写一段代码找出这个字符串中首先出现三次的那个英文字符。
 * @author xzx
 *
 */
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();
		char c = solution(str);
		if(c=='0'){
			System.out.println();
		}else{
			System.out.println(c);
		}

	}
	
	public static char solution(String str){
		if(str==null||str.length()==0){
			return '0';
		}
		char[] chars = str.toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character,Integer>();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] >= 'a' && chars[i] <= 'z' || chars[i] >= 'A' && chars[i] <= 'Z') {
				if (!map.containsKey(chars[i])) {
					map.put(chars[i], 1);
				} else {
					int value = map.get(chars[i]);
					if (value >= 2) {
						System.out.println(map.toString());
						return chars[i];
					} else {
						map.put(chars[i], value + 1);
					}
				} 
			}
		}
		return '0';
	}

}
