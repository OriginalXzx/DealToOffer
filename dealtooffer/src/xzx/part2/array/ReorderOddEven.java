package xzx.part2.array;

import java.util.Arrays;

/**
 * 调整数组顺序是奇数位于偶数前面
 * @author xzx
 *
 */
public class ReorderOddEven {

	public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        reorderOddEven1(arr, 6);
        System.out.println(Arrays.toString(arr));
	}
	/**
	 * 只完成基本功能的解法，仅适合初级程序员
	 * 可以把逻辑框架抽象出来，把判断标准改成一个函数指针，可以把整个函数解耦成两部分，一是判断数字应该在数组前半部分还是后半部分的标准，而是拆分数组的操作！
	 */
	public static void reorderOddEven1(int[] data,int length){
		if(data == null || length == 0){
			return;
		}
		
		int begin = 0;
		int end = length-1;
		
		while(begin < end){
			//向后移动begin，直到它指到偶数
			while(begin < end && (data[begin] & 0x1)!=0){
				begin ++;
			}
			//向前移动end，直到它指向奇数
			while(begin < end && (data[end] & 0x1) == 0){
				end --;
			}
			if(begin < end){
				int temp = data[begin];
				data[begin] = data[end];
				data[end] = temp;
			}
		}
	}

}
