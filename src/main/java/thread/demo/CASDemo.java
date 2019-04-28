/**
 * @Date          2019年4月10日 下午1:50:25 

 * @version    V1.0 
 */
package thread.demo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author MML
 * @Date    2019-04-10
 * @version    V1.0 
 */
public class CASDemo {
	
	public static volatile int count = 0;
	//是同atomic
	public static volatile AtomicInteger atomicCount = new AtomicInteger(0);
	
	public static final int THEAD_TOTAL = 20; 
	
	public static void autoIncreate() {
		//System.out.println("当前线程名为：" + Thread.currentThread().getName());
		count++;  //非原子操作， 取值、+1、写值
	}
	
	public static void atomicIncrease() {
		atomicCount.getAndIncrement();  //原子操作
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("start..");
		int threadMax = 20;
		
		Thread[] thread = new Thread[threadMax];
		for(int i = 0;i < threadMax; i++) {
			thread[i] = new Thread(new Runnable() {
				@Override
				public void run() {
					for(int i = 0; i < 1000; i++) {
						autoIncreate();
						atomicIncrease();
					}
				}
			});
			thread[i].start();
			//让主线程停止，使得线程能够按顺序执行
			//thread[i].join(); 
		}
//		while(Thread.activeCount() > 1) {
//			Thread.yield();
//		}
		Thread.sleep(15000);
		System.out.println(count);
		System.out.println(atomicCount);
	}

}
