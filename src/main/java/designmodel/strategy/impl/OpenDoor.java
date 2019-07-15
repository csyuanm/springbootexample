/**
 * @Date          2019年7月10日 下午4:01:32 

 * @version    V1.0 
 */
package designmodel.strategy.impl;

import designmodel.strategy.IStrategy;

/**
 * 策略1
 * @author MML
 * @Date    2019-07-10
 * @version    V1.0 
 */
public class OpenDoor implements IStrategy {

	/* (non-Javadoc)
	 * @see designmodel.strategy.IStrategy#operate()
	 */
	@Override
	public void operate() {
		// TODO Auto-generated method stub
		System.out.println("执行策略1");
	}

}
