package xzx.part2.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 * 思想就是数组元素转换成字符串，然后排序，小的在前，大的在后
 * @author xzx
 *
 */
public class MaxNumberLength {
	public String PrintMinNumber(int[] numbers) {
		if(numbers==null||numbers.length==0){
			return "";
		}
        StringBuffer result = new StringBuffer();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < numbers.length; i++) {
			list.add(numbers[i]);
		}
        Collections.sort(list,new Comparator<Integer>() {//排序字符串

			@Override
			public int compare(Integer o1, Integer o2) {
				String s1 = o1+""+o2;
				String s2 = o2+""+o1;
				return s1.compareTo(s2);
			}
        });
        for (Integer i : list) {
			result.append(i);
		}
		return result.toString();
	}
}
