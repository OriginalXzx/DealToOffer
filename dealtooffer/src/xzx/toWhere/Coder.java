package xzx.toWhere;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Coder {
	public String[] findCoder(String[] A, int n) {
		ArrayList<Recorder> result = new ArrayList<Recorder>();
		for (int i = 0; i < n; i++) {
			String a = A[i].toLowerCase(); // 转小写
			if (a.contains("coder")) {
				int count = 0;
				int start = 0;
				// 遍历a查找"coder"
				while (a.indexOf("coder", start) >= 0 && start < a.length()-4) {
					count++;
					start = a.indexOf("coder", start) + "coder".length();
				}
				result.add(new Recorder(A[i], i, count));
			}
		}

		// 使用Collections提供的对List的归并排序
		// 需实现其Comparator接口参数
		Collections.sort(result, new Comparator<Recorder>() {
			@Override
			public int compare(Recorder o1, Recorder o2) {
				// 先比"coder"个数, count大者排前面
				if (o1.getCount() != o2.getCount())
					return o2.getCount() - o1.getCount();
				// 再比index, index小者排前面
				else
					return o1.getIndex() - o2.getIndex();
			}
		});
		String sorted[] = new String[result.size()];
		for (int i = 0; i < result.size(); i++) {
			String s = result.get(i).getData();
			sorted[i] = s;
		}
		return sorted;
	}

	class Recorder {
		private String data; // 字符串
		private int index; // 在原数组中的位置
		private int count; // 含有多少个coder-1

		public Recorder(String data, int index, int count) {
			this.data = data;
			this.index = index;
			this.count = count;
		}

		public String getData() {
			return data;
		}

		public int getIndex() {
			return index;
		}

		public int getCount() {
			return count;
		}
	}
}