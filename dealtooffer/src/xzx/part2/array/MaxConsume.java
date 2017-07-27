package xzx.part2.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * ��Ŀ������һ����Ԫ���飨1,0,2�� ��һ������ǰ����ID���ڶ�������id������������ִ�п����������idΪ0�������ǰ�����Ǹ���
 * ���磨1,0,2������2,0,3������3,2,3������4,2,1�����ɻ�������ͼ���������������ͼ��
 * 
 * ��1,3,4�����̷ֱ�ΪҶ���ӽ�㣬Ҷ�ӽ�㿪���ǴӸ���㿪ʼ������;�ڵ㿪���ڼ���Ҷ�ӽڵ㿪���������Ҷ�ӽڵ㿪����ͼ����ʾ���Ҷ�ӽڵ㿪��Ϊ6��
 * @author xzx
 *
 */
public class MaxConsume {

	public static void main(String[] args) {
         int[] x = {1,2,3,4,5,6,7,8};
         int[] y = {0,0,2,2,3,3,4,4};
         int[] value = {2,3,3,1,1,2,3,4};
         int[][] to2dArr = to2DArr(x, y, value);
         //System.out.println("====��ά���鰡=====��"+Arrays.toString(to2dArr));
         for (int i = 0; i < to2dArr.length; i++) {
			for (int j = 0; j < to2dArr[0].length; j++) {
				System.out.print(to2dArr[i][j]);
			}
			System.out.println();
		}
         TreeSet<Integer> leafs = findLeaf(x, y);
         Iterator<Integer> it = leafs.iterator();
         System.out.print("====Ҷ�ӽڵ㰡===:");
         while(it.hasNext()){
        	 System.out.print(it.next());
         }
         System.out.println();
         System.out.println("=====ĳһ��Ŀ�����====="+findOneCon(to2dArr, 4));
         System.out.println("=====���Ŀ�����====="+findMaxCon(to2dArr,leafs));
         
	}
	
	//�ҵ����е�Ҷ�ӽڵ�
	public static TreeSet<Integer> findLeaf(int[] x,int[] y){
		Set<Integer> leafSet = new TreeSet<Integer>();
		for (int i = 0; i < x.length; i++) {
			boolean temp = true;
			for (int j = 0; j < y.length; j++) {
				if(x[i]==y[j]){
					temp=false;
					break;
				}
			}
			if(temp){
				leafSet.add(x[i]);
			}
		}
		return (TreeSet<Integer>) leafSet;
		
	}
	
	
	//ά��һ����ά���飬���������ݴ��ȥ�������кŶ�Ӧ�Լ�id���кŶ�Ӧ����id
	public static int[][] to2DArr(int[] x,int[] y,int[] value){
		int max_x = x[0];
		int max_y = y[0];
		for (int j = 0; j < value.length; j++) {
			if(x[j]>max_x){
				max_x = x[j];
			}
			if(y[j]>max_y){
				max_y = y[j];
			}
		}
		int[][] indexArr = new int[max_x+2][max_y+2];
		for (int k = 0; k < indexArr.length;k++) {
			for (int i = 0; i < indexArr[0].length; i++) {
				indexArr[k][i] = -1;
			}
		}
		
		for (int i = 0; i < x.length; i++) {
			indexArr[x[i]][y[i]] = value[i];
		}
		
		return indexArr;
	}
	//�ҵ������
	public static int findMaxCon(int[][] arr,TreeSet<Integer> leafSet){
		Set<Integer> resultSet = new TreeSet<Integer>();
		Iterator<Integer> it = leafSet.iterator();
		while(it.hasNext()){
			Integer leaf = it.next();
			System.out.println("hahha"+leaf);
			int sum = findOneCon(arr, leaf);
			resultSet.add(sum);
		}
		
		 Object[] array = resultSet.toArray();
		  return (int) array[array.length-1];
		
	}
	//�����ά����������ĳһ���ڵ�Ŀ���
	public static int findOneCon(int[][] arr,int index){
		int sum = 0;
		int  y= isNull(arr[index]);
		int x = index;
		while(y!=-1){
			sum+=arr[x][y];
			x=y;
			y=isNull(arr[x]);
		}
		
		return sum;
		
	}
	
	//�ж�һ�����Ƿ����ĳ����Ϊ-1������û�оͷ���-1���оͷ��ظ�������
	public static int isNull(int[] arr){
		int result = -1;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]!=-1){
				result = i;
			}
		}
		return result;
	}

}
