package xzx.wei;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * 给定一个正整数，编写程序计算有多少对质数的和等于输入的这个正整数，并输出结果。输入值小于1000。 如，输入为10,
 * 程序应该输出结果为2。（共有两对质数的和为10,分别为(5,5),(3,7)）
 * 
 * @author xzx
 *
 */
public class Solution10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		solution(n);
	}

	public static List<Integer> findPrime(int n) {// 查找n以内的质数
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		for (int i = 3; i <= n; i++) {
			int temp = (int) (Math.sqrt(i)) + 1;
			for (int j = 2; j <= temp; j++) {
				if (i % j == 0) {
					break;
				}
				if (j == temp) {
					list.add(i);
				}
			}
		}
		return list;
	}

	public static void solution(int n){
		List<Integer> primes = findPrime(n);
		int count = 0;
		//System.out.println(Arrays.toString(arr));
		Iterator<Integer> iterator = primes.iterator();
		while(iterator.hasNext()){
			Integer next = iterator.next();
			if(n == 2*next){
				count++;
			}
			if(primes.contains(n - next)){
				count++;
			}
		}
		System.out.println(count/2);
		
	}
}
