package xzx.part2.link;


/**
 * ɾ������Ľ�㣬�����㷨
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
		//Ҫɾ���Ľ�㲻��β�ڵ�
		if(toDelete.next != null){
			Node pnext = toDelete.next;
			toDelete.item = pnext.item;
			toDelete.next = pnext.next;
			pnext=null;
		}else if(head == toDelete){//������ֻ��һ����㣬ɾ��ͷ���
			toDelete = null;
		}else{//�����ж����㣬ɾ��β�ڵ�
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
