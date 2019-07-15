/**
 * @Date          2019年7月10日 下午5:34:00 

 * @version    V1.0 
 */
package designmodel.proxy.impl;

import designmodel.proxy.IProxy;

/**
 * @author MML
 * @Date    2019-07-10
 * @version    V1.0 
 */
public class ProxyMan implements IProxy {
	
	private IProxy IProxy ;
	
	public  ProxyMan() {  //默认开发者
		this.IProxy = new Developer();
	}
	
	public ProxyMan(IProxy proxy) {
		this.IProxy = proxy;
	}

	@Override
	public void buyBreakfast() {
		// TODO Auto-generated method stub
		this.IProxy.buyBreakfast();
	}

	@Override
	public void sendEmail() {
		// TODO Auto-generated method stub
		this.IProxy.sendEmail();
	}

	@Override
	public void repiredBug() {
		// TODO Auto-generated method stub
		this.IProxy.repiredBug();
	}

}
