package xzx.jd;
/**
 * һֻ���Ӳ�����20��Բ�����еĶ��У�����1��ʼ��ţ���
 * һֻ�Ǵ�x�Ŷ���ʼ��,�´θ�һ������(����x��2�Ŷ���)�����´θ���������(����x��5�Ŷ���)��������n����Ȼû���ҵ��������ӿ�������Щ���С�
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
