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
	/**
	 * �ж�һ�����ǲ�����һ�������ӽṹ
	 * �ݹ�ʵ��
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
	/**
	 * ����һ��������С���
	 * @param args
	 */
	 public int minDepth(TreeNode root) {
		    if(root!=null){
		        int left=Integer.MAX_VALUE;
		        int right=Integer.MAX_VALUE;
		        if(root.leftChild!=null){
		            left=minDepth(root.leftChild);
		        }
		        if(root.rightChild!=null){
		            right=minDepth(root.rightChild);
		        }
		        if(left<right){
		            return left+1;
		        }
		        else if(left>right){
		            return right+1;
		        }
		        else if(left==right&&left!=Integer.MAX_VALUE){
		            return left+1;
		        }
		        else{
		            return 1;
		        }
		        
		    }
		     return 0;   
		    }
	 /**
	  * �����������
	  * @return
	  */
	 public void MirrorRecursively(TreeNode pNode){
		if(pNode == null){
			return;
		}
		if(pNode.leftChild==null&&pNode.rightChild==null){
			return;
		}
		TreeNode pTemp = pNode.leftChild;
		pNode.leftChild = pNode.rightChild;
		pNode.rightChild = pTemp;
		 
		if(pNode.leftChild.leftChild!=null){
			MirrorRecursively(pNode.leftChild);
		}
		 
		if(pNode.rightChild.rightChild!=null){
			MirrorRecursively(pNode.rightChild);
		}
		 
	 }
	 /**
	  * �ж�һ�������ǲ���ĳ�������������ĺ������
	  * @param args
	  */
	 public static boolean isBelongBST(int[] sequence,int length){
		if(sequence==null || length==0){
			return false;
		}
		int root = sequence[length-1];
		int i = 0;
		for (; i < length - 1; i++) {
			if(sequence[i] > root){
				break;
			}
		}
		int j = i;
		for(;j<length-1;j++){
			if(sequence[j]<root){
				return false;
			}
		}
		
		//�ж��������ǲ��Ƕ���������
		boolean left = true;
		if(i > 0){
			left = isBelongBST(sequence, i);
		}
		boolean right = true;
		if(i<length-1){
			int[] rightSequence = Arrays.copyOf(sequence, i);
			right = isBelongBST(rightSequence, rightSequence.length);
		}
		 return (left&&right);
		 
	 }

	public static void main(String[] args) {
		/*Scanner sc = new Scanner(System.in);
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
		levelTraverse(createByPreAndMidOrder(pre, mid, n));*/
		
		//����isBeLongBST
		int[] arr = {5,7,6,9,11,10,8};
		System.out.println(isBelongBST(arr, 7));
		
	}

}
