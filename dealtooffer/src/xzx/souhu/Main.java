package xzx.souhu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList list = new ArrayList(); 
		while(sc.hasNextLine()){
			String str = sc.nextLine();
			if(str=="0 0 0 0 0 0"){
				break;
			}
			String[] split = str.split(" ");
			int[] arr = new int[split.length];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(split[i]);
			}
			list.add(arr);
		}
		list.remove(list.size()-1);
		Iterator iterator = list.iterator();
        while(iterator.hasNext()){
        	System.out.println(iterator.next());
        }
	}

	public static int solution(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();// 装空闲空间
		for (int i = 0; i < arr.length; i++) {
			map.put(i, arr[i]);
		}
		int count = 0;
		while (!map.isEmpty()) {
			Iterator<Entry<Integer, Integer>> iterator = map.entrySet().iterator();
			while (iterator.hasNext()) {
				Integer key = iterator.next().getKey();
				Integer value = map.get(key);
				if (value == 0) {
					map.remove(key);
				}
			}
			if (!map.isEmpty()) {
				if (map.containsKey(6)) {
					int temp = map.get(6);
					count += temp;
					map.put(6, 0);
				}
				if (map.containsKey(5)) {
					int temp1 = map.get(5);
					count += temp1;
					int a = 0;
					if (map2.containsKey(1)) {
						a = map.get(1);
					}
					map2.put(1, temp1 * 11 + a);// 可以装多少个1*1
					map.put(5, 0);
				}
				if (map.containsKey(4)) {
					int temp2 = map.get(4);
					count += temp2;
					int a = 0;
					if (map2.containsKey(2)) {
						a = map.get(2);
					}
					map2.put(2, temp2 * 5 + a);// 可以装多少个2*2
					map.put(4, 0);
				}
				if (map.containsKey(3)) {
					int temp3 = map.get(3);
					int zheng = temp3 / 4;
					int yu = temp3 % 4;
					count += zheng;
					int a = 0;
					if (map2.containsKey(1)) {
						a = map.get(1);
					}
					int b = 0;
					if (map2.containsKey(2)) {
						b = map.get(2);
					}
					if (yu > 0) {
						count++;
						map2.put(2, 4 - yu + b);
						map2.put(1, 36 - 9 * yu - (4 - yu) * 4 + a);
					}
					map.put(3, 0);
				}
				if (map.containsKey(2)) {
					int temp4 = map.get(2);
					if (map2.containsKey(2)) {
						int can2 = map2.get(2);
						if (can2 >= temp4) {
							map2.put(2, can2 - temp4);
						} else {
							int need2 = temp4 - can2;
							int zheng1 = need2 / 9;
							int yu1 = need2 % 9;
							count += zheng1;
							if (yu1 != 0) {
								count += 1;
								int sheng = 36 - yu1 * 4;
								int temp5 = map.get(1);
								map2.put(1, temp5 + sheng);
							}
						}
					}
					map.put(2, 0);
				}
				if (map.containsKey(1)) {
					int temp6 = map.get(1);
					int can1 = 0;
					if (map2.containsKey(2)) {
						can1 = map2.get(2) * 4;
					}
					if (map2.containsKey(1)) {
						can1 += map2.get(1);
					}
					if (can1 >= temp6) {
						map2.put(1, can1 - temp6);
					} else {
						int need1 = temp6 - can1;
						int q = need1 / 36;
						int r = need1 % 36;
						count += q;
						if (r != 0) {
							count++;
						}
						map2.put(1, 36 - r);
					}
				}
				map.put(1, 0);
			}
		}
		return count;
	}

}
