package xzx.part2.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReplaceNull {

	public static void main(String[] args) throws IOException {
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
       StringBuffer buffer = new StringBuffer(br.readLine());
       System.out.println(replaceNull(buffer));
	}
	public static String replaceNull(StringBuffer str ){
		char[] charArr = str.toString().toCharArray();
		int length = charArr.length;
		
		if(charArr==null||length==0){
			return null;
		}
		//计算替换后字符串的长度
		int numberOfnull = 0;
		int i = 0;
		while(i<length){
			if(charArr[i]==' '){
				numberOfnull++;
			}
			i++;
		}
		//替换后的字符串的长度
		int newLength = length + numberOfnull*2;
		char[] newChar = new char[newLength];
		int indexOforigin = length-1;
		int indexOfnew = newLength-1;
		while(indexOforigin>=0&&indexOfnew>=indexOforigin){
			if(charArr[indexOforigin] == ' '){
				newChar[indexOfnew--] = '0';
				newChar[indexOfnew--] = '2';
				newChar[indexOfnew--] = '%';
			}else{
				newChar[indexOfnew--] = charArr[indexOforigin];
			}
			--indexOforigin;
		}
		StringBuffer buffer = new StringBuffer();
		for (char c : newChar) {
			buffer.append(c);
		}
        return buffer.toString();
	}
}
