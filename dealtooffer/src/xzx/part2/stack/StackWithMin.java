package xzx.part2.stack;

import java.util.Stack;

/**
 * 包含min函数的栈（能够找到栈的最小元素）
 * @author xzx
 *
 */
public class StackWithMin<T> {

	private Stack<T> dataStack = new Stack<T>();
	private Stack<T> minStack = new Stack<T>();
	public void push(T t){
		dataStack.push(t);
		if(!minStack.isEmpty()){
			System.out.println("haha"+(int)minStack.lastElement()+" "+(int)t);
			if((int)minStack.lastElement()>(int)t){
				minStack.push(t);
			}else{
				minStack.push(minStack.lastElement());
			}
		}else{
			minStack.push(t);
		}
	}
	public T pop(){
		T result = dataStack.pop();
		minStack.pop();
		return result;
	}
	
	public T min(){
		return minStack.lastElement();
	}
	
	public static void main(String[] args) {
		StackWithMin testStack = new StackWithMin();
		//System.out.println(testStack.minStack.isEmpty());
		testStack.push(3);
		System.out.println(testStack.min()+" "+testStack.minStack.size());
		testStack.push(4);
		System.out.println(testStack.min()+" "+testStack.minStack.size());
		testStack.push(2);
		System.out.println(testStack.min()+" "+testStack.minStack.size());
		testStack.push(1);
		System.out.println(testStack.min()+" "+testStack.minStack.size());
		testStack.pop();
		System.out.println(testStack.min()+" "+testStack.minStack.size());
		testStack.pop();
		System.out.println(testStack.min()+" "+testStack.minStack.size());
		/*Stack stack =new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println((int)stack.lastElement()>(int)stack.firstElement());*/
	}

}
