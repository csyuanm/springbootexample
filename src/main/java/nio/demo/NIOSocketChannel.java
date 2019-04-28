/**
 * @Date          2019年4月10日 上午11:00:18 

 * @version    V1.0 
 */
package nio.demo;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author MML
 * @Date    2019-04-10
 * @version    V1.0 
 */
public class NIOSocketChannel {

	public static void main(String[] args) throws Exception {
		
		//创建socketChannel通道
		SocketChannel channel = SocketChannel.open();  
		//设置监听地址和端口
		channel.connect(new InetSocketAddress("localhost", 80));
		
		//创建缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		//读取内容到缓冲区
		int bufferLength = channel.read(buffer);
		
		//创建selector选择器
		Selector selector = Selector.open();
		
		//filechannel不能使用监听
		channel.configureBlocking(false);  //通道不能处于阻塞状态
		SelectionKey key = channel.register(selector, SelectionKey.OP_ACCEPT);  //向selector注册监听事件
		Set selectorKeys = selector.selectedKeys();
		Iterator keys = selectorKeys.iterator();
		while(keys.hasNext()) {
			SelectionKey temp = (SelectionKey) keys.next();
			if(key.isAcceptable()) {
				
			} else if(key.isConnectable()) {
				
			} 
			//else if ....
		}
		
		//

	}

}
