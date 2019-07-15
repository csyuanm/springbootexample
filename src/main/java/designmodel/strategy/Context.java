/**
 * @Date          2019年7月10日 下午4:25:55 

 * @version    V1.0 
 */
package designmodel.strategy;

/**
 * 用于控制实现不同的策略，传入接口的子类
 * 通过构造方法创建
 * @author MML
 * @Date    2019-07-10
 * @version    V1.0 
 */
public class Context {
	
	private IStrategy strategy;
	private String strategy2;
	
	//根据不同的策略，创建不同的策略对象
	public Context(IStrategy strategy) {  //重点！！！
		this.strategy = strategy;
	}
	
	//这里可以根据不同的构造函数，进行更多策略类的拓展
	public Context(String strategy) {
		this.strategy2 = strategy;
	}
	
	//执行context的方式，实际上执行的是传入对象对应的方法
	public void start() {
		System.out.println("start..");
		this.strategy.operate();
	}
	
	public void start2() {
		System.out.println("开始拓展策略类2");
	}

}
