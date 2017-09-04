package xzx.part2.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 给定一组非负整数组成的数组h，代表一组柱状图的高度，其中每个柱子的宽度都为1。 在这组柱状图中找到能组成的最大矩形的面积（如图所示）。
 * 入参h为一个整型数组，代表每个柱子的高度，返回面积的值。
 * 
 * @author xzx
 *
 */
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int[] high = new int[n];
		for (int i = 0; i < high.length; i++) {
			high[i] = sc.nextInt();
		}
		System.out.println(solution(high));

	}
	public static Comparator<Long> compartor = new Comparator<Long>() {
		
		@Override
		public int compare(Long o1, Long o2) {
			return (int) (o2 - o1);
		}
	};
	
	public static long solution(int[] high){
		if(high==null || high.length==0){
			return 0;
		}
		PriorityQueue<Long> pq = new PriorityQueue<Long>(11,compartor);
		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int i = 0; i < high.length; i++) {
			set.add(high[i]);
		}
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()){
			int temp = it.next();
			List<Integer> indexs = findIndex(high, temp);
			Iterator<Integer> it2 = indexs.iterator();//表示原数组中高度为temp的索引
			while(it2.hasNext()){
				int index = it2.next();
				int pre = index-1;
				int last = index+1;
				while(pre>=0){
					if(high[pre]>=high[index]){
						pre--;
					}else{
						break;
					}
				}
				while(last<=high.length-1){
					if(high[last]>=high[index]){
						last++;
					}else{
						break;
					}
				}
				int difx = last - pre -1;
				pq.add((long) (difx*temp));
			}
		}
		return pq.poll();
	}
	
	//从数组中找到某个元素的索引
	public static List<Integer> findIndex(int[] arr,int k){
		ArrayList<Integer> list = new ArrayList<Integer>();
	    for (int i = 0; i < arr.length; i++) {
			if(arr[i]==k){
				list.add(i);
			}
		}
	    return list;
	} 
	
}
