package xzx.part2.array;

import java.util.Scanner;

/**
 * 美团点评上有很多餐馆优惠券，用户可以在美团点评App上购买。每种优惠券有一个唯一的正整数编号。每个人可以拥有多张优惠券，但每种优惠券只能同时拥有至多一张。每种优惠券可以在使用之后继续购买。
 * 
 * 当用户在相应餐馆就餐时，可以在餐馆使用优惠券进行消费。某人优惠券的购买和使用按照时间顺序逐行记录在一个日志文件中，运营人员会定期抽查日志文件看业务是否正确。业务正确的定义为：一个优惠券必须先被购买，然后才能被使用。
 * 
 * 某次抽查时，发现有硬盘故障，历史日志中有部分行损坏，这些行的存在是已知的，但是行的内容读不出来。假设损坏的行可以是任意的优惠券的购买或者使用。
 * 
 * 现在给一个日志文件，问这个日志文件是否正确。若有错，输出最早出现错误的那一行，即求出最大s，使得记录1到s-1满足要求；若没有错误，输出-1。
 * 
 * 输入描述: 输入包含多组数据
 * 
 * m 分别表示 m (0 ≤ m ≤ 5 * 10^5) 条记录。
 * 
 * 下面有m行，格式为：
 * 
 * I x （I为Input的缩写，表示购买优惠券x）；
 * 
 * O x（O为Output的缩写，表示使用优惠券x）；
 * 
 * ? （表示这条记录不知道）。
 * 
 * 这里x为正整数，且x ≤ 10^5 。
 * 
 * 
 * 输出描述: -1 或 x(1 ≤ x ≤ m) 其中x为使得1到x-1这些记录合法的最大行号。
 * 
 * 输入例子: 0 1 O 1 2 ? O 1 3 I 1 ? O 1 2 I 2 O 1
 * 
 * 输出例子: -1 1 -1 -1 2
 * 
 * @author xzx
 *
 */
public class Main2 {

	static int maxLine = 1;
	static int numOfAlive = 0;
	static char[] ticket = new char[100001];
	static boolean[] ticketState = new boolean[100001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		if (0 < n) {
			int result = -1;
			for (int i = 0; i < n; i++) {
				String str = sc.nextLine();
				char ch = str.substring(0, 1).charAt(0);
				if (result==-1) {
					if (ch == '?') {// 信息丢失的情况
						maxLine++;
						numOfAlive++;
						for (int j = 0; j < ticketState.length; j++) {
							ticketState[j] = true;
						}
					} else {
						int ticketIndex = Integer.parseInt(str.substring(2));
						//System.out.println(ch);
						if ('I' == ch) {// 买票的情况
							if (ticket[ticketIndex] == 0) {
								maxLine++;
								ticket[ticketIndex] = 1;
							} else if (numOfAlive > 0 && ticketState[ticketIndex]) {
								maxLine++;
								numOfAlive--;
								ticketState[ticketIndex] = false;
								ticket[ticketIndex] = 1;//Hou
							} else {
								result = maxLine;

							}
						} else {// 使用票的情况
                             //System.out.println(maxLine);
							if (ticket[ticketIndex] == 1) {
								maxLine++;
								ticket[ticketIndex] = 0;
							} else if (numOfAlive > 0 && ticketState[ticketIndex]) {
								maxLine++;
								numOfAlive--;
								ticketState[ticketIndex] = false;
								ticket[ticketIndex] = 0;
							} else {
								result = maxLine;
							}
						}
					} 
				}
			}
			System.out.println(result);
		} else {
			System.out.println(-1);
		}
	}

}
