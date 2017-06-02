package xzx.part2.sortandfind;
/**
 * �����򣺴�10�����������ҵ�����10�����㷨
 * @author xzx
 *
 */
public class Heapsort {

	public static void main(String[] args) {
		 int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3 };  
		  
         System.out.println("Before heap:");  
         printArray(array);  
         heapSort(array);  
         System.out.println("After heap sort:");  
         printArray(array);  
	}
	
	 public static void heapSort(int[] array) {  
         if (array == null || array.length <= 1) {  
             return;  
         }  
         buildMaxHeap(array);  
         for (int i = array.length - 1; i >= 1; i--) {  
            exchangeElements(array, 0, i);  
             maxHeap(array, i, 0);  
         }  
     }  
     private static void buildMaxHeap(int[] array) {  
         if (array == null || array.length <= 1) {  
             return;  
         }  

         int half = array.length / 2;  
         for (int i = half; i >= 0; i--) {  
             maxHeap(array, array.length, i);  
         }  
     }  

     private static void maxHeap(int[] array, int heapSize, int index) {  
         int left = index * 2 + 1;  
         int right = index * 2 + 2;  

         int largest = index;  
         if (left < heapSize && array[left] > array[index]) {  
             largest = left;  
         }  

         if (right < heapSize && array[right] > array[largest]) {  
             largest = right;  
         }  

         if (index != largest) {  
             exchangeElements(array, index, largest);  

             maxHeap(array, heapSize, largest);  
         }  
     }  
 
    //��������������Ԫ��
	private static void exchangeElements(int[] a, int k, int N) {
		int temp = a[k];
		a[k] = a[N];
		a[N] = temp;
	}

	
	//��ӡ����Ԫ��
	public static void printArray(int[] array) {  
        System.out.print("{");  
        for (int i = 0; i < array.length; i++) {  
            System.out.print(array[i]);  
            if (i < array.length - 1) {  
                System.out.print(", ");  
            }  
        }  
        System.out.println("}");  
    }

}
