package xzx.part2.link;

import java.util.Iterator;

public class Link<Item> {
    private int N;
    private Node first;
    private Node last;
	private class Node{
		Item item;
		Node next;
	}
	public  boolean isEmpty(){
		return first == null;
	}
	public int size(){
		return N;
	}
	public void push(Item item){//��ջ������Ԫ��
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}
	
	public Item pop(){//��ջ���Ƴ�Ԫ��
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	
	public void enqueue(Item item){//��β������Ԫ��
		Node oldLast = last;
		last.item = item;
		last.next = null;
		if(isEmpty()){
			first = last;
		}else{
			oldLast.next = last;
		}
		N++;
	}
	
	public Item removeLast(){
		Item item = last.item;
		last=null;
		return item;
	}
	
	public Iterator<Item> iterator(){
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>{
        
		private Node current = first;
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
		public void remove(){}
		
	}
	/**
	 * �ݹ鵹�Ŵ�ӡ����
	 * @param first
	 */
	public void printLink(Node first){
		if(first == null){
			System.out.println("����û�����ˣ�����");
		}else {
			if(first.next != null){
				printLink(first.next);
			}
			System.out.println(first.item);
		}
	}
	public static void main(String[] args) {
       Link<String> link = new Link<String>();
       link.push("��");
       link.push("��");
       link.push("��");
       link.push("��");
       System.out.println(link.first.item);
       link.printLink(link.first);
       
	}

}