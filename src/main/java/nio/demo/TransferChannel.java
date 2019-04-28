/**
 * @Date          2019年4月10日 上午10:26:15 

 * @version    V1.0 
 */
package nio.demo;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @author MML
 * @Date    2019-04-10
 * @version    V1.0 
 */
public class TransferChannel {

	public static void main(String[] args) throws IOException {
		
		//读取文件流
		RandomAccessFile fromFile = new RandomAccessFile("d:\\temp\\gd账号.txt", "rw");  
		//写入通道
		FileChannel fromChannel = fromFile.getChannel();
		
		//写入文件流
		RandomAccessFile toFile1 = new RandomAccessFile("d:\\temp\\transferFromFile.txt", "rw");  
		FileChannel toChannel1 = toFile1.getChannel();
		
		RandomAccessFile toFile2 = new RandomAccessFile("d:\\temp\\transferToFile.txt", "rw");  
		FileChannel toChannel2 = toFile2.getChannel();
		
		long position = 0;
		long capacity = fromChannel.size(); //获取缓冲区大小，用于创建写入是的大小
		
		//直接通过通道进行文件传输
		//1.transferFrom方式
		toChannel1.transferFrom(fromChannel, position, capacity);
		//2.transferTo方式
		fromChannel.transferTo(position, capacity, toChannel2);
		//注意两者的区别：transferFrom 是从 to.(from..)  transferTo 是 from.(to...)  调用者的对象不一样，和写入通道目的不一样
		//通道传输之后传输准备好的数据，可能比capacity小
		System.out.println("end..");
	}

}
