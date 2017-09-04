package xzx.part2.string;

import java.util.Scanner;

public class Solution10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		/*if(str2.length()==0||str2==null){
			System.out.println(str1);
		}
		if(str1==null || str1.length()==0){
			return;
		}
		StringBuffer sb = new StringBuffer(str1);
		char[] chars = str2.toCharArray();
		for (char c : chars) {
			deleteChar(sb, c);
		}
		System.out.println(sb.toString());*/
		System.out.println(deleteCommon(str1, str2));
		
		
	}
	
	public static void deleteChar(StringBuffer sb,char c){
	       while(sb.indexOf(c+"")!=-1){
	    	   sb.deleteCharAt(sb.indexOf(c+""));
	       }
	}
	
	//方法二：正则表达式
	public static String deleteCommon(String str1,String str2){
		String pattern = "[" + str2 + "]";
		String result = str1.replaceAll(pattern, "");
		return result;
	}
	
	

}
