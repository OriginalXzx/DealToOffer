package xzx.part2.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution implements Comparator<String>{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		String str = sc.nextLine();
		String[] strs = str.split(" ");
        System.out.println(maxString(strs));
	}

	@Override
	public int compare(String o1, String o2) {
		return (o2+o1).compareTo(o1+o2);
	}
	
	public static String maxString(String[] strs){
		if(strs==null||strs.length==0){
			return "";
		}
		
		Arrays.sort(strs,new Solution());
		String res = "";
		for (int i = 0; i < strs.length; i++) {
			res += strs[i];
		}
		return res;
	}

}
