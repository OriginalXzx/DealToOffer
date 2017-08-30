package xzx.toWhere;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Coder {
	public String[] findCoder(String[] A, int n) {
		ArrayList<Recorder> result = new ArrayList<Recorder>();
		for (int i = 0; i < n; i++) {
			String a = A[i].toLowerCase(); // תСд
			if (a.contains("coder")) {
				int count = 0;
				int start = 0;
				// ����a����"coder"
				while (a.indexOf("coder", start) >= 0 && start < a.length()-4) {
					count++;
					start = a.indexOf("coder", start) + "coder".length();
				}
				result.add(new Recorder(A[i], i, count));
			}
		}

		// ʹ��Collections�ṩ�Ķ�List�Ĺ鲢����
		// ��ʵ����Comparator�ӿڲ���
		Collections.sort(result, new Comparator<Recorder>() {
			@Override
			public int compare(Recorder o1, Recorder o2) {
				// �ȱ�"coder"����, count������ǰ��
				if (o1.getCount() != o2.getCount())
					return o2.getCount() - o1.getCount();
				// �ٱ�index, indexС����ǰ��
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
		private String data; // �ַ���
		private int index; // ��ԭ�����е�λ��
		private int count; // ���ж��ٸ�coder-1

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