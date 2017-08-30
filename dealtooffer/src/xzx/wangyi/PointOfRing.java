package xzx.wangyi;

import java.util.Scanner;

/**
 * 小易有一个圆心在坐标原点的圆，小易知道圆的半径的平方。小易认为在圆上的点而且横纵坐标都是整数的点是优雅的，
 * 小易现在想寻找一个算法计算出优雅的点的个数，请你来帮帮他。
 * 
 * @author xzx
 *
 */
public class PointOfRing {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		sc.close();
		System.out.println(countOfPoint(n));
	}
	
	public static int countOfPoint(int r2){
		if(r2==0){
			return 0;
		}
		if(r2==1){
			return 4;
		}
		int r = (int) Math.sqrt(r2);
		int count = 0;
		for(int i=1;i<=r;i++){
			int result = isOnRing(r2, i);
			if(result!=-1){
				count += 4;
			}
		}
		return count;
	}
	
	public static int isOnRing(int r2,int i){
		double l = Math.sqrt(r2-i*i);
		if(l-(int)l==0){
			return (int) l;
		}else{
			return -1;
		}
	}
}
