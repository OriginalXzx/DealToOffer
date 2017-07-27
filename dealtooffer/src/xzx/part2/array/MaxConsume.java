package xzx.part2.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 题目：给定一个三元数组（1,0,2） 第一个代表当前进程ID，第二个代表父id，第三个代表执行开销，如果父id为0；则代表当前进程是根，
 * 例如（1,0,2），（2,0,3），（3,2,3），（4,2,1），可画出如下图，括号里面代表开销图；
 * 
 * （1,3,4）进程分别为叶子子结点，叶子结点开销是从根结点开始加上沿途节点开销在加上叶子节点开销，求最大叶子节点开销，图中所示最大叶子节点开销为6；
 * @author xzx
 *
 */
public class MaxConsume {

	public static void main(String[] args) {
         int[] x = {1,2,3,4,5,6,7,8};
         int[] y = {0,0,2,2,3,3,4,4};
         int[] value = {2,3,3,1,1,2,3,4};
         int[][] to2dArr = to2DArr(x, y, value);
         //System.out.println("====二维数组啊=====："+Arrays.toString(to2dArr));
         for (int i = 0; i < to2dArr.length; i++) {
			for (int j = 0; j < to2dArr[0].length; j++) {
				System.out.print(to2dArr[i][j]);
			}
			System.out.println();
		}
         TreeSet<Integer> leafs = findLeaf(x, y);
         Iterator<Integer> it = leafs.iterator();
         System.out.print("====叶子节点啊===:");
         while(it.hasNext()){
        	 System.out.print(it.next());
         }
         System.out.println();
         System.out.println("=====某一点的开销啊====="+findOneCon(to2dArr, 4));
         System.out.println("=====最大的开销啊====="+findMaxCon(to2dArr,leafs));
         
	}
	
	//找到所有的叶子节点
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
	
	
	//维护一个二维数组，把所有数据存进去，其中行号对应自己id，列号对应父亲id
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
	//找到最大开销
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
	//求出二维数组中其中某一个节点的开销
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
	
	//判断一行中是否存在某个不为-1的数，没有就返回-1，有就返回该数索引
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
