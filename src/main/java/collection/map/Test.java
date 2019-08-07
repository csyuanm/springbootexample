/**
 * @Date          2019年7月2日 下午2:00:09 

 * @version    V1.0 
 */
package collection.map;

import java.util.HashMap;
import java.util.Map;


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
		Map<String, Object> map = new HashMap<>();
		int i = 0;
		while(i < 100000) {
			map.put(i+"", i);
			i++;
		}
		map1(map);
		System.out.println(map.size());
	}
	
	
	public static void map1(Map<String, Object> map) {
		Map<String, Object> map2 = map;
		int i = 0;
		while (i < 5000) {
			map.remove(i + "");
			i++;
		}
		map2.remove("9999");
		System.out.println(map.size());
	}

}
