/**
 * @Date          2019年7月10日 下午5:26:20 

 * @version    V1.0 
 */
package designmodel.proxy;

import designmodel.proxy.impl.Developer;
import designmodel.proxy.impl.Leader;
import designmodel.proxy.impl.ProxyMan;
import designmodel.proxy.impl.Tester;

/**
 * @author MML
 * @Date    2019-07-10
 * @version    V1.0 
 */
public class Main {

	/**
	 * @param args
	 * @Date    2019-07-10
	 * @version 1.0
	 */
	public static void main(String[] args) {
		
		//创建代理
		ProxyMan proxy = new ProxyMan();
		proxy.buyBreakfast();
		proxy.sendEmail();
		proxy.repiredBug();
		//开发
		ProxyMan developer = new ProxyMan(new Developer());
		developer.buyBreakfast();
		developer.sendEmail();
		developer.repiredBug();
		
		//测试
		ProxyMan tester = new ProxyMan(new Tester());
		tester.buyBreakfast();
		tester.sendEmail();
		tester.repiredBug();
		
		//leader
		ProxyMan leader = new ProxyMan(new Leader());
		leader.buyBreakfast();
		leader.sendEmail();
		leader.repiredBug();
	}

}
