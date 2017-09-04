package xzx.part2.string;
/**
 * ��һ�仰�ĵ��ʽ��е��ã���㲻���á����� I like beijing. �����������Ϊ��beijing. like I
 * @author xzx
 *
 */
public class Solution11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//�����巭ת���پֲ���ת
	public static void reverseWord(char[] chars){
		if(chars == null || chars.length==0){
			return;
		}
		reverse(chars,0,chars.length-1);
		//��ת��������
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
	
	//��תһ���ַ���
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
