package xzx.part2.array;

import java.util.Scanner;

public class Solution5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		//char[] chars = str.toCharArray();
        //solution(chars);
		solution2(str);
	}
	
	public static void solution(char[] chars){
		if(chars==null||chars.length==0){
			return ;
		}
		int[] count = new int[chars.length];
		for (int i = 0; i < chars.length; i++) {
			if('0'<=chars[i]&&chars[i]<='9'){
				count[i] = 1;
				int temp = i+1;
				while(temp<chars.length&&chars[temp]==(chars[temp-1]+1)&&'0'<=chars[temp]&&chars[temp]<='9'){
					//System.out.println("temp: "+temp);
					count[i]++;
					temp ++;
				}
				i = temp-1;
			}
		}
	    int max = count[0];
	    for (int i : count) {
			if(max<i){
				max = i;
			}
		}
	    int index = 0;
	    for (int i = 0; i < count.length; i++) {
			if(count[i]==max){
				index = i;
				break;
			}
		}
	    for (int i = index; i < index + max; i++) {
			System.out.print(chars[i]);
		}
	}
	/**
	 * 这个有点问题，只能匹配连续最长的数字字符串
	 * @param str
	 */
	public static void solution2(String str){
		String[] strs = str.split("\\D+");
		String result = "";
		for (int i = 0; i < strs.length; i++) {
			if(strs[i].length()>result.length()){
				result = strs[i];
			}
			
		}
		System.out.println(result);
	} 
	
/*
		//正则匹配
		public class Main {
		    public static void main(String[] args) {
		        Scanner s = new Scanner(System.in);
		        String str = s.nextLine();
		        String[] strs = str.split("\\D+");
		        String result = "";
		        for(int i=0;i<strs.length;i++){
		            if(strs[i].length()>result.length())
		                result = strs[i];
		        }
		             
		        System.out.println(result);
		    }
		}
*/
}
