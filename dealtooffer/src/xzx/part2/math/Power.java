package xzx.part2.math;
/**
 * ��ֵ�������η�������ʹ�ÿ⺯��
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
	 * �������Ľⷨ����ȫ������ָ��С��1�����
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
     * �Ƚ�ȫ��Ľⷨ����������Ч
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
	//����base��Ϊ0��exponent��Ϊ���������
	public static double powerWithUnsignedExponent(double base,int exponent){
		/*double result = 1.0;
		for (int i = 0; i < exponent; i++) {
			result *= base;
		}*/
		//ȫ���Ч�Ľⷨ��a^32 = (a^16)^2
		//      a^(n/2)* a^(n/2)   nΪż��
		//a^n = 
		//      a^(n-1/2)*a^(n-1/2)  nΪ����
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
	//�����ж�doubleֵ�Ƿ����0
	public  static boolean equal(double num1,double num2){
		if((num1 - num2 > -0.0000001)&&(num1 - num2 < 0.0000001)){
			return true;
		}else{
			return false;
		}
		
	}
	
	
	
	
	
}
