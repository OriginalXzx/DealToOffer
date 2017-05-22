package xzx.part2.sortandfind;
/**
 * 找出旋转数组中的最小数字
 * @author xzx
 *
 */
public class Min {

	public static int findMin(int[] spinArr,int length){
		if(spinArr == null || length <= 0){
			try {
				throw new Exception("Invalid parameters");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int index1 = 0;
		int index2 = length - 1;
		int indexMid = index1;
		while(spinArr[index1] >= spinArr[index2]){
			if(index2 - index1 == 1){
				indexMid = index2;
				break;
			}
			indexMid = (index1 + index2)/2;
			//如果spinArr[index1],spinArr[index2],spinArr[indexMid]相等，只能顺序查找；
			if(spinArr[index1] == spinArr[index2] && spinArr[index1] == spinArr[indexMid]){
				return MidInOrder(spinArr,index1,index2);
			}
			if(spinArr[indexMid] >= spinArr[index1]){
				index1 = indexMid;
			}else if(spinArr[indexMid] <= spinArr[index2]){
				index2 = indexMid;
			}
		}
		return spinArr[indexMid];
	}
	
	
	
	
	
	private static int MidInOrder(int[] spinArr, int index1, int index2) {
	    int result = spinArr[index1];
	    for (int i = index1 + 1; i <= index2; i++) {
			if(result > spinArr[i]){
				result = spinArr[i];
			}
		}
	    return result;
	}

	public static void main(String[] args) {
       int[] arr = {2,0,2,2,2};
       System.out.println(findMin(arr, arr.length));
	}

}
