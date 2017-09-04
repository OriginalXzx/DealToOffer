package xzx.table;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 基于单词查找树的符号表
 * @author xzx
 *
 * @param <Value>
 */
public class TrieST<Value> {
    private static int R = 256;//表示基数
    private Node root;
    
    private static class Node{
    	private Object val;
    	private Node[] next = new Node[R];
    }
    
    public Value get(String key){
    	Node x = get(root,key,0);
    	if(x == null){
    		return null;
    	}
    	return (Value) x.val;
    }

	private Node get(Node x, String key, int i) {//返回x为根节点的子单词查找树与key相关联的值
		if(x == null){
			return null;
		}
		if(i == key.length()){
			return x;
		}
		char c = key.charAt(i);
		return get(x.next[c],key,i+1);
	}
	
	public Node put(Node x,String key,Value val,int d){//如果key存在，则更新他的值
		if(x==null){
			x = new Node();
		}
		if(d == key.length()){
			x.val = val;
			return x;
		}
		char c = key.charAt(d);
		x.next[c] = put(x.next[c],key,val,d+1);
		return x;
	}
	
	public Iterable<String> keys(){
		return keysWithPrefix("");
	}

	private Iterable<String> keysWithPrefix(String pre) {//查找以pre为前缀的所有单词
		Queue<String> q = new LinkedList<String>();
		collect(get(root,pre,0),pre,q);
		return q;
	}

	private void collect(Node x, String pre, Queue<String> q) {
		if(x==null){
			return ;
		}
		if(x.val != null){
			q.offer(pre);
		}
		for (char c = 0;c < R;c++) {
			collect(x.next[c],pre + c,q);
		}
		
	}
	
	public Iterable<String> keysThatMatch(String pat){
		Queue<String> q = new LinkedList<String>();
		collect(root,"",pat,q);
		return q;
	}

	private void collect(Node x, String pre, String pat, Queue<String> q) {//通配符匹配
		// TODO Auto-generated method stub
		int d = pre.length();
		if(x == null){
			return;
		}
		if(d == pat.length() && x.val != null){
			q.offer(pre);
		}
		
		if(d == pat.length()){
			return;
		}
		char next = pat.charAt(d);
		for(char c = 0;c < R;c++){
			if(next == '.'||next == c){
				collect(x.next[c],pre + c,pat,q);
			}
			
		}
		
	}
	
	public String longstPrefixOf(String s){//最长前缀
		int length = search(root,s,0,0);
		return s.substring(0,length);
	}

	private int search(Node x, String s, int d, int length) {
		// TODO Auto-generated method stub
		if(x == null){
			return length;
		}
		if(x.val != null){
			length = d;
		}
		if(d == s.length()){
			return length;
		}
		char c = s.charAt(d);
		return search(x.next[c],s,d+1,length);
	}
	
	//删除操作,从单词查找树中删除一个键
	public void delete(String key){
		root = delete(root,key,0);
	}

	private Node delete(Node x, String key, int d) {
		// TODO Auto-generated method stub
		if(x == null){
			return null;
		}
		if(d == key.length()){
			x.val = null;
		}else{
			char c = key.charAt(d);
			x.next[c] = delete(x.next[c],key,d+1);
		}
		if(x.val != null){
			return x;
		}
		for(char c = 0;c < R;c++){
			if(x.next[c] != null){
				return x;
			}
		}
		return null;
		
	}
	
}
