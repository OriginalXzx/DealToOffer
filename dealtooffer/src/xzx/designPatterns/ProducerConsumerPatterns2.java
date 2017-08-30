package xzx.designPatterns;
/**
 * wait��notifyʵ��
 * @author xzx
 *
 */
import java.util.PriorityQueue;

/**
 * ͨ��wait��notify ʵ��
 * ������-������ģ�ͣ���������ʱ����������Ҫ�ȴ������пռ���ܼ��������������Ʒ�����ڵȴ����ڼ��ڣ�
 *          �����߱����ͷŶ��ٽ���Դ�������У���ռ��Ȩ����Ϊ������������ͷŶ��ٽ���Դ��ռ��Ȩ��
 *          ��ô�����߾��޷����Ѷ����е���Ʒ���Ͳ����ö����пռ䣬��ô�����߾ͻ�һֱ���޵ȴ���ȥ��
 *          ��ˣ�һ������£���������ʱ�����������߽������ٽ���Դ��ռ��Ȩ�����������״̬��
 *          Ȼ��ȴ���������������Ʒ��Ȼ��������֪ͨ�����߶����пռ��ˡ�
 *          ͬ���أ������п�ʱ��������Ҳ����ȴ����ȴ�������֪ͨ������������Ʒ�ˡ����ֻ���ͨ�ŵĹ��̾����̼߳��Э����
 * com.subject01.CusAndPro.java
 * @author ������
 * 2016��5��10��
 */
public class ProducerConsumerPatterns2 {
 
    private int queueSize = 10 ;
    private PriorityQueue<Integer> queue = new PriorityQueue<Integer>(queueSize);
     
    public static void main(String[] args) {
        ProducerConsumerPatterns2 cap = new ProducerConsumerPatterns2();
        Consumer cus = cap.new Consumer();
        Producer pro = cap.new Producer();
        Thread cusT = new Thread(cus);
        Thread proT = new Thread(pro);
         
        proT.start();
        cusT.start();
    }
    /**
     * ������
     * com.subject01.CusAndPro.java
     * @author ������
     * 2016��5��10��
     */
    class Consumer implements Runnable{
 
        @Override
        public void run() {
            cousume();
        }
 
        private void cousume() {
            while(true){
                synchronized (queue) {
                    while(queue.size() ==0){
                        try {
                            System.out.println("���пգ��ȴ����ݡ�����");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                     
                    queue.poll() ;
                    queue.notify();
                    System.out.println("�Ӷ�����ȡ��һ��Ԫ�أ�������ʣ��"+queue.size()+"��");
                }
            }
        }
         
    }
    /**
     * ������
     * com.subject01.CusAndPro.java
     * @author ������
     * 2016��5��10��
     */
    class Producer implements Runnable{
 
        @Override
        public void run() {
            produce();
        }
 
        private void produce() {
            while(true){
                synchronized(queue){
                    while(queue.size() == queueSize){
                        try {
                            System.out.println("�����������ȴ�����Ŀռ�");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                     
                    queue.offer(1);   // ÿ�β���һ��Ԫ��
                    queue.notify();
                    System.out.println("�����ȡ�в���һ��Ԫ�أ�����ʣ��ռ䣺"+(queueSize-queue.size()));
                }
            }
        }
         
    }
}
