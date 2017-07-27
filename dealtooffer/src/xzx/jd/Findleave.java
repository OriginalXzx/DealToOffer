package xzx.jd;
/**
 * 一只兔子藏身于20个圆形排列的洞中（洞从1开始编号），
 * 一只狼从x号洞开始找,下次隔一个洞找(即在x＋2号洞找)，在下次个两个洞找(即在x＋5号洞找)，它找了n次仍然没有找到。问兔子可能在那些洞中。
 * @author xzx
 *
 */
public class Findleave {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void returnLeave(int x,int n){
		int[] home = new int[20];
		int index = x - 1;
		for(int i=1;i<=n;i++){
			if(index>19){
				index = index%20;
			}
			home[index]=1;
			index = index + i + 1;
		}
		boolean flage = false;
		for (int i = 0; i < home.length; i++) {
			if(home[i]==0){
				System.out.print(i+1+" ");
				flage = true;
			}
		}
		if(flage==false){
			System.out.println(-1);
		}
		System.out.println();
		
	}

}
