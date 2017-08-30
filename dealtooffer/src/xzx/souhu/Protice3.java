package xzx.souhu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ����޺���
 * 
 * @author xzx
 *
 */
public class Protice3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Person[] persons = new Person[n];
		for (int i = 0; i < persons.length; i++) {
			persons[i] = new Person(sc.nextInt(), sc.nextDouble(), sc.nextDouble());
		}
		Arrays.sort(persons);
		System.out.println(Arrays.toString(persons));
		System.out.println(heightOf(persons));

	}

	static class Person implements Comparable<Person> {
		int id;
		double weight;
		double height;

		public Person(int id, double weight, double height) {
			this.id = id;
			this.weight = weight;
			this.height = height;
		}

		@Override
		public int compareTo(Person o) {
			return (int) (this.weight - o.weight);
		}

		@Override
		public String toString() {
			return "Person [id=" + id + ", weight=" + weight + ", height=" + height + "]";
		}

	}

	// �����ⷨ
	public static int heightOf(Person[] persons) {// ע������persons�����Ԫ���Ѿ����������ź�����;
		if (persons == null || persons.length == 0) {
			return 0;
		}

		int[] dp = new int[persons.length];// ��ʾ�õ�����Ա�ܴﵽ�����߶�
		for (int i = 0; i < persons.length; i++) {
			dp[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (persons[i].height>persons[j].height||
						(persons[i].weight==persons[j].weight&&persons[i].height == persons[j].height)) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		int max = dp[0];
		for (int i = 1; i < dp.length; i++) {
			if (max < dp[i]) {
				max = dp[i];
			}
		}
		System.out.println(Arrays.toString(dp));
		return max;

	}

}
