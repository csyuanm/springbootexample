package nio.demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOWriteDemo {
	
	static private final byte message[] = {112, 55, 121, 12, 45, 12};
	
	public static void main(String[] args) throws IOException {
		//创建输出流，指定输出的位置
		FileOutputStream out = new FileOutputStream("G:\\temp\\nio输出.txt");
		//获取输出流的channel
		FileChannel outChannel = out.getChannel();
		//创建buffer,并设置缓冲区大小
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		//把数据写入缓冲区
		for(int i = 0; i < message.length; i++) {
			buffer.put(message[i]);
		}
		//进行读写转换  limit=position  position=0
		buffer.flip();
		
		//把缓冲区的内容写到通道，即可完成传输（BIO是通过流的形式，NIO是缓冲区）
		outChannel.write(buffer);
		
		//关闭输出流
	}

}
