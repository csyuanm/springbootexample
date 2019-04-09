package nio.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOReadDemo {

	public static void main(String[] args) throws IOException {

		//获取输入流
		FileInputStream input = new FileInputStream("G:\\temp\\nio输出.txt");
		
		FileChannel inChannel = input.getChannel();
		
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		//将缓冲区的数据写入通道
		inChannel.read(buffer);
		
		//将写操作转化为读操作
		//limit=capacity  position=0 mark=-1
		buffer.flip();
		
		while(buffer.remaining() > 0) {
			byte b = buffer.get();
			System.out.println((char) b);
		}
		
		input.close();
	}

}
