package xzx.table;

import java.util.ArrayList;
import java.util.List;

/**
 * ���ʲ�����
 * 
 * @author xzx
 * @since 2017-09-02
 */
public class TrieMain {
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.addWord("abc");
		trie.addWord("abcd");
		trie.addWord("abcde");
		trie.addWord("abcdef");
		System.out.println(trie.countPrefix("abc"));
		System.out.println(trie.countWord("abc"));
		System.out.println(trie.listAllWords());
	}

	static class Trie {
		/** ���ʲ��������ڵ㣬���ڵ�Ϊһ���յĽڵ� */
		private Vertex root = new Vertex();

		/** ���ʲ������Ľڵ�(�ڲ���) */
		private class Vertex {
			/** ���ʳ��ִ���ͳ�� */
			int wordCount;
			/** ��ĳ��ǰ׺��ͷ�ĵ��ʣ����ĳ��ִ��� */
			int prefixCount;
			/** �ӽڵ��������ʾ */
			Vertex[] vertexs = new Vertex[26];

			/**
			 * ���ڵ�Ĺ��캯��
			 */
			public Vertex() {
				wordCount = 0;
				prefixCount = 0;
			}
		}

	/**
	 * ���ʲ��������캯��
	 */
	public Trie() {

	}

		/**
		 * �򵥴ʲ��������һ���µ���
		 * 
		 * @param word
		 *            ����
		 */
		public void addWord(String word) {
			addWord(root, word.toLowerCase());
		}

		/**
		 * �򵥴ʲ��������һ���µ���
		 * 
		 * @param root
		 *            ���ʲ������ڵ�
		 * @param word
		 *            ����
		 */
		private void addWord(Vertex vertex, String word) {
			if (word.length() == 0) {
				vertex.wordCount++;
			} else if (word.length() > 0) {
				vertex.prefixCount++;
				char c = word.charAt(0);
				int index = c - 'a';
				if (null == vertex.vertexs[index]) {
					vertex.vertexs[index] = new Vertex();
				}
				addWord(vertex.vertexs[index], word.substring(1));
			}
		}

		/**
		 * ͳ��ĳ�����ʳ��ִ���
		 * 
		 * @param word
		 *            ����
		 * @return ���ִ���
		 */
		public int countWord(String word) {
			return countWord(root, word);
		}

		/**
		 * ͳ��ĳ�����ʳ��ִ���
		 * 
		 * @param root
		 *            ���ʲ������ڵ�
		 * @param word
		 *            ����
		 * @return ���ִ���
		 */
		private int countWord(Vertex vertex, String word) {
			if (word.length() == 0) {
				return vertex.wordCount;
			} else {
				char c = word.charAt(0);
				int index = c - 'a';
				if (null == vertex.vertexs[index]) {
					return 0;
				} else {
					return countWord(vertex.vertexs[index], word.substring(1));
				}
			}
		}

		/**
		 * ͳ����ĳ��ǰ׺��ʼ�ĵ��ʣ����ĳ��ִ���
		 * 
		 * @param word
		 *            ǰ׺
		 * @return ���ִ���
		 */
		public int countPrefix(String word) {
			return countPrefix(root, word);
		}

		/**
		 * ͳ����ĳ��ǰ׺��ʼ�ĵ��ʣ����ĳ��ִ���(ǰ׺����������)
		 * 
		 * @param root
		 *            ���ʲ������ڵ�
		 * @param word
		 *            ǰ׺
		 * @return ���ִ���
		 */
		private int countPrefix(Vertex vertex, String prefixSegment) {
			if (prefixSegment.length() == 0) {
				return vertex.prefixCount;
			} else {
				char c = prefixSegment.charAt(0);
				int index = c - 'a';
				if (null == vertex.vertexs[index]) {
					return 0;
				} else {
					return countPrefix(vertex.vertexs[index], prefixSegment.substring(1));
				}
			}
		}

		/**
		 * ������ȵݹ��㷨�õ����е���
		 * 
		 * @return ���ʼ���
		 */
		public List<String> listAllWords() {
			List<String> allWords = new ArrayList<String>();
			return depthSearchWords(allWords, root, "");
		}

		/**
		 * �ݹ��������е���
		 * 
		 * @param allWords
		 *            ���ʼ���
		 * @param vertex
		 *            ���ʲ������Ľڵ�
		 * @param wordSegment
		 *            ����Ƭ��
		 * @return ���ʼ���
		 */
		private List<String> depthSearchWords(List<String> allWords, Vertex vertex, String wordSegment) {
			Vertex[] vertexs = vertex.vertexs;
			for (int i = 0; i < vertexs.length; i++) {
				if (null != vertexs[i]) {
					if (vertexs[i].wordCount > 0) {
						allWords.add(wordSegment + (char) (i + 'a'));
						if (vertexs[i].prefixCount > 0) {
							depthSearchWords(allWords, vertexs[i], wordSegment + (char) (i + 'a'));
						}
					} else {
						depthSearchWords(allWords, vertexs[i], wordSegment + (char) (i + 'a'));
					}
				}
			}
			return allWords;
		}
	}
}
