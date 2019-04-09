package nio.demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOWriteDemo {
	
	static private final byte message[] = {112, 55, 121, 12, 45, 12};
	
	public static void main(String[] args) throws IOException {
		//�����������ָ�������λ��
		FileOutputStream out = new FileOutputStream("G:\\temp\\nio���.txt");
		//��ȡ�������channel
		FileChannel outChannel = out.getChannel();
		//����buffer,�����û�������С
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		//������д�뻺����
		for(int i = 0; i < message.length; i++) {
			buffer.put(message[i]);
		}
		//���ж�дת��  limit=position  position=0
		buffer.flip();
		
		//�ѻ�����������д��ͨ����������ɴ��䣨BIO��ͨ��������ʽ��NIO�ǻ�������
		outChannel.write(buffer);
		
		//�ر������
	}

}
