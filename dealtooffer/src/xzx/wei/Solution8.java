package xzx.wei;

/**
 *  给定整数m以及n各数字A1,A2,..An，将数列A中所有元素两两异或，共能得到n(n-1)/2个结果，请求出这些结果中大于m的有多少个。
 */
import java.util.Scanner;

public class Solution8 {
	public static void main(String[] args) {
		trieNode root = new trieNode(-1);// 根节点不存有效值
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] items = new int[n];
		for (int i = 0; i < n; i++) {
			items[i] = sc.nextInt();
			insert(root, items[i]);
		}
		long result = 0;
		for (int num : items) {
			result += query(root, num, m, 31);// 31到0是整数能表示的范围
		}
		System.out.println(result / 2);
	}

	/**
	 * 将number加入到root中
	 * 
	 * @param root
	 * @param number
	 */
	public static void insert(trieNode root, int number) {
		trieNode current = root;
		for (int i = 31; i >= 0; i--) {// 先存放高位数字比如数字5，二进制为0101，则存放顺序是0,1,0,1
			// 求解对应第i位置处二进制数字是0还是1
			int digit = (number >> i) & 1;
			if (current.next[digit] == null) {
				current.next[digit] = new trieNode(digit);
			}
			current = current.next[digit];
			current.count++;
		}
	}

	/**
	 * @param root//trieTree树
	 * @param a//a是做异或运算的其中的一个值
	 * @param m//和异或结果进行比较的数字，大于m记录值加1
	 * @param k//number转换为二进制后对应的第k位置上的数字
	 * @return
	 */
	public static int query(trieNode root, int a, int m, int k) {
		if (root == null) {
			return 0;
		}
		trieNode current = root;
		for (int i = k; i >= 0; i--) {
			int aDigit = (a >> i) & 1;
			int mDigit = (m >> i) & 1;
			if (aDigit == 1 && mDigit == 1) {
				if (current.next[0] == null) {// 对应k位置处的数字若为空，则返回0
					return 0;
				} else {
					current = current.next[0];// 返回第k位置为0的数字的个数
				}
			} else if (aDigit == 0 && mDigit == 1) {
				if (current.next[1] == null) {
					return 0;
				} else {
					current = current.next[1];
				}
			} else if (aDigit == 0 && mDigit == 0) {
				int p = query(current.next[0], a, m, i - 1);
				int q = (current.next[1] == null ? 0 : current.next[1].count);
				return p + q;
			} else if (aDigit == 1 && mDigit == 0) {
				int p = query(current.next[1], a, m, i - 1);
				int q = (current.next[0] == null ? 0 : current.next[0].count);
				return p + q;
			}
		}
		return 0;
	}
}

// 存放所有数字的二进制的形式的trie树
class trieNode {
	trieNode[] next = new trieNode[2];// 存放孩子结点，只有0和1两种数字
	int count = 0;// 此处包含的数字0或1的个数
	int digit = 0;

	public trieNode(int digit) {
		this.digit = digit;
	}
}