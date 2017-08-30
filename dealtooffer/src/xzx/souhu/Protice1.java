package xzx.souhu;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
/**
 * 给定一个十进制的正整数number，选择从里面去掉一部分数字，希望保留下来的数字组成的正整数最大
 * @author xzx
 *
 */
public class Protice1 {
    
    static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		count = sc.nextInt();
		solution(str1);
		sc.close();
	}
	
	public static void solution(String number){
		if(count>=number.length()){
			return ;
		}
	    char[] arr = number.toCharArray();
		ArrayList<Character> list = new ArrayList<Character>();
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		solution1(list,0);
		Iterator<Character> it = list.iterator();
		while(it.hasNext()){
			System.out.print(it.next());
		}
		System.out.println();
	}

	private static void solution1(ArrayList<Character> list, int i) {
		if(count==0){
			return;
		}
		int index = i;
		while(count!=0){
			
			char max = getMax(list,index,index+count+1);
			
			int index1 = getMaxIndex(list, index, index+count+1, max);
			count = count - (index1-index);
			delete(list, index, index1);
			index++;
		}
        	    
	}
	
	private static char getMax(ArrayList<Character> list,int begin,int end){
		List<Character> subList = list.subList(begin, end);
		char max = '0';
		Iterator<Character> it = subList.iterator();
		while(it.hasNext()){
			Character next = it.next();
			if(max<next){
				max = next;
			}
		}
		return max;
	}
	/**
	 * 删除指定索引段的元素
	 * @param list
	 * @param begin
	 * @param end
	 */
	private static void delete(ArrayList<Character> list,int begin,int end){
		Character character = list.get(end);
		while(list.get(begin)!= character){
			list.remove(begin);
		}
	}
	
	private static int getMaxIndex(ArrayList<Character> list,int begin,int end,char max){
		List<Character> subList = list.subList(begin, end);
		if(subList.indexOf(max)!=-1){
			return begin+subList.indexOf(max);
		}else{
			return -1;
		}
		
	}

}
