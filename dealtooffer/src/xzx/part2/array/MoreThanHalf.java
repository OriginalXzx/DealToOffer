package xzx.part2.array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 
 * @author xzx
 *
 */
public class MoreThanHalf {
       
	/**
	 * 解法一，基于hashMap
	 * @param array
	 * @return
	 */
	public static int moreThanHalf(int[] array){
		if(array==null||array.length == 0){
			return 0;
		}
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	    for (int i = 0; i < array.length; i++) {
			if(!map.containsKey(array[i])){
				map.put(array[i], 1);
			}else{
				int count = map.get(array[i]);
				map.put(array[i], count+1);
			}
		}	
		
	    int result = 0;
		Iterator<Entry<Integer, Integer>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<Integer, Integer> next = iterator.next();
			Integer key = next.getKey();
			Integer val = next.getValue();
			System.out.println("key:"+key+" value:"+val);
			if(val>array.length/2){
				result = key;
			}
		}
	    return result;
		
	}
	/**
	 * 解法二基于快速排序
	 * @param args
	 */
	
	public  static int moreThanHalf2(int[] array){
		int start = 0;
		int end = array.length-1;
		int mid = array.length>>1;// /2
		int index = partition(array,start,end);
		if(index!=mid){
			if(index>mid){
				index = partition(array, start, index-1);
			}else{
				index = partition(array, index+1, end);
			}
			
		}
		int result = array[mid];
		System.out.println(result);
		int times = 0;
		for (int i = 0; i < array.length; i++) {
			if(array[i] == result){
				times++;
			}
		}
		if(times*2<array.length){
			System.out.println("最大的次数啊"+times);
			return 0 ;
		}else{
			return result;
		}
		
	}
	
	public static int partition(int[] arr,int start,int end){
		int temp = (arr[start]+arr[end])/2;
		System.out.println("temp"+temp);
		while(start < end){
			while(arr[end]>temp){
				end--;
			}
			if(start<end){
				swap(arr,start,end);
				start++;
			}
			while(arr[start]<temp){
				start++;
			}
			if(start<end){
				swap(arr,start,end);
				end--;
				
			}
		}
		return start;
	}
	
	public static void swap(int[] arr,int a,int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static int moreThanHalf3(int[] arr){
		if(arr==null||arr.length==0){
			return 0;
		}
		int[] temp = new int[2];
		temp[0] = arr[0];
		temp[1] = 1;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i]!=temp[0]){
				if(temp[1]>0){
					temp[1]--;
				}else{
					temp[0] = arr[i];
					temp[1] = 1;
				}
			}else{
				temp[1]++;
			}
		}
		
		int result = temp[0];
		System.out.println(result);
		int times = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == result){
				times++;
			}
		}
		if(times*2<arr.length){
			System.out.println("最大的次数啊"+times);
			return 0 ;
		}else{
			return result;
		}
		
		
	}
	
	public static void main(String[] args) {
		int[] arr = {1,3,3,2,2,2,3,3,3};
		//System.out.println(moreThanHalf(arr));
		System.out.println(moreThanHalf3(arr));
	}
	
	
}
