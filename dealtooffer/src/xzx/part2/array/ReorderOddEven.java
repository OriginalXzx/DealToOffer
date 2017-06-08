package xzx.part2.array;

import java.util.Arrays;

/**
 * ��������˳��������λ��ż��ǰ��
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
	 * ֻ��ɻ������ܵĽⷨ�����ʺϳ�������Ա
	 * ���԰��߼���ܳ�����������жϱ�׼�ĳ�һ������ָ�룬���԰�������������������֣�һ���ж�����Ӧ��������ǰ�벿�ֻ��Ǻ�벿�ֵı�׼�����ǲ������Ĳ�����
	 */
	public static void reorderOddEven1(int[] data,int length){
		if(data == null || length == 0){
			return;
		}
		
		int begin = 0;
		int end = length-1;
		
		while(begin < end){
			//����ƶ�begin��ֱ����ָ��ż��
			while(begin < end && (data[begin] & 0x1)!=0){
				begin ++;
			}
			//��ǰ�ƶ�end��ֱ����ָ������
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
