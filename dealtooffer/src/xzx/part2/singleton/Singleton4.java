package xzx.part2.singleton;
/**
 * 推荐解法一(饿汉单例设计模式)
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
