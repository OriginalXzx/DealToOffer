package xzx.part2.array;
/**
 * 从二维数组查找一个数，其中每行每列有序
 * @author xzx
 *
 */
public class Array2DSort {

	public static void main(String[] args) {
        int [][] array = {{1,2,8,9},{2,4,9,12},{5,7,10,13},{6,8,11,15}};
        System.out.println(findOfarrayay(5,array));
	}
    
	public static boolean findOfarrayay(int target,int[][] array){
		int rows = array.length;
		int columns = array[0].length;
		boolean find = false;
		if(array != null && rows > 0 && columns > 0){
			int row = 0;
			int column = columns - 1;
			while(row < rows && column >= 0){
				if(array[row][column] == target){
					find = true;
					break;
				}else if(array[row][column] > target){
					column--;
				}else{
					row++;
				}
			}
		}
		return find;
	}
}
