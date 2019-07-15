/**
 * @Date          2019年7月10日 下午4:41:06 

 * @version    V1.0 
 */
package designmodel.strategy;

import designmodel.strategy.impl.CloseDoor;
import designmodel.strategy.impl.FireDoor;
import designmodel.strategy.impl.OpenDoor;

/**
 * @author MML
 * @Date    2019-07-10
 * @version    V1.0 
 */
public class Main {

	public static void main(String[] args) {
		//执行策略1
		OpenDoor strategy1 = new OpenDoor();
		Context context1 = new Context(strategy1);  //根据不同的策略创建不同的实例
		context1.start();
		
		//执行策略2
		CloseDoor strategy2 = new CloseDoor();
		Context context2 = new Context(strategy2);
		context2.start();
		
		//策略3
		Context context3 = new Context(new FireDoor());
		context3.start();
		
		
		//拓展不同的策略
		Context context = new Context("拓展类");
		context.start2();
	}
	
}
