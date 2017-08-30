package xzx.part2.array;


public class GetUglyNumber {

	static int GetUglyNumber_Solution(int index) {
		if (index < 7)
			return index;
		int[] res = new int[index];
		res[0] = 1;
		int t2 = 0, t3 = 0, t5 = 0, i;
		for (i = 1; i < index; ++i) {
			res[i] = Math.min(res[t2] * 2, Math.min(res[t3] * 3, res[t5] * 5));
			if (res[i] == res[t2] * 2)
				t2++;
			if (res[i] == res[t3] * 3)
				t3++;
			if (res[i] == res[t5] * 5)
				t5++;
		}
		return res[index - 1];
	}
    //第二种方法
	final int d[] = { 2, 3, 5 };

	public int GetUglyNumber_Solution2(int index) {
		if (index == 0)
			return 0;
		int a[] = new int[index];
		a[0] = 1;
		int p[] = new int[] { 0, 0, 0 };
		int num[] = new int[] { 2, 3, 5 };
		int cur = 1;

		while (cur < index) {
			int m = finMin(num[0], num[1], num[2]);
			if (a[cur - 1] < num[m])
				a[cur++] = num[m];
			p[m] += 1;
			num[m] = a[p[m]] * d[m];
		}
		return a[index - 1];
	}

	private int finMin(int num2, int num3, int num5) {
		int min = Math.min(num2, Math.min(num3, num5));
		return min == num2 ? 0 : min == num3 ? 1 : 2;
	}
	
	public static void main(String[] args) {
		System.out.println(GetUglyNumber_Solution(3));
	}
}
