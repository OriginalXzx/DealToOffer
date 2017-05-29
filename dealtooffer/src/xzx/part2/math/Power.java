package xzx.part2.math;
/**
 * 数值的整数次方，不得使用库函数
 * @author xzx
 *
 */
public class Power {

	public static void main(String[] args) {
         double base = 6;
         int exponent = -1;
         System.out.println(power1(base,exponent));
	}
	/**
	 * 很垃圾的解法，完全不考虑指数小于1的情况
	 * @param base
	 * @param exponent
	 * @return
	 */
	public static double power(double base,int exponent){
		double result = 1.0;
		for (int i = 0; i < exponent; i++) {
			result *= base;
		}
		return result;
	}
    /**
     * 比较全面的解法，但不够高效
     * @param base
     * @param exponent
     * @return
     */
	public static double power1(double base,int exponent){
			boolean invalidInput = false;
			if(equal(base,0.0) && exponent < 0){
				invalidInput = true;
				return 0.0;
			}else if(equal(base,0.0) && exponent > 0){
				return 0.0;
			}
			
			if(exponent < 0){
				double result = powerWithUnsignedExponent(base, -exponent);
				return 1.0/result;
			}
            return powerWithUnsignedExponent(base, exponent);
			
			
	}
	//计算base不为0，exponent不为负数的情况
	public static double powerWithUnsignedExponent(double base,int exponent){
		/*double result = 1.0;
		for (int i = 0; i < exponent; i++) {
			result *= base;
		}*/
		//全面高效的解法，a^32 = (a^16)^2
		//      a^(n/2)* a^(n/2)   n为偶数
		//a^n = 
		//      a^(n-1/2)*a^(n-1/2)  n为奇数
		if(exponent == 0){
			return 1;
		}
		if(exponent == 1){
			return base;
		}
		double result = powerWithUnsignedExponent(base, exponent >>1);
		result *= result;
		if((exponent & 0x1) == 1){
			result *= base;
		}
		return result;
	}
	//用于判断double值是否等于0
	public  static boolean equal(double num1,double num2){
		if((num1 - num2 > -0.0000001)&&(num1 - num2 < 0.0000001)){
			return true;
		}else{
			return false;
		}
		
	}
	
	
	
	
	
}
