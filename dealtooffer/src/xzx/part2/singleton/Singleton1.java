package xzx.part2.singleton;
/**
 * ֻ�ʺϵ��̵߳ĵ���ģʽ
 * �����������ģʽ
 * @author xzx
 *
 */
public class Singleton1 {
    
	private Singleton1(){

    }
    
	private static Singleton1 instance = null;
	public static Singleton1 Instance(){
		if(instance == null){
			instance = new Singleton1();
		}
		return instance;
	}
}
