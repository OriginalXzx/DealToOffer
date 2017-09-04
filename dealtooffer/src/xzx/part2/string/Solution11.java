package xzx.part2.string;
/**
 * 将一句话的单词进行倒置，标点不倒置。比如 I like beijing. 经过函数后变为：beijing. like I
 * @author xzx
 *
 */
public class Solution11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//先整体翻转，再局部翻转
	public static void reverseWord(char[] chars){
		if(chars == null || chars.length==0){
			return;
		}
		reverse(chars,0,chars.length-1);
		//翻转单个单词
		int s = -1;
		int e = -1;
		for (int i = 0; i < chars.length; i++) {
			if(chars[i] != ' '){
				s = i ==0 || chars[i-1] ==' '?i : s;
				e = i == chars.length - 1 || chars[i+1] == ' '?i:e;
			}
			if(s != -1 && e != -1){
				reverse(chars, s, e);
				s = -1;
				e = -1;
			}
		}
		
	}
	
	//反转一个字符串
	public static void reverse(char[] chars,int start,int end){
		while(start < end){
			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;
			start ++;
			end --;
		}
	}

}
