/**
 * @Date          2019年6月21日 上午9:08:24 

 * @version    V1.0 
 */
package collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author MML
 * @Date    2019-06-21
 * @version    V1.0 
 */
public class SetDemo {

	/**
	 * @param args
	 * @Date    2019-06-21
	 * @version 1.0
	 */
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("a1");
		set.add("a2");
		set.add("a3");
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
			it.remove();
		}
		
		shortSet();

	}
	
	public static void shortSet() {
		Set<Short> set = new HashSet<Short>();
		for(int i = 0; i < 100 ; i++) {
			set.add((short) i);
			set.remove(i);
		}
		System.out.println(set.size());  //100
	}

}
