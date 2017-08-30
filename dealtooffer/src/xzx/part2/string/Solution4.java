package xzx.part2.string;

import java.util.Scanner;

/**
 * 请创建一个函数来从给定路径中提取文件名扩展名，返回提取的文件名扩展名或NULL（如果没有）。
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
