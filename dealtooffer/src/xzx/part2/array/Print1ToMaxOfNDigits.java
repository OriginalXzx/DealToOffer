package xzx.part2.array;
/**
 * 打印1到最大的n位数
 * @author xzx
 *
 */
public class Print1ToMaxOfNDigits {

	public static void main(String[] args) {
         int n = 2;
         printToMax1(n);//没有考虑n很大很大的情况
	}
	/**
	 * 最容易跳进陷阱的解法，很不好,没有考虑大数的问题
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
