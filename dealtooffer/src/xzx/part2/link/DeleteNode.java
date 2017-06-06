package xzx.part2.link;


/**
 * 删除链表的结点，快速算法
 * @author xzx
 *
 */
public class DeleteNode<Item> {

	private class Node{
		Item item;
		Node next;
	}
	
	public void deleteNode(Node head,Node toDelete){
		if(head==null || toDelete == null){
			return;
		}
		//要删除的结点不是尾节点
		if(toDelete.next != null){
			Node pnext = toDelete.next;
			toDelete.item = pnext.item;
			toDelete.next = pnext.next;
			pnext=null;
		}else if(head == toDelete){//链表里只有一个结点，删除头结点
			toDelete = null;
		}else{//链表有多个结点，删除尾节点
			Node pNode = head;
			while(pNode.next!=toDelete){
				pNode = pNode.next;
			}
			pNode.next = null;
			toDelete = null;
		}
	}
	
	public static void main(String[] args) {
          
	}
}
