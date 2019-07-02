/**
 * @Date          2019年7月2日 下午2:00:09 

 * @version    V1.0 
 */
package collection.map;

import java.util.HashMap;


/**
 * @author MML
 * @Date    2019-07-02
 * @version    V1.0 
 */
public class Test {

	/**
	 * @param args
	 * @Date    2019-07-02
	 * @version 1.0
	 */
	public static void main(String[] args) {
		HashMap<String, Object> map = new HashMap<>();
		int i = 0;
		while(i < 100000) {
			map.put(i+"", i);
			i++;
		}
		System.out.println(map.size());
	}
	

}
