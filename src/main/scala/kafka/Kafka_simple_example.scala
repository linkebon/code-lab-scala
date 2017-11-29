package kafka

import java.time._
import java.util
import java.util.Properties

import org.apache.kafka.clients.consumer.ConsumerRecords

import scala.collection.JavaConverters._
import scala.io.StdIn

/**
  * Simple kafka producer/consumer
  *
  * Start a kafka and zookeeper server e.g: https://kafka.apache.org/quickstart
  * It reads and produces events to the space: test
  * Kafka server needs to run on port 9092.
  */
object Kafka_consumer extends App {

  import org.apache.kafka.clients.consumer.KafkaConsumer

  val TOPIC = "test"
  val props = new Properties()
  props.put("bootstrap.servers", "localhost:9092")
  props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("group.id", "somegroupid")

  val consumer = new KafkaConsumer[String, String](props)
  consumer.subscribe(util.Collections.singletonList(TOPIC))

  println("*** Starting to read events ***")
  while (true) {
    val records: ConsumerRecords[String, String] = consumer.poll(100)
    for (record <- records.asScala) {
      println(LocalDateTime.ofInstant(Instant.ofEpochMilli(record.timestamp()), ZoneId.systemDefault()) + " - " + record.value())
    }
  }
}

object Kafka_producer extends App {

  import org.apache.kafka.clients.producer._

  val TOPIC = "test"
  val props = new Properties()
  props.put("bootstrap.servers", "localhost:9092")
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("group.id", "somegroupid")
  val producer = new KafkaProducer[String, String](props)
  while (true) {
    producer.send(new ProducerRecord(TOPIC, "key", StdIn.readLine("Write...: ")))
  }
  producer.close()
}
