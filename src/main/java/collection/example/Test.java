/**
 * @version    V1.0 
 */
package collection.example;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author MML
 * @Date    2019-06-17
 * @version    V1.0 
 */
public class Test {
	
	public static final Lock lock = new ReentrantLock();

	/**
	 * @param args
	 * @Date    2019-06-17
	 * @version 1.0
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float a = 1.0f - 0.9f;
		float b = 0.8f - 0.7f;
		float c = 0.9f - 0.8f;
		if(a == b) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		fDec();
		fDec2();
//		switchNUll();
		lock();
		
		Integer aa = new Integer(1);
		add(aa);
		System.out.println(aa);
		
	}
	
	public static void fDec() {
		float a = 1.0f - 0.9f;
		float b = 0.9f - 0.8f;
		if(a == b) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
	
	public static void fDec2() {
		float a = Float.valueOf(1.0f - 0.9f);
		float b = Float.valueOf(0.9f - 0.8f);
		if(a == b) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
	
	public static void switchNUll() {
		String param = null;
		switch(param) {
		case "null": 
			System.out.println("true");
		default:
			System.out.println("default");
		}
	}
	
	public static void s() {
		BigDecimal a = new BigDecimal(0.1);  //这个好像比较好
		BigDecimal b = new BigDecimal("0.1");
		
	}
	
	public static void lock() {
		try {
			lock.tryLock();
			lock.tryLock();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public static void add(Integer a) {
		a++;
		System.out.println(a);
	}

}
