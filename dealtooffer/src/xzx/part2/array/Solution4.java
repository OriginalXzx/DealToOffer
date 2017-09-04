package xzx.part2.array;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 找出n个数里最小的k个
 * @author xzx
 *
 */
public class Solution4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String result = solution(str);
		System.out.println(result);

	}
	
	public static String solution(String str){
		if(str==null||str.length()==0){
			return null;
		}
		String[] strs = str.split(" ");
		//System.out.println(Arrays.toString(strs));
		int[] arr = new int[strs.length-1];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		//System.out.println(Arrays.toString(arr));
		int k =Integer.parseInt(strs[strs.length-1]);
		if(k>arr.length){
			return null;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i : arr) {
			pq.add(i);
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < k; i++) {
			sb.append(pq.poll()+" ");
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}

}
