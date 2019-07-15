/**
 * @Date          2019年7月10日 下午5:31:33 

 * @version    V1.0 
 */
package designmodel.proxy.impl;

import designmodel.proxy.IProxy;

/**
 * @author MML
 * @Date    2019-07-10
 * @version    V1.0 
 */
public class Tester implements IProxy {

	@Override
	public void buyBreakfast() {
		// TODO Auto-generated method stub
		System.out.println("tester buy breakfast..");
	}

	@Override
	public void sendEmail() {
		// TODO Auto-generated method stub
		System.out.println("tester send email..");
	}

	@Override
	public void repiredBug() {
		// TODO Auto-generated method stub
		System.out.println("tester repire bug");
	}

}
