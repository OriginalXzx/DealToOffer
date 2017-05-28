package xzx.part2.math;

/**
 * ��������һ�ĸ���
 * 
 * @author xzx
 *
 */
public class NumberOf1 {

	public static void main(String[] args) {
        int n = 27;
        System.out.println("bug�ⷨ---"+NumberOf1(n));
        System.out.println("�����ⷨ---"+NumberOf2(n));
        System.out.println("����ⷨ----"+NumberOf3(n));
	}

	/**
	 * ����������ѭ���Ľⷨ ���nΪ�������Ϳ��ܽ�����ѭ��
	 * 
	 * @param n
	 * @return
	 */
	public static int NumberOf1(int n) {
		int count = 0;
		while (n > 0) {
			if ((n & 1) != 0) {
				count++;
			}
				n = n >> 1;
		}
		return count;
	}

	/**
	 * ����ⷨ����1һ��������λ������n����Ƚ�
	 * 
	 * @param n
	 * @return
	 */
	public static int NumberOf2(int n) {
		int count = 0;
		int flag = 1;
		while (flag >= 0) {
			if ((flag & n) != 0) {
				count++;
			}
			flag = flag << 1;
		}
		return count;
	}

	/**
	 * ����Ľⷨ
	 * n=(n-1) & n  ��ʾ���n���ұߵ�һ��1���0
	 * 
	 * @param n
	 * @return
	 */
	public static int NumberOf3(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n = (n-1) & n;
		}
		return count;
	}
}
