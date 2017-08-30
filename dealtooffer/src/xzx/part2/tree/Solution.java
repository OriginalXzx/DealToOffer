package xzx.part2.tree;

/**
 * 把二叉树打印成多行
 * @author xzx
 *
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Solution {
	
	public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	
    static ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        if(pRoot == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer> > allList = new ArrayList<ArrayList<Integer> >();
        TreeNode last = pRoot;
        TreeNode nlast = null;
        ArrayList<Integer> list= new ArrayList<Integer>();;
        queue.offer(pRoot);
        while(!queue.isEmpty()){
            pRoot = queue.poll();
            list.add(pRoot.val);
            if(pRoot.left!=null){
                queue.offer(pRoot.left);
                nlast = pRoot.left;
            }
            if(pRoot.right!=null){
                queue.offer(pRoot.right);
                nlast = pRoot.right;
            }
            if(pRoot == last){
                allList.add(list);
                list = new ArrayList<Integer>();
                last = nlast;
            }
        }
        return allList;
       
        
    }
    public static void main(String[] args) {
    	TreeNode head = new TreeNode(5);
		head.left = new TreeNode(3);
		head.right = new TreeNode(8);
		head.left.left = new TreeNode(2);
		head.left.right = new TreeNode(4);
		head.left.left.left = new TreeNode(1);
		head.right.left = new TreeNode(7);
		head.right.left.left = new TreeNode(6);
		head.right.right = new TreeNode(10);
		head.right.right.left = new TreeNode(9);
		head.right.right.right = new TreeNode(11);
		
		System.out.println(Print(head).toString());
		String str = "";
		char[] charArray = str.toCharArray();
	}
    
}