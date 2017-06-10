package xzx.part2.link;

import java.util.Iterator;

import xzx.part2.link.Link.Node;

public class Link<Item> {
    private int N;
    private Node first;
    private Node last;
	public class Node{
		Item item;
		Node next;
	}
	public  boolean isEmpty(){
		return first == null;
	}
	public int size(){
		return N;
	}
	public void push(Item item){//从栈顶添加元素
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}
	
	public Item pop(){//从栈顶移除元素
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	
	public void enqueue(Item item){//从尾部添加元素
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
	 * 递归倒着打印链表
	 * @param first
	 */
	public void printLink(Node first){
		if(first == null){
			System.out.println("链表没东西了！！！");
		}else {
			if(first.next != null){
				printLink(first.next);
			}
			System.out.println(first.item);
		}
	}
	
	/**
	 * 反转链表，并输出反转后的链表的头结点
	 * @param head
	 * @return
	 */
	public Node reverseList(Node head){
		Node reversedHead = null;
		Node pNode = head;
		Node pPrev = null;
		while(pNode != null){
			Node pNext = pNode.next;
			if(pNext == null){
				reversedHead = pNode;
			}
			pNode.next = pPrev;
			pPrev = pNode;
			pNode = pNext;
		}
		
		return reversedHead;
		
	}

	
	public static void main(String[] args) {
	   FindKthToTail<String> findKthToTail = new FindKthToTail<String>();
       Link<String> link = new Link<String>();
       link.push("我");
       link.push("爱");
       link.push("中");
       link.push("国");
      /* System.out.println(findKthToTail.findKthToTail2(link.first, 2).item);
       System.out.println(link.first.item);*/
       System.out.println(findKthToTail.reverseList(link.first).item);
       link.printLink(link.first);
       
	}

}
