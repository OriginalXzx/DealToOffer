package xzx.part2.string;

import java.util.Scanner;

/**
 * �봴��һ���������Ӹ���·������ȡ�ļ�����չ����������ȡ���ļ�����չ����NULL�����û�У���
 * @author xzx
 *
 */
public class Solution4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String fileUrl = sc.nextLine();
		sc.close();
		int indexOfdian = fileUrl.lastIndexOf(".");
		if(indexOfdian != -1){
			System.out.println(fileUrl.substring(indexOfdian+1));
		}else{
			System.out.println("null");
		}
	}

}
