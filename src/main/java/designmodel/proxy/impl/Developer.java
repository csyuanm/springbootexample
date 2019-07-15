/**
 * @Date          2019年7月10日 下午5:32:19 

 * @version    V1.0 
 */
package designmodel.proxy.impl;

import designmodel.proxy.IProxy;

/**
 * @author MML
 * @Date    2019-07-10
 * @version    V1.0 
 */
public class Developer implements IProxy {

	@Override
	public void buyBreakfast() {
		// TODO Auto-generated method stub
		System.out.println("developer buy breakfast..");
	}

	@Override
	public void sendEmail() {
		// TODO Auto-generated method stub
		System.out.println("developer send email..");
	}

	@Override
	public void repiredBug() {
		// TODO Auto-generated method stub
		System.out.println("developer repire bug..");
	}

}
