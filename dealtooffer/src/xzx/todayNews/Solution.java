package xzx.todayNews;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double[] arr = new double[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextDouble();
		}
		//System.out.println(Arrays.toString(arr));
		System.out.println(solution(arr));
	}
	
	//��������Ѷȵ����飬һ���������������������
	public static int solution(double[] arr){
		if(arr==null || arr.length == 0){
			return 0;
		}
		Arrays.sort(arr);
		int count = 0;//��ʾ�ٳ�����Ŀ��
		int index = 0;//��ʾ����ı����Ǳ�
		int temp = 1;//��ʾһ������������Ŀ����
		while(index<arr.length-1){
			System.out.println("index "+index +"count:" + count+"temp "+temp);
			if(temp==1){
				if(dif(arr,index)<=10){
					temp++;
					index++;
				}else if(dif(arr,index)<=20&&dif(arr,index)>10){
					temp += 2;
					index += 1;
					count ++;
				}else{
					temp += 2;
					count += 2;
				}
			}else if(temp==2){
				if(dif(arr,index)<=10){
					temp ++;
					index ++;
				}else{
					temp ++;
					count ++;
				}
			}else{
				temp = 1;
				index ++;
			}
		}
		//���Ĵ���
		//��ʱindexӦ���ж�����
		//System.out.println("index "+index +"count:" + count+"temp "+temp);
		if(index == arr.length-1){
			return count + 3 - temp;
		}else{
			return count;
		}
		
	}
	
	//��һ�������������������Ĳ�ֵ
	public static double dif(double[] arr,int index){
			return arr[index+1] - arr[index];
		
	}

}
