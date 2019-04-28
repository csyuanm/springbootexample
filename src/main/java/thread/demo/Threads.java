/**
 * @Date          2019年4月10日 下午5:24:15 

 * @version    V1.0 
 */
package thread.demo;

/**
 * @author MML
 * @Date    2019-04-10
 * @version    V1.0 
 */
public class Threads {
	
	public static volatile int sum = 0;

	public static void main(String[] args) {
		
		Thread producer = new Producer();
		Thread consumer = new Consumer();
		Thread producer1 = new Producer();
		Thread consumer1 = new Consumer();
		Thread producer2 = new Producer();
		Thread consumer2 = new Consumer();
		
		producer.start();
		consumer.start();
		producer1.start();
		consumer1.start();
		producer2.start();
		consumer2.start();
	}
	
	public static synchronized void producer() {
		sum++;
		System.out.println(Thread.currentThread().getName() + "生产：" + sum);
	}
	
	public static synchronized void consumer() {
		sum--;
		System.out.println(Thread.currentThread().getName() + "消费后：" + sum);
	}
	
	public static int getSum() {
		return sum;
	}
	
}

class Producer extends Thread {
	
	public void run() {
		while(true) {
			if(Threads.getSum() < 100) {
				Threads.producer();
			}
		}
	}
}


class Consumer extends Thread {
	
	public void run() {
		while(true) {
			if(Threads.getSum() > 0) {
				Threads.consumer();
			}
		}
	}
}

