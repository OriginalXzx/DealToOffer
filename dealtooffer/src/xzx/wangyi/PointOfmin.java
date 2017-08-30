package xzx.wangyi;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PointOfmin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		Point[] points = new Point[n];
		for (int i = 0; i < points.length; i++) {
			points[i].x = sc.nextInt();
		}
		for (int i = 0; i < points.length; i++) {
			points[i].y = sc.nextInt();
		}
		
		int[] result = findMinSteps(points);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]+" ");
		}
		
	}

	class Point {
		int x;
		int y;

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

	}

	// �õ�����ĳ���������K��������
	public static int getMiniDisPoint(List<Point> points, Point currPoint, int k) {
		int totalSteps = 0;
		int len = points.size();
		if (k >= len) {
			return -1;
		}
		for (int i = 0; i < k; i++) {
			// ��С����
			int miniDis = stepsOfTwoPoint(points.get(0), currPoint);
			// ��ǰ����
			int currDis = 0;
			int index = 0;
			int j;
			for (j = 1; j < points.size(); j++) {
				currDis = stepsOfTwoPoint(points.get(j), currPoint);
				if (currDis < miniDis) {
					miniDis = currDis;
					index = j;
				}
			}

			totalSteps += currDis;
			points.remove(index);
		}
		return totalSteps;

	}

	// ÿ���㵽���������ĵ�ľ���
	public static void pointMinSpace(List<Point> list) {

		for (int i = 0; i < list.size(); i++) {
			Point a = list.get(i);
			double minDistance = Double.MAX_VALUE;
			int o = 0;
			for (int j = 0; j < list.size(); j++) {
				Point b = list.get(j);
				if (a.getX() != b.getX() && a.getY() != b.getY()) {
					int distance = stepsOfTwoPoint(a, b);
					if (distance <= minDistance) {
						minDistance = distance;
						o = j + 1;
					}
				}
			}
			System.out.println("p" + (i + 1) + " to p" + o + ":MinDistance=" + minDistance);

		}

	}

	// ��������е��е�ĳ�������ٲ�����k����
	public static int[] findMinSteps(Point[] points) {
		if (points == null || points.length == 0) {
			return null;
		}
		int len = points.length;
		int[] arr = new int[len];
		arr[0] = 1;
		for (int i = 1; i < len - 1; i++) {
			List<Point> list = Arrays.asList(points);
			int minDis = getMiniDisPoint(list,list.get(0),1);
			for (int j = 1; j < arr.length; j++) {
                  if(minDis<getMiniDisPoint(list,list.get(i),1)){
                	  minDis = getMiniDisPoint(list,list.get(i),1);
                  }
			}
			arr[i]= minDis;
		}

		return arr;

	}

	// ��һ���㵽��һ�������貽��p2-->p1
	public static int stepsOfTwoPoint(Point p1, Point p2) {
		return Math.abs(p2.x - p1.x) + Math.abs(p2.y - p1.y);
	}

}
