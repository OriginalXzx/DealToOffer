package xzx.wei;

import java.util.Scanner;

/**
 * �������ʻ��ļ��ڣ�ˮ�ɻ��������������˵Ĵ�����ѧ���и�ˮ�ɻ�����������������ģ�
 * ��ˮ�ɻ�������ָһ����λ�������ĸ�λ���ֵ������͵����䱾�����磺153=1^3+5^3+3^3�� ����Ҫ�����������m��n��Χ�ڵ�ˮ�ɻ�����
 * 
 * @author xzx
 *
 */
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean bl = false;
		StringBuffer sb = new StringBuffer();
		for (int i = n; i <= m; i++) {
			if(isF(i)){
				sb.append(i+" ");
				bl = true;
			}
		}
		if(!bl){
			System.out.println("no");
		}else{
			sb.deleteCharAt(sb.length()-1);
			System.out.println(sb);
		}

	}
	/**
	 * �ж�n�ǲ���ˮ�ɻ���
	 * @param n
	 * @return
	 */
	public static boolean isF(int n){
		if(n==0){
			return true;
		}
		int de = n;
		int temp = 0;
		while(n>0){
			int r = n%10;
			temp += r*r*r;
			//System.out.println("n: "+n+"r: "+r+"temp: "+temp);
			n = n/10;
		}
		if(temp==de){
			return true;
		}else{
			return false;
		}
	}

}
