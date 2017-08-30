package xzx.part2.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * ����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����������������{3��32��321}��
 * ���ӡ���������������ųɵ���С����Ϊ321323��
 * ˼���������Ԫ��ת�����ַ�����Ȼ������С����ǰ������ں�
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
        Collections.sort(list,new Comparator<Integer>() {//�����ַ���

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
