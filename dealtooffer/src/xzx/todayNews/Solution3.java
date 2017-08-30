package xzx.todayNews;

import java.util.Scanner;

public class Solution3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < y.length; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		
		int[][] solution = solution(x, y);
		for (int i = 0; i < solution.length; i++) {
			if(!(solution[i][0]==-1&&solution[i][1]==-1)){
				System.out.println(solution[i][0]+" " +solution[i][1]);
			}
			
		}

	}
	
	//判断是否可以找出某个点在x1,y1右上方
	public  static boolean canFind(int[] x,int[] y,int x1,int y1){
		if(x==null||y==null||x.length==0||y.length==0){
			return false;
		}
		
		for (int i = 0; i < y.length; i++) {
			if(x[i]>x1&&y[i]>y1){
				
				return true;
			}
		}
		return false;
	}
    
	public static int[][] solution(int[] x,int[] y){
		if(x==null||y==null||x.length==0||y.length==0){
			return null;
		}
		int[][] result = new int[x.length][2];
		for (int i = 0; i < result.length; i++) {
		     result[i][0] = -1;
		     result[i][1] = -1;
		}
		int index = 0;
		for (int i = 0; i < y.length; i++) {
			//System.out.println("x[i]"+x[i]+"y[i]"+y[i]+canFind(x,y,x[i],y[i]));
			if(!canFind(x,y,x[i],y[i])){
				result[index][0] = x[i];
				result[index][1] = y[i];
				index++;
			}
		}
		return result;
	}
}
