package xzx.part2.array;

import java.util.Arrays;
import java.util.Scanner;

//��Ŀ�����������ٶ�ʱAPP�ĺ������ݵ��ڳ���APP�о������������������񷱶ർ�������ٶ��������⡣  
//������ǳ���ͨ��������������ӿ������ٶȡ��������������Ƕ����ģ����Ҷ��̲߳���ִ�У���ôǡ��һ  
//��������(<=50)����ʾһ������ÿ�����ֱ�ʾ���������ʱ�����еĺ�ʱ֮��<10000  
//���������������������̺�ʱ  
public class MinTime {

	/** ������������������ʵ����ĿҪ��Ĺ��� **/  
    /** ��Ȼ����Ҳ���Բ��������ģ����������ȫ�����Լ����뷨�� ^-^  **/  
  
    public static void main(String[] args){  
        Scanner in = new Scanner(System.in);  
        long res;  
      
        boolean _tasks;  
        int _tasks_temp = Integer.parseInt(in.nextLine().trim());  
        _tasks = (_tasks_temp != 0);  
    
        res = AppLaunchTaskOptimize(_tasks,_tasks_temp);  
        System.out.println(String.valueOf(res));    
    }

	public static long AppLaunchTaskOptimize(boolean _tasks, int _tasks_temp) {
		if (_tasks) {  
            Scanner sc = new Scanner(System.in);  
            int[] array = new int[_tasks_temp] ;    
            for (int j = 0; j < array.length; j++) {
            	array[j] = sc.nextInt();
			}
            System.out.println(Arrays.toString(array));  
            Arrays.sort(array);  
            return getInttempArr(array);  
        }else {  
            return 0 ;
        }
		
	}
   /**
    *  �ڶ�����+�������� < ���ĸ��� ������� �ڶ����� = �ڶ�����+�������� ����������=���ĸ��������ĸ�����Ϊ0��ɾ����  ��
                      �ڶ�����+��������  > =���ĸ���  ,��ʱ a= ��һ����+���ĸ���  ��b=�ڶ�����+��������
    * @param tempArr
    * @return
    */
	public static long getInttempArr(int[] tempArr) {
		int i = tempArr.length -1;  
        int temp = 0;  
        while(i >= 3)  
        {  
            if(tempArr[i-2] + tempArr[i-1] < tempArr[i]){  
                temp = tempArr[i-2] + tempArr[i-1] ;  
                tempArr[i-2]=temp;  
                tempArr[i-1]=tempArr[i];  
                tempArr[i]=0;  
                i=i-1;  
            }else{  
                int a = tempArr[i-3]+tempArr[i] ;  
                int b = tempArr[i-2]+tempArr[i-1];  
                tempArr[i-3]= a>b?b:a ;  
                tempArr[i-2]=a>b?a:b ;
                tempArr[i]=0;  
                tempArr[i-1]=0;  
                i=i-2;  
            }  
        }  
        //ֻ����������
        if(tempArr.length == 3 && tempArr[0] + tempArr[1] < tempArr[2]){  
            return tempArr[0]+tempArr[1]>tempArr[2]?tempArr[0]+tempArr[1]:tempArr[2] ;  
        }else if(tempArr.length==2){  
            return tempArr[1] ;  
        }else{
        	return tempArr[0];
        }
	}
}
