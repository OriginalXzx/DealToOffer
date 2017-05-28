package xzx.part2.math;

/**
 * 二进制中一的个数
 * 
 * @author xzx
 *
 */
public class NumberOf1 {

	public static void main(String[] args) {
        int n = 27;
        System.out.println("bug解法---"+NumberOf1(n));
        System.out.println("正常解法---"+NumberOf2(n));
        System.out.println("优秀解法----"+NumberOf3(n));
	}

	/**
	 * 可能引起死循环的解法 如果n为负数，就可能进入死循环
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
	 * 常规解法，把1一次向左移位，再与n做与比较
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
	 * 不错的解法
	 * n=(n-1) & n  表示会把n最右边的一个1变成0
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
