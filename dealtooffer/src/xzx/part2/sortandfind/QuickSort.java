package xzx.part2.sortandfind;

import java.util.Arrays;
import java.util.Random;

/**
 * ¿ìËÙÅÅĞò
 * @author xzx
 *
 */
public class QuickSort {
    
	public static void quickSort(int[] arr,int start,int end){
		if(start >= end){
			return;
		}
		int index = arr[start];
		int i,j;
		i = start;
		j = end;
		while(i<j){
			while(i<j&&arr[j]>index){
				j--;
			}
			if(i<j){
				arr[i] = arr[j];
				i++;
			}
			while(i<j&&arr[i]<index){
				i++;
			}
			if(i<j){
				arr[j] = arr[i];
				j--;
			}
		}
	    arr[i] = index;
	    quickSort(arr, start, i-1);
	    quickSort(arr, i+1, end);
	}
	
	
	
	public static void main(String[] args) {
       int[] arr = {3,1,2,5,4,7};
       quickSort(arr, 0, arr.length-1);
       System.out.println(Arrays.toString(arr));
	}

}
