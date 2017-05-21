package xzx.part2.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * �ؽ���������֪��ǰ��������ؽ�������
 * 
 * @author xzx
 *
 */
public class BinaryTreeNode {

	public static class TreeNode {
		private int value;
		private TreeNode leftChild;
		private TreeNode rightChild;

		public TreeNode() {

		}
	}

	public static TreeNode createByPreAndMidOrder(int[] pre, int[] mid, int n) {
		if (n == 0 || pre == null || mid == null) {
			return null;
		}
		TreeNode treeNode = new TreeNode();
		int c = pre[0];
		treeNode.value = c;
		int i = 0;
		for (i = 0; i < n && mid[i] != c; i++) {
		}
		int lengthL = i;
		int lengthR = n - i - 1;
		// System.out.println(i);
		if (lengthL > 0) {

			int[] pre1 = Arrays.copyOfRange(pre, 1, lengthL + 1);
			int[] mid1 = Arrays.copyOfRange(mid, 0, lengthL);
			/*
			 * System.out.println(Arrays.toString(pre1));
			 * System.out.println(Arrays.toString(mid1));
			 */
			treeNode.leftChild = createByPreAndMidOrder(pre1, mid1, lengthL);
		}

		if (lengthR > 0) {
			int[] pre2 = Arrays.copyOfRange(pre, lengthL + 1, pre.length);
			int[] mid2 = Arrays.copyOfRange(mid, lengthL + 1, mid.length);
			/*
			 * System.out.println(Arrays.toString(pre2));
			 * System.out.println(Arrays.toString(mid2));
			 */
			treeNode.rightChild = createByPreAndMidOrder(pre2, mid2, lengthR);
		}
		return treeNode;

	}

	// ��������ݹ��ӡ
	public static void printTreeByMidOrder(TreeNode node) {
		if (node != null) {
			printTreeByMidOrder(node.leftChild);
			System.out.print(node.value + " ");
			printTreeByMidOrder(node.rightChild);
		}
	}

	// ���������ӡ
	public static void printTreeByLastOrder(TreeNode node) {
		if (node != null) {
			printTreeByLastOrder(node.leftChild);
			printTreeByLastOrder(node.rightChild);
			System.out.print(node.value + " ");
		}
	}
    //����δ�ӡ
	public static void levelTraverse(TreeNode TreeNode) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(TreeNode);// �Ӹ��ڵ������
		while (!queue.isEmpty()) {// �ڶ���Ϊ��ǰ��������
			TreeNode bitNode = queue.poll();// ȡ�������׽ڵ�
			System.out.print(bitNode.value + " ");
			if (bitNode.leftChild != null)
				queue.offer(bitNode.leftChild);// ��������
			if (bitNode.rightChild != null)
				queue.offer(bitNode.rightChild);// �Һ�������
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] pre = new int[n];
		int[] mid = new int[n];
		for (int i = 0; i < n; i++) {
			pre[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			mid[i] = sc.nextInt();
		}
		System.out.println(Arrays.toString(pre));
		System.out.println(Arrays.toString(mid));
		System.out.println("-------���������ӡ----------");
		printTreeByLastOrder(createByPreAndMidOrder(pre, mid, n));
		System.out.println();
		System.out.println("-------	����α�����ӡ----------");
		levelTraverse(createByPreAndMidOrder(pre, mid, n));
		
	}

}