package xzx.part2.array;
/**
 * n*n的正方形方格，从左上走到右下，打印出每一种走法
 * @author xzx
 *
 */
public class SqurePart {

	public static void main(String[] args) {
		int[][] arr = {
				{112,114,116,443,223,115},
				{112,114,1,443,223,115},
				{112,114,116,443,223,115},
				{112,114,116,443,223,115},
				{112,114,116,443,223,115},
				{112,114,116,443,223,115}
		};
		
        System.out.println("=======有多少种方法啊=="+countWays(arr, 6, 6));
        System.out.println("===========最佳路径最大值啊======="+getmax(arr));
	}
	
		
	//计算出有有多少种方法，其中跳过有障碍的方格，即board[i][j]=0;
	public static int countWays(int[][] board, int x, int y) {
        int[][] array = new int[x][y];
        for(int i=0;i<x;i++)
        {
            for(int j = 0;j<y;j++)
            {
                if(board[i][j]==0) continue;
                else if(i==0&&j==0) array[0][0]=1;
                else if(i==0&&j!=0) array[0][j] = array[0][j-1];
                else if(i!=0&&j==0) array[i][0] = array[i-1][0];
                else array[i][j] = (array[i-1][j]+array[i][j-1])%1000000007;
            }
        }
        return array[x-1][y-1];
    }
	/**
	 * 得出最佳路径最大值
	 * @param board
	 * @return
	 */
	public static int getmax(int[][] board){
		if(board==null||board.length==0){
			return 0;
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(i==0&&j==0){
					
				}else if(i==0){
					board[i][j] += board[i][j-1];
				}else if(j==0){
					board[i][j] = board[i-1][j];
				}else{
					//一般情况了
					if(board[i][j-1]>board[i-1][j]){
						board[i][j] += board[i][j-1];
					}else{
						board[i][j] += board[i-1][j];
					}
				}
			}
		}
		return board[board.length-1][board[0].length-1];
		
	}
	
	
}
