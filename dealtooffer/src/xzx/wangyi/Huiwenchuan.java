package xzx.wangyi;

import java.util.Scanner;

/**
 * ���ڸ���һ���������У�����ʹ��һ��ת�������� ѡ�������������ڵ�����Ȼ��������Ƴ������������������������ֵĺͲ��뵽��������֮ǰ��λ��(ֻ����һ����)��
 * ���ڶ�����������Ҫ���������Ҫ���ٴβ������Խ����ɻ������С�
 * 
 * @author xzx
 *
 */
public class Huiwenchuan {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		if (n > 0) {
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(countChange(arr, 0, arr.length-1));
			
		}else{
			return;
		}
		sc.close();
	}
	
	public static int countChange(int[] arr,int begin,int end){
		if(arr==null||arr.length==0||arr.length==1){
			return 0;
		}
		int count = 0;
		int i = begin;
		int j = end;
		while(i<j){
			System.out.println("i:"+i+"j:"+j+"arr[i]:"+arr[i]+"arr[j]"+arr[j]);
			if(arr[i] == arr[j]){
				if(j-i==1){
					return count;
				}
				i++;
				j--;
			}else if(arr[i]>arr[j]){
				arr[j-1] = arr[j]+arr[j-1];
				count++;
				j--;
			}else{
				arr[i+1]= arr[i]+arr[i+1];
				count++;
				i++;
			}
		}
		
		return count;
		
	}

}
