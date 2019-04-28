package nio.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOReadDemo {

	public static void main(String[] args) throws IOException {
		//需要InputStream、OutputStream或RandomAccessFile来获取一个FileChannel实例。
		//获取输入流
		FileInputStream input = new FileInputStream("G:\\temp\\nio输出.txt");
		
		FileChannel inChannel = input.getChannel();
		
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		ByteBuffer buffer1 = ByteBuffer.allocate(1024);
		ByteBuffer buffer2 = ByteBuffer.allocate(1024);
		
		//可以读取、写入多个缓冲区到通道
		ByteBuffer[] bufferArray = {buffer, buffer1, buffer2};
		inChannel.read(bufferArray);
		
		//将缓冲区的数据写入通道
		int length = inChannel.read(buffer);
		
		//将写操作转化为读操作
		//limit=capacity  position=0 mark=-1
		buffer.flip();
		while(length != -1) {
			
			while(buffer.hasRemaining()) {
				byte b = buffer.get();  //从缓存区读取数据到通道使用get()方法
				System.out.println((char) b);
			}
			//读取完缓冲区之后，要进行清除操作，让缓冲区可以再次写入（这个是必须的？）
			buffer.clear();
			//再次写入通道
			inChannel.read(buffer);
		}
		
		
		input.close();
	}

}
