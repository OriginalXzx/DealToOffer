package xzx.part2.array;
/**
 * ��ӡ1������nλ��
 * @author xzx
 *
 */
public class Print1ToMaxOfNDigits {

	public static void main(String[] args) {
         int n = 2;
         printToMax1(n);//û�п���n�ܴ�ܴ�����
	}
	/**
	 * ��������������Ľⷨ���ܲ���,û�п��Ǵ���������
	 * @param n
	 */
	public static void printToMax1(int n){
		int number = 1;
		int i = 0;
		while(i++ < n){
			number *= 10;
		}
		for (int j = 1; j<number; j++) {
			System.out.print(j+" ");
		}
	}

}
