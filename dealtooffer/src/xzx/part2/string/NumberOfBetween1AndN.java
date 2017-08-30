package xzx.part2.string;

/**
 * 总结一下以上的算法，可以看到，当计算右数第 i 位包含的 X 的个数时： 取第 i 位左边（高位）的数字，乘以 10 i−1 ，得到基础值 a 。
 * 取第 i 位数字，计算修正值： 如果大于 X，则结果为 a+ 10 i−1 。 如果小于 X，则结果为 a 。
 * 如果等 X，则取第 i 位右边（低位）数字，设为b ，最后结果为 a+b+1 。
 *  相应的代码非常简单，效率也非常高，时间复杂度只有 O( log 10 n) 。
 * 
 * @author xzx
 *
 */
public class NumberOfBetween1AndN {

	public static void main(String[] args) {
		int n = 1300;
		System.out.println(NumberOfXBetween1AndN_Solution(n, 1));

	}
	
	public static int NumberOfXBetween1AndN_Solution(int n,int x) {
	    if(n<0||x<1||x>9)
	        return 0;
	    int high,low,curr,tmp,i = 1;
	    high = n;
	    int total = 0;
	    while(high!=0){
	        high = n/(int)Math.pow(10, i);// 获取第i位的高位
	        tmp = n%(int)Math.pow(10, i);
	        curr = tmp/(int)Math.pow(10, i-1);// 获取第i位
	        low = tmp%(int)Math.pow(10, i-1);// 获取第i位的低位
	        if(curr==x){
	            total+= high*(int)Math.pow(10, i-1)+low+1;
	        }else if(curr<x){
	            total+=high*(int)Math.pow(10, i-1);
	        }else{
	            total+=(high+1)*(int)Math.pow(10, i-1);
	        }
	        i++;
	    }
	    return total;       
	}
}
