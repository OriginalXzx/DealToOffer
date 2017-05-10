package xzx.part2.singleton;
/**
 * �Ƽ��ⷨ2��ʵ�ְ��贴��ʵ��
 * @author xzx
 *
 */
public class Singleton5 {
	
	public void say(){
		System.out.println("hello!!!");
	}
	private Singleton5(){

    }
    
	//private static Singleton5 instance = null;
	public static Singleton5 Instance(){
		
		return Nested.instance;
	}
	static class Nested{
		Nested(){
		
		}
		private static Singleton5 instance = new Singleton5();
	}
	
	public static void main(String[] args) {
		Singleton5 instance = Singleton5.Instance();
		instance.say();
	}
}
