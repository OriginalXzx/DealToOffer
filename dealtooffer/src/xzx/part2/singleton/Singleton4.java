package xzx.part2.singleton;
/**
 * �Ƽ��ⷨһ(�����������ģʽ)
 * @author xzx
 *
 */
public class Singleton4 {
	private Singleton4(){

    }
    
	private static Singleton4 instance = new Singleton4();
	public static Singleton4 Instance(){
		return instance;
	}
}
