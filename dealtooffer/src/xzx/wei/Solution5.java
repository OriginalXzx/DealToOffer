package xzx.wei;

import java.util.Scanner;

public class Solution5 {

	public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int[] temp = new int[10001];
         while(sc.hasNext()){
        	 temp[sc.nextInt()] = 1;
         }
         
         String str = "";
         for (int i = 1; i < temp.length; i++) {
			if(temp[i]==0){
				str += i;
			}
		}
         
	}

}
