package xzx.part2.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution2 {
    
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = "dfafaf231";
		ArrayList list = new ArrayList();
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if(48<=chars[i]&&chars[i]<=57){
				list.add(chars[i]);
			}
		}
		Collections.sort(list);
		System.out.println(list);
        /*int n =sc.nextInt();
        Node[] nodes = new Node[n-1];
        for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new Node(sc.nextInt(),sc.nextInt());
		}
        System.out.println(heightOfTree(nodes,n));*/
	}
	
	static class Node implements Comparable<Node>{
		int id;
		int childId;
	     
		public Node(int id, int childId) {
			this.id = id;
			this.childId = childId;
		}

		@Override
		public int compareTo(Node o) {
			return o.childId - this.childId;
		}

		@Override
		public String toString() {
			return "Node [id=" + id + ", childId=" + childId + "]";
		}
		
		
	}
	
	public static int heightOfTree(Node[] nodes,int n){
	     if(nodes==null||nodes.length==0){
	    	 return 0;
	     }
	     Arrays.sort(nodes);
	     System.out.println(Arrays.toString(nodes));
	     int[] dp = new int[n];
	     Arrays.fill(dp, 1);
	     int max = 0;
	     for (int i = dp.length-1; i >= 0; i--) {
			for (int j = nodes.length - 1; j >= 0; j--) {
				if(i == nodes[j].id){
					dp[i] = Math.max(dp[i], dp[nodes[j].childId]+1);
				}
			}
			if(max<dp[i]){
				max = dp[i];
			}
		}
	     System.out.println(Arrays.toString(dp));
	    return max; 
	}
}
