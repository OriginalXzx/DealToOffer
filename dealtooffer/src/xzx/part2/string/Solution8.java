package xzx.part2.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//用正则表达式最快
public class Solution8 {
	public static void main(String[] args) throws IOException {
		// Scanner sc = new Scanner(System.in);
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String bigString = sc.readLine();
			String small1 = sc.readLine();
			String small2 = sc.readLine();

			boolean forward = false;
			boolean backward = false;

			if (bigString.matches(".*" + small1 + ".*" + small2 + ".*")) {
				forward = true;
			}

			StringBuilder sb = new StringBuilder(bigString);
			StringBuilder newSb = sb.reverse();

			if (newSb.toString().matches(".*" + small1 + ".*" + small2 + ".*")) {
				backward = true;
			}

			if (forward && backward) {
				System.out.println("both");
			}
			if (forward && !backward) {
				System.out.println("forward");
			}
			if (!forward && backward) {
				System.out.println("backward");
			}
			if (!forward && !backward) {
				System.out.println("invalid");
			}
		}
	}
}