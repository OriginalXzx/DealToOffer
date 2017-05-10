package xzx.part2.singleton;
/**
 * 只适合单线程的单例模式
 * 懒汉单例设计模式
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
