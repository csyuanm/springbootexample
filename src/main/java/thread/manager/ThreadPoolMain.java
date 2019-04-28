
package thread.manager;

import java.util.ArrayList;
import java.util.List;


public class ThreadPoolMain {
	
	public static int x = 0;

	public static void main(String[] args) throws InterruptedException {
		ThreadPool tPool = ThreadPoolManager.getThreadPool(10);
		List<Runnable> taskList = new ArrayList<Runnable>();
		for (int i = 0; i < 50; i++) {
			new Task().run();
			//taskList.add(new Task());
		}
		tPool.execute(taskList);  //传入线程任务
		System.out.println(tPool);
		System.out.println("-------------");
		tPool.destroy();// 所有线程都执行完成才destory
		System.out.println(tPool);
		Thread.sleep(100);
	}

	// 任务类
	static class Task implements Runnable {
		//volatile保证变量的可见性，原子性，不能加锁，也不能保证复合原子性
		private static volatile int i = 1;

		@Override
		public void run() {// 执行任务
			System.out.println("当前处理的线程是： " + Thread.currentThread().getName() + " 执行任务 " + (i++) + " 完成");
			//x+=1;
		}
	}
}
