package xzx.part2.array;

import java.util.Arrays;
import java.util.Scanner;

//题目描述：启动速度时APP的核心内容但在超级APP中经常出现由于启动任务繁多导致启动速度慢的问题。  
//因此我们尝试通过并行启动任务加快启动速度。假设启动任务都是独立的，并且多线程并行执行，那么恰定一  
//组正整数(<=50)个表示一组任务，每个数字表示启动任务耗时，所有的耗时之和<10000  
//请算出该组任务的所需的最短耗时  
public class MinTime {

	/** 请完成下面这个函数，实现题目要求的功能 **/  
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/  
  
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
    *  第二个数+第三个数 < 第四个数 ，我们令： 第二个数 = 第二个数+第三个数 ，第三个数=第四个数，第四个数置为0或删除掉  ；
                      第二个数+第三个数  > =第四个数  ,此时 a= 第一个数+第四个数  ，b=第二个数+第三个数
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
        //只有三个任务
        if(tempArr.length == 3 && tempArr[0] + tempArr[1] < tempArr[2]){  
            return tempArr[0]+tempArr[1]>tempArr[2]?tempArr[0]+tempArr[1]:tempArr[2] ;  
        }else if(tempArr.length==2){  
            return tempArr[1] ;  
        }else{
        	return tempArr[0];
        }
	}
}
