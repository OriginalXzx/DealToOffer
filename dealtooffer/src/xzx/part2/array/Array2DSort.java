package xzx.part2.array;
/**
 * 从二维数组查找一个数，其中每行每列有序
 * @author xzx
 *
 */
public class Array2DSort {

	public static void main(String[] args) {
        int [][] arr = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(findOfArray(arr,4,4,5));
	}
    
	public static boolean findOfArray(int[][] arr,int rows,int columns,int number){
		boolean find = false;
		if(arr != null && rows > 0 && columns > 0){
			int row = 0;
			int column = columns - 1;
			while(row < rows && column >= 0){
				if(arr[row][column] == number){
					find = true;
					break;
				}else if(arr[row][column] > number){
					column--;
				}else{
					row++;
				}
			}
		}
		return find;
	}
}
