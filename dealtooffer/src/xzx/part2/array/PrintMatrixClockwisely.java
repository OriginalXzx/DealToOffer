package xzx.part2.array;

public class PrintMatrixClockwisely {

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3, 4 } };
		printMatrixClockwisely(a, 4, 1);
	}

	public static void printMatrixClockwisely(int[][] numbers, int columns, int rows) {
		if (numbers == null || columns <= 0 || rows <= 0) {
			return;
		}
		int start = 0;
		while (columns > start * 2 && rows > start * 2) {
			printMatrixInCircle(numbers, columns, rows, start);
			++start;
		}
	}

	private static void printMatrixInCircle(int[][] numbers, int columns, int rows, int start) {
		int endX = columns - 1 - start;
		int endY = rows - 1 - start;
		// 从左到右打印一份
		for (int i = start; i <= endX; i++) {
			int number = numbers[start][i];
			System.out.print(number);
		}
		// 从上到下打印一列
		if (start < endY) {
			for (int i = start + 1; i <= endY; i++) {
				int number = numbers[i][endY];
				System.out.print(number);
			}
		}
		// 从右到左打印一份
		if (start < endX && start < endY) {
			for (int i = endY - 1; i >= start; i--) {
				int number = numbers[endY][i];
				System.out.print(number);
			}
		}
		// 从下到上打印一列
		if (start < endX && start < endY - 1) {
			for (int i = endY - 1; i >= start + 1; i--) {
				int number = numbers[i][start];
				System.out.print(number);
			}
		}
	}

}
