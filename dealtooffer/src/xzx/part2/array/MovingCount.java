package xzx.part2.array;

/*���ݷ�
 * ������һ��m�к�n�еķ���һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ��
 * ���ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ� ���磬��kΪ18ʱ���������ܹ����뷽��35,37������Ϊ3+5+3+7 = 18��
 * ���ǣ������ܽ��뷽��35,38������Ϊ3+5+3+8 = 19�����ʸû������ܹ��ﵽ���ٸ����ӣ�
����˼·��
   1.��(0,0)��ʼ�ߣ�ÿ�ɹ���һ����ǵ�ǰλ��Ϊtrue,Ȼ��ӵ�ǰλ�����ĸ�����̽����
   ����1 + 4 �������̽��ֵ֮�͡�
   2.̽��ʱ���жϵ�ǰ�ڵ��Ƿ�ɴ�ı�׼Ϊ��
     1����ǰ�ڵ��ھ����ڣ�
     2����ǰ�ڵ�δ�����ʹ���
     3����ǰ�ڵ�����limit���ơ�
 */
public class MovingCount {

	public int movingCount(int k, int rows, int cols) {
		boolean[][] visited = new boolean[rows][cols];
		return countSteps(k, rows, cols, 0, 0, visited);
	}

	public int countSteps(int k, int rows, int cols, int x, int y, boolean[][] visited) {
		// �����˲����ߵ�����
		if (x < 0 || x >= rows || y < 0 || y >= cols || visited[x][y] || bitSum(x) + bitSum(y) > k) {
			return 0;
		}
        visited[x][y] = true;
        return countSteps(k,rows,cols,x+1,y,visited)+
        		countSteps(k,rows,cols,x-1,y,visited)+
        		countSteps(k,rows,cols,x,y+1,visited)+
        		countSteps(k,rows,cols,x,y-1,visited)+1;
	}
   
    //�ж�һ����λ����Ӻ�
	private int bitSum(int x) {
		int count = 0;
		while(x!=0){
			count += x % 10;
			x /= 10;
		}
		return count;
	}
}
