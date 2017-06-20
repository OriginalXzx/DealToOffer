package xzx.part2.array;

import java.util.Scanner;

/**
 * ���ŵ������кܶ�͹��Ż�ȯ���û����������ŵ���App�Ϲ���ÿ���Ż�ȯ��һ��Ψһ����������š�ÿ���˿���ӵ�ж����Ż�ȯ����ÿ���Ż�ȯֻ��ͬʱӵ������һ�š�ÿ���Ż�ȯ������ʹ��֮���������
 * 
 * ���û�����Ӧ�͹ݾͲ�ʱ�������ڲ͹�ʹ���Ż�ȯ�������ѡ�ĳ���Ż�ȯ�Ĺ����ʹ�ð���ʱ��˳�����м�¼��һ����־�ļ��У���Ӫ��Ա�ᶨ�ڳ����־�ļ���ҵ���Ƿ���ȷ��ҵ����ȷ�Ķ���Ϊ��һ���Ż�ȯ�����ȱ�����Ȼ����ܱ�ʹ�á�
 * 
 * ĳ�γ��ʱ��������Ӳ�̹��ϣ���ʷ��־���в������𻵣���Щ�еĴ�������֪�ģ������е����ݶ��������������𻵵��п�����������Ż�ȯ�Ĺ������ʹ�á�
 * 
 * ���ڸ�һ����־�ļ����������־�ļ��Ƿ���ȷ�����д����������ִ������һ�У���������s��ʹ�ü�¼1��s-1����Ҫ����û�д������-1��
 * 
 * ��������: ���������������
 * 
 * m �ֱ��ʾ m (0 �� m �� 5 * 10^5) ����¼��
 * 
 * ������m�У���ʽΪ��
 * 
 * I x ��IΪInput����д����ʾ�����Ż�ȯx����
 * 
 * O x��OΪOutput����д����ʾʹ���Ż�ȯx����
 * 
 * ? ����ʾ������¼��֪������
 * 
 * ����xΪ����������x �� 10^5 ��
 * 
 * 
 * �������: -1 �� x(1 �� x �� m) ����xΪʹ��1��x-1��Щ��¼�Ϸ�������кš�
 * 
 * ��������: 0 1 O 1 2 ? O 1 3 I 1 ? O 1 2 I 2 O 1
 * 
 * �������: -1 1 -1 -1 2
 * 
 * @author xzx
 *
 */
public class Main2 {

	static int maxLine = 1;
	static int numOfAlive = 0;
	static char[] ticket = new char[100001];
	static boolean[] ticketState = new boolean[100001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		if (0 < n) {
			int result = -1;
			for (int i = 0; i < n; i++) {
				String str = sc.nextLine();
				char ch = str.substring(0, 1).charAt(0);
				if (result==-1) {
					if (ch == '?') {// ��Ϣ��ʧ�����
						maxLine++;
						numOfAlive++;
						for (int j = 0; j < ticketState.length; j++) {
							ticketState[j] = true;
						}
					} else {
						int ticketIndex = Integer.parseInt(str.substring(2));
						//System.out.println(ch);
						if ('I' == ch) {// ��Ʊ�����
							if (ticket[ticketIndex] == 0) {
								maxLine++;
								ticket[ticketIndex] = 1;
							} else if (numOfAlive > 0 && ticketState[ticketIndex]) {
								maxLine++;
								numOfAlive--;
								ticketState[ticketIndex] = false;
								ticket[ticketIndex] = 1;//Hou
							} else {
								result = maxLine;

							}
						} else {// ʹ��Ʊ�����
                             //System.out.println(maxLine);
							if (ticket[ticketIndex] == 1) {
								maxLine++;
								ticket[ticketIndex] = 0;
							} else if (numOfAlive > 0 && ticketState[ticketIndex]) {
								maxLine++;
								numOfAlive--;
								ticketState[ticketIndex] = false;
								ticket[ticketIndex] = 0;
							} else {
								result = maxLine;
							}
						}
					} 
				}
			}
			System.out.println(result);
		} else {
			System.out.println(-1);
		}
	}

}
