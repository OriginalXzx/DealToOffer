package xzx.jd;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * �����������ϣ�Ҫ��{A} + {B}�� ע��ͬһ�������в�����������ͬ��Ԫ��
 * @author xzx
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		if(n1==0&&n2==0){
			return;
		}
		TreeSet<Integer> set = new TreeSet<Integer>();
		
        for (int i = 0; i < n1+n2; i++) {
			set.add(sc.nextInt());
		}
        StringBuffer sb = new StringBuffer();
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
        	sb.append(iterator.next()+" ");
        }
        int lastIndex = sb.length()-1;
        sb.deleteCharAt(lastIndex);
        System.out.print(sb);
        
	}
	
	

}
