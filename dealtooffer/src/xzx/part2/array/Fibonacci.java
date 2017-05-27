package xzx.part2.array;
/**
 * 쳲��������е����Žⷨ
 * @author xzx
 *
 */
public class Fibonacci {

	public static void main(String[] args) {
         int n = 2;
         //System.out.println(Fibonacci1(n));
         System.out.println(Fibonacci2(n));
	}
    
	/**
	 *һ��ⷨ 
	 *�����ص�Ч�����⣬�ظ��Ľ��Ƚ϶�
	 */
	public static long Fibonacci1(int n){
		if(n<=0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		return Fibonacci1(n-1) + Fibonacci1(n-2);
	}
	
	/**
	 * �Ϻýⷨ1
	 * ���������������
	 */
	public static long Fibonacci2(int n){
		int[] result = {0,1};
		if(n < 2 ){
			return result[n];
		}
		long[] fibonacci = new long[n+1];
		fibonacci[0] = 0;
		fibonacci[1] = 1;
		for (int i = 2; i < fibonacci.length; i++) {
			fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
		}
		return fibonacci[n];
		
	}
	
}




