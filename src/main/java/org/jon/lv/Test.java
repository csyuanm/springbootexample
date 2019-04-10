package org.jon.lv;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Test {

	public static void main(String[] args) throws Exception {

		String[] s = { "mml" };
		// Check arguments length value
		if (s.length == 0) {
			System.out.println("Enter topic name：" + s);
			return;
		}

		// Assign topicName to string variable
		String topicName = s[0].toString();
		// create instance for properties to access producer configs
		Properties props = new Properties();
		// Assign localhost id
		props.put("bootstrap.servers", "localhost:9092");
		// Set acknowledgements for producer requests.
		props.put("acks", "all");
		// If the request fails, the producer can automatically retry,
		props.put("retries", 0);
		// Specify buffer size in config
		props.put("batch.size", 16384);
		// Reduce the no of requests less than 0
		props.put("linger.ms", 1);
		// The buffer.memory controls the total amount of memory available to the
		// producer for buffering.
		props.put("buffer.memory", 33554432);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		Producer<String, String> producer = new KafkaProducer<String, String>(props);
		for (int i = 0; i < 10; i++) {
			producer.send(new ProducerRecord<String, String>(topicName, Integer.toString(i), Integer.toString(i)));
			System.out.println("Message sent successfully");
			//producer.close();
		}
		
		//配置consumer端
		Properties props2 = new Properties();
		props2.put("bootstrap.servers", "localhost:9092");
		props2.put("group.id", topicName);  //设置监听的topic
		props2.put("enable.auto.commit", "true");
		props2.put("auto.commit.interval.ms", "1000");
		props2.put("session.timeout.ms", "30000");
		props2.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props2.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		//创建consumer
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props2);
		// Kafka Consumer subscribes list of topics here.
		consumer.subscribe(Arrays.asList(topicName));
		// print the topic name
		System.out.println("Subscribed to topic " + topicName);
		//打开监听！！放在一起时，只能读取到上一次的，本次的还没发送过去？？
		while (true) {//有延迟。。。
			ConsumerRecords<String, String> records = consumer.poll(100);
			for (ConsumerRecord<String, String> record : records) {

				// print the offset,key and value for the consumer records.
				System.out.printf("offset = %d, key = %s, value = %s\n", record.offset(), record.key(), record.value());
			}
		}
	}
}
