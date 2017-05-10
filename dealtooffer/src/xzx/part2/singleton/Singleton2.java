package xzx.part2.singleton;
/**
 * ���õĽⷨ������Ȼ�ڶ��̵߳Ļ������ܹ�������Ч�ʲ��ߣ�
 * @author xzx
 *
 */
public class Singleton2 {
	private Singleton2(){

    }
    
	private static Singleton2 instance = null;
	public static Singleton2 Instance(){
		synchronized (instance) {
			if (instance == null) {
				instance = new Singleton2();
			}
		}
		return instance;
	}

}
