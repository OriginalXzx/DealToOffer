package xzx.part2.sortandfind;
/**
 * λͼ�㷨ȥ��
 * @author xzx
 *
 */
public class Weitu {

	public static void main(String[] args) {
          int[] arr ={1,3,6,3,5,9,13,11,17,19};
          weituSort(arr);
	}
    
	public static void weituSort(int[] data){
		//[1-20] ��Ϊ��Щ���ֶ���1-20֮��  
		int[] a = new int[20];//Ĭ��ȫ0  
		for(int i=0;i < data.length;i++){  
		    if(a[ data[i] ] != 1){  
		        a[ data[i] ] = 1;  
		    }else{  
		        System.out.println(data[i]+" ���ظ�������");  
		    }  
		}  
		System.out.println("������");  
		for(int i=1;i<=19;i++){  
		   if( a[i] == 1){  
		       //����±�  
		       System.out.print(i+" ");  
		   }   
		}  
		  
		System.out.println("\n10�Ƿ��������������?");  
		System.out.println(a[10]==1);
	}
}
