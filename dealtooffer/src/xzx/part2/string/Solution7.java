package xzx.part2.string;

import java.util.Scanner;

/**
 * 
 * @author xzx
 *
 */
public class Solution7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String all = sc.nextLine();
		String first = sc.nextLine();
		String second = sc.nextLine();
		System.out.println(solution(all, first, second));

	}

	public static String solution(String all, String first, String second) {
		if (all == null || all.length() == 0) {
			return "invalid";
		}
		if ((first == null || first.length() == 0) && (second == null || second.length() == 0)) {
			return "both";
		}
		if(first.length()+second.length()>all.length()){
			return "invalid";
		}
		if (first == null || first.length() == 0) {
			int indexNM = all.indexOf(second);
			if (indexNM != -1) {
				if (reverse(all).indexOf(second) != -1) {
					return "both";
				}
				return "forward";
			} else {
				if (reverse(all).indexOf(second) != -1) {
					return "backward";
				}
				return "invalid";
			}
		}

		if (second == null || second.length() == 0) {
			int indexNM = all.indexOf(first);
			if (indexNM != -1) {
				if (reverse(all).indexOf(first) != -1) {
					return "both";
				}
				return "forward";
			} else {
				if (reverse(all).indexOf(first) != -1) {
					return "backward";
				}
				return "invalid";
			}
		}
		int indexpreZ = all.indexOf(first);
		int indexlaZ = all.indexOf(second);
		String reAll = reverse(all);
		//System.out.println("反串："+reAll);
		// int indexpreF = all.indexOf(first);

		if (indexpreZ == -1) {
			int indexpreF = reAll.indexOf(first);
			if (indexpreF == -1) {
				return "invalid";
			}
			String subStr = reAll.substring(indexpreF);
			int indexlaF = subStr.indexOf(second);
			if (indexlaF == -1) {
				return "invalid";
			} else {
				return "backward";
			}
		} else {
			String subStr2 = all.substring(indexpreZ);
			//System.out.println("剩下的正串："+subStr2);
			int indexlasZ = subStr2.indexOf(second);
			if (indexlasZ != -1) {
				// 接下来判断是否为both
				int indexpreF = reAll.indexOf(first);
				if (indexpreF == -1) {
					return "forward";
				}
				String subStr = reAll.substring(indexpreF);
				int indexlaF = subStr.indexOf(second);
				if (indexlaF == -1) {
					return "forward";
				} else {
					return "both";
				}
				
				
			} else {
				// 接下来判断是否为backward
				int indexpreF = reAll.indexOf(first);
				if (indexpreF == -1) {
					return "invalid";
				}
				String subStr = reAll.substring(indexpreF);
				int indexlaF = subStr.indexOf(second);
				if (indexlaF == -1) {
					return "invalid";
				} else {
					return "backward";
				}
			}
		}

	}

	// 反转一个字符串
	public static String reverse(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}
		char[] charArray = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = charArray.length - 1; i >= 0; i--) {
			sb.append(charArray[i]);
		}
		return sb.toString();
	}

}
