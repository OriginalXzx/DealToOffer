package xzx.part2.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * ����һ��Ǹ�������ɵ�����h������һ����״ͼ�ĸ߶ȣ�����ÿ�����ӵĿ�ȶ�Ϊ1�� ��������״ͼ���ҵ�����ɵ������ε��������ͼ��ʾ����
 * ���hΪһ���������飬����ÿ�����ӵĸ߶ȣ����������ֵ��
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
			Iterator<Integer> it2 = indexs.iterator();//��ʾԭ�����и߶�Ϊtemp������
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
	
	//���������ҵ�ĳ��Ԫ�ص�����
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
