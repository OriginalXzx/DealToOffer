package xzx.jd;
/**
 * ��԰����һ��ƻ����һ��nͷ(n����1С��9)�����֣���һͷΪС��������ƻ������n�ݺ󣬶����һ�������ӵ�����һ�����������Լ���һ��ƻ����
 * ���ŵڶ�ͷ���ظ���һ���̣����Ⱦ���n�ݣ��ӵ�һ��Ȼ������һ�ݣ��Դ�����ֱ�����һͷ�ܶ�������(���һͷ���ӵ����������0����Ҳ����n�ݾ���)��
 * ��������ƻ�������ж��ٸ���
         ����һ������n,��ʾ�ܵĸ��������������ƻ��������֤�н⡣
 * @author xzx
 *
 */
public class Apples {

	public static void main(String[] args) {
		System.out.println(getInitial(3));

	}
	
	public static int getInitial(int n){
		 long a = (long)Math.pow(n, n);
	     return (int)a-n+1;
	}

}
