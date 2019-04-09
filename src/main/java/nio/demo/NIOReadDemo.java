package nio.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOReadDemo {

	public static void main(String[] args) throws IOException {

		//��ȡ������
		FileInputStream input = new FileInputStream("G:\\temp\\nio���.txt");
		
		FileChannel inChannel = input.getChannel();
		
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		//��������������д��ͨ��
		inChannel.read(buffer);
		
		//��д����ת��Ϊ������
		//limit=capacity  position=0 mark=-1
		buffer.flip();
		
		while(buffer.remaining() > 0) {
			byte b = buffer.get();
			System.out.println((char) b);
		}
		
		input.close();
	}

}
