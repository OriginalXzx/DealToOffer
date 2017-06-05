package xzx.part2.array;
/**
 * ��ӡ1������nλ��
 * @author xzx
 *
 */
public class Print1ToMaxOfNDigits {

	public static void main(String[] args) {
         int n = 3;
         printToMax2(n);//û�п���n�ܴ�ܴ�����
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
    /**
     * �����⻻������ȫ���еĽⷨ���ַ�����һ���򵥵ģ���Ч�ı�ʾ�����ķ���
     * @param n
     */
	public static void printToMax2(int n){
		if(n <= 0){
			return;
		}
		char[] number = new char[n];
		for(int i = 0;i < 10; i++){
			number[0] = (char) (i + '0');
			print1ToMax(number,n,0);
		}
		
	}
	private static void print1ToMax(char[] number, int n, int i) {
		if(i == n-1){
			printNumber(number);
			return;
		}
		for(int j = 0;j<10;j++){
			number[i+1] = (char) (j+'0');
			print1ToMax(number, n, i+1);
		}
	}
	private static void printNumber(char[] number) {
		boolean isBeginning0 = true;
		int nlength = number.length;
		for (int i = 0; i < nlength; i++) {
			if(isBeginning0 && number[i] != '0'){
				isBeginning0 = false;
			}
			if(!isBeginning0){
				System.out.print(number[i]);
			}
		}
		System.out.println();
	}
}
