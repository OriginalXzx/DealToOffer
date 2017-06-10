package xzx.part2.link;

import xzx.part2.link.Link.Node;

/**
 * �����³���ԣ�Ҳ���Ǵ���Ľ�˶������
 * ��������еĵ�����K�����
 * @author xzx
 *
 */
public class FindKthToTail<Item> {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * ˼·����������ָ�룬��ʼͬʱָ��0��Ȼ���һ��ָ���ƶ���k-1ʱ���ڶ���ָ�뿪ʼ�ƶ�������һһ��ָ�뵽ĩβʱ���ڶ���ָ��պ�ֱ����k��Ԫ��
	 * û�п��Ǵ���³��������
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
	 * ���ǵ�������������������д����
	 */
	public  Node findKthToTail2(Node head,int k){
		if(head == null || k == 0){//���ǵ�����Ϊ�գ���kΪ0�����
			return null;
		}
		Node phead = head;
		Node pBehind = null;
		for(int i = 0;i < k -1;i++){
			if(phead.next!=null){//���ǵ��ڵ���������k�����
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
	 * ��ת�����������ת��������ͷ���
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
