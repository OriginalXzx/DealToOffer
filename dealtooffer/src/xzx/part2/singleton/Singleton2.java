package xzx.part2.singleton;
/**
 * 不好的解法二，虽然在多线程的环境下能工作，但效率不高！
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
