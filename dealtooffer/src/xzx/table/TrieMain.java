package xzx.table;

import java.util.ArrayList;
import java.util.List;

/**
 * 单词查找树
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
		/** 单词查找树根节点，根节点为一个空的节点 */
		private Vertex root = new Vertex();

		/** 单词查找树的节点(内部类) */
		private class Vertex {
			/** 单词出现次数统计 */
			int wordCount;
			/** 以某个前缀开头的单词，它的出现次数 */
			int prefixCount;
			/** 子节点用数组表示 */
			Vertex[] vertexs = new Vertex[26];

			/**
			 * 树节点的构造函数
			 */
			public Vertex() {
				wordCount = 0;
				prefixCount = 0;
			}
		}

	/**
	 * 单词查找树构造函数
	 */
	public Trie() {

	}

		/**
		 * 向单词查找树添加一个新单词
		 * 
		 * @param word
		 *            单词
		 */
		public void addWord(String word) {
			addWord(root, word.toLowerCase());
		}

		/**
		 * 向单词查找树添加一个新单词
		 * 
		 * @param root
		 *            单词查找树节点
		 * @param word
		 *            单词
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
		 * 统计某个单词出现次数
		 * 
		 * @param word
		 *            单词
		 * @return 出现次数
		 */
		public int countWord(String word) {
			return countWord(root, word);
		}

		/**
		 * 统计某个单词出现次数
		 * 
		 * @param root
		 *            单词查找树节点
		 * @param word
		 *            单词
		 * @return 出现次数
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
		 * 统计以某个前缀开始的单词，它的出现次数
		 * 
		 * @param word
		 *            前缀
		 * @return 出现次数
		 */
		public int countPrefix(String word) {
			return countPrefix(root, word);
		}

		/**
		 * 统计以某个前缀开始的单词，它的出现次数(前缀本身不算在内)
		 * 
		 * @param root
		 *            单词查找树节点
		 * @param word
		 *            前缀
		 * @return 出现次数
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
		 * 调用深度递归算法得到所有单词
		 * 
		 * @return 单词集合
		 */
		public List<String> listAllWords() {
			List<String> allWords = new ArrayList<String>();
			return depthSearchWords(allWords, root, "");
		}

		/**
		 * 递归生成所有单词
		 * 
		 * @param allWords
		 *            单词集合
		 * @param vertex
		 *            单词查找树的节点
		 * @param wordSegment
		 *            单词片段
		 * @return 单词集合
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
