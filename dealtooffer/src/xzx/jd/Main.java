package xzx.jd;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 给你两个集合，要求{A} + {B}。 注：同一个集合中不会有两个相同的元素
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
