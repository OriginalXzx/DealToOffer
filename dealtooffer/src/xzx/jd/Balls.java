package xzx.jd;
/**
 * 小东和三个朋友一起在楼上抛小球，他们站在楼房的不同层，假设小东站的楼层距离地面N米，球从他手里自由落下，每次落地后反跳回上次下落高度的一半，
 * 并以此类推知道全部落到地面不跳，求4个小球一共经过了多少米？(数字都为整数)给定四个整数A,B,C,D，请返回所求结果。
 * 100,90,80,70   返回1020
 * @author xzx
 *
 */
public class Balls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
    (1+1/2)+(1/2+1/4)+(1/4+1/8)+......+(1/n+1/2n)        n->正无穷 
    =3*(1/2+1/4+1/8+......1/2n) 
    =3*(1-1/2+1/2-1/4+1/4-1/8+......1/n-1/2n) 
    =3*(1-1/2n)   n->正无穷 
    =3
	 */
	public int calcDistance(int a,int b,int c,int d){
		return 3*(a+b+c+d);
	}

}
