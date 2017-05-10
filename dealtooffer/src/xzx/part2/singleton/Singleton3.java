package xzx.part2.singleton;

public class Singleton3 {
	private Singleton3(){

    }
    
	private static Singleton3 instance = null;
	public static Singleton3 Instance(){
		if (instance == null) {
			synchronized (instance) {
				if (instance == null) {
					instance = new Singleton3();
				}
			} 
		}
		return instance;
	}
}
