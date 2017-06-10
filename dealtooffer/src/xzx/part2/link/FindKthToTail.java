package xzx.part2.link;

import xzx.part2.link.Link.Node;

/**
 * 代码的鲁棒性，也就是代码的健硕性问题
 * 输出链表中的倒数第K个结点
 * @author xzx
 *
 */
public class FindKthToTail<Item> {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * 思路：定义两个指针，开始同时指向0，然后第一个指针移动到k-1时，第二个指针开始移动，当第一一个指针到末尾时，第二个指针刚好直到第k个元素
	 * 没有考虑代码鲁棒性问题
	 */
	public  Node findKthToTail1(Node head,int k){
		Node phead = head;
		Node pBehind = null;
		for(int i = 0;i < k -1;i++){
			phead = phead.next;
		}
		
		pBehind = head;
		while(phead.next != null){
			phead = phead.next;
			pBehind = pBehind.next;
		}
		return pBehind;
		
	}
	
	/**
	 * 考虑到各种意外的情况，再重写代码
	 */
	public  Node findKthToTail2(Node head,int k){
		if(head == null || k == 0){//考虑到链表为空，和k为0的情况
			return null;
		}
		Node phead = head;
		Node pBehind = null;
		for(int i = 0;i < k -1;i++){
			if(phead.next!=null){//考虑到节点总数少于k的情况
				phead = phead.next;
			}else{
				return null;
			}
		}
		
		pBehind = head;
		while(phead.next != null){
			phead = phead.next;
			pBehind = pBehind.next;
		}
		return pBehind;
		
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

}
