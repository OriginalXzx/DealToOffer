package xzx.part2.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 重建二叉树，知道前序和中序，重建二叉树
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

	// 中序遍历递归打印
	public static void printTreeByMidOrder(TreeNode node) {
		if (node != null) {
			printTreeByMidOrder(node.leftChild);
			System.out.print(node.value + " ");
			printTreeByMidOrder(node.rightChild);
		}
	}

	// 后序遍历打印
	public static void printTreeByLastOrder(TreeNode node) {
		if (node != null) {
			printTreeByLastOrder(node.leftChild);
			printTreeByLastOrder(node.rightChild);
			System.out.print(node.value + " ");
		}
	}
    //按层次打印
	public static void levelTraverse(TreeNode TreeNode) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(TreeNode);// 从根节点入队列
		while (!queue.isEmpty()) {// 在队列为空前反复迭代
			TreeNode bitNode = queue.poll();// 取出队列首节点
			System.out.print(bitNode.value + " ");
			if (bitNode.leftChild != null)
				queue.offer(bitNode.leftChild);// 左孩子入列
			if (bitNode.rightChild != null)
				queue.offer(bitNode.rightChild);// 右孩子入列
		}
	}
	/**
	 * 判断一棵树是不是另一棵树的子结构
	 * 递归实现
	 * @param tree1
	 * @param tree2
	 * @return
	 */
	public boolean HasSubtree(TreeNode tree1,TreeNode tree2){
		boolean result = false;
		if(tree1!=null && tree2!=null){
			if(tree1.value == tree2.value){
				result = doesTreeHaveTree(tree1,tree2);
			}
			if(!result){
				result = doesTreeHaveTree(tree1.leftChild,tree2);
			}
			if(!result){
				result = doesTreeHaveTree(tree1.rightChild,tree2);
			}
		}
		return result;
	}

	private boolean doesTreeHaveTree(TreeNode tree1, TreeNode tree2) {
		if(tree2 ==null){
			return true;
		}
		if(tree1 == null){
			return false;
		}
		
		return doesTreeHaveTree(tree1.leftChild, tree2.leftChild) &&
				doesTreeHaveTree(tree1.rightChild, tree2.rightChild);
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
		System.out.println("-------后序遍历打印----------");
		printTreeByLastOrder(createByPreAndMidOrder(pre, mid, n));
		System.out.println();
		System.out.println("-------	按层次遍历打印----------");
		levelTraverse(createByPreAndMidOrder(pre, mid, n));
		
	}

}
