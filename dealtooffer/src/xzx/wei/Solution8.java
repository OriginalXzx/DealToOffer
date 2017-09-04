package xzx.wei;

/**
 *  ��������m�Լ�n������A1,A2,..An��������A������Ԫ��������򣬹��ܵõ�n(n-1)/2��������������Щ����д���m���ж��ٸ���
 */
import java.util.Scanner;

public class Solution8 {
	public static void main(String[] args) {
		trieNode root = new trieNode(-1);// ���ڵ㲻����Чֵ
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
			result += query(root, num, m, 31);// 31��0�������ܱ�ʾ�ķ�Χ
		}
		System.out.println(result / 2);
	}

	/**
	 * ��number���뵽root��
	 * 
	 * @param root
	 * @param number
	 */
	public static void insert(trieNode root, int number) {
		trieNode current = root;
		for (int i = 31; i >= 0; i--) {// �ȴ�Ÿ�λ���ֱ�������5��������Ϊ0101������˳����0,1,0,1
			// ����Ӧ��iλ�ô�������������0����1
			int digit = (number >> i) & 1;
			if (current.next[digit] == null) {
				current.next[digit] = new trieNode(digit);
			}
			current = current.next[digit];
			current.count++;
		}
	}

	/**
	 * @param root//trieTree��
	 * @param a//a���������������е�һ��ֵ
	 * @param m//����������бȽϵ����֣�����m��¼ֵ��1
	 * @param k//numberת��Ϊ�����ƺ��Ӧ�ĵ�kλ���ϵ�����
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
				if (current.next[0] == null) {// ��Ӧkλ�ô���������Ϊ�գ��򷵻�0
					return 0;
				} else {
					current = current.next[0];// ���ص�kλ��Ϊ0�����ֵĸ���
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

// ����������ֵĶ����Ƶ���ʽ��trie��
class trieNode {
	trieNode[] next = new trieNode[2];// ��ź��ӽ�㣬ֻ��0��1��������
	int count = 0;// �˴�����������0��1�ĸ���
	int digit = 0;

	public trieNode(int digit) {
		this.digit = digit;
	}
}