package xzx.part2.stack;

import java.util.Stack;

/**
 * 两个栈实现一个队列
 * @author xzx
 *
 */
public class CQueue<T> {

	private Stack<T> stack1; //= new Stack<T>();
	private Stack<T> stack2; //= new Stack<T>();
	
	public CQueue(Stack<T> stack1, Stack<T> stack2) {
		this.stack1 = stack1;
		this.stack2 = stack2;
	}

	public void push(T t){
		stack1.add(t);
	}
	
	public T removeHead(){
		if(stack2.size() <= 0){
			while(stack1.size() > 0){
				T t1 = stack1.pop();
				stack2.add(t1);
			}
		}
		if(stack2.size() == 0){
			try {
				throw new Exception("queue is empty");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		T head = stack2.pop();
		return head;
	}
	
	public static void main(String[] args) {
         Stack<String> stack1 = new Stack<String>();
         Stack<String> stack2 = new Stack<String>();
         CQueue<String> queue = new CQueue<>(stack1, stack2);
         queue.push("a");
         queue.push("b");
         queue.push("c");
         queue.push("d");
         System.out.println(queue.removeHead());
	}
    
}
