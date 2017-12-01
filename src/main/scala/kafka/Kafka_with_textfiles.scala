package kafka

import java.io.{BufferedWriter, FileWriter}
import java.time.{Instant, LocalDateTime, ZoneId}
import java.util
import java.util.{Properties, UUID}

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.clients.producer.{KafkaProducer, _}

import scala.collection.JavaConverters._
import scala.concurrent.duration._
import scala.io.Source

/**
  * Code example a kafka producer is reading from a text file reading the last lines all
  * and sending to the queue which a kafka consumer then reads.
  *
  * Used akkas actor system to schedule the tasks
  */
object Kafka_with_textfiles extends App {
  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  implicit val ec = system.dispatcher
  val topic = "test"
  val fileName = "data.txt"
  val codec = "utf-8"

  val consumerProps = new Properties()
  consumerProps.put("bootstrap.servers", "localhost:9092")
  consumerProps.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  consumerProps.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  consumerProps.put("group.id", "somegroupid")

  //consumer
  val kafkaConsumer = new KafkaConsumer[String, String](consumerProps)
  kafkaConsumer.subscribe(util.Collections.singletonList(topic))
  val consumer = new Consumer(kafkaConsumer)

  //producer
  val producerProps = new Properties()
  producerProps.put("bootstrap.servers", "localhost:9092")
  producerProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  producerProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  producerProps.put("group.id", "somegroupid")
  val kafkaProducer = new KafkaProducer[String, String](producerProps)
  val producer = new Producer(kafkaProducer)

  // schedule stuff
  system.scheduler.schedule(0.second, 100.milliseconds) {
    val bw = new BufferedWriter(new FileWriter(fileName, true))
    bw.write(UUID.randomUUID().toString)
    bw.newLine()
    bw.flush()
    bw.close()
  }
  system.scheduler.schedule(1.second, 5.milliseconds)(producer.start(topic, fileName, codec))
  system.scheduler.schedule(2.second, 5.milliseconds)(consumer.start())
}

class Consumer(consumer: KafkaConsumer[String, String]) {

  def start(): Unit = {
    consumer
      .poll(100)
      .asScala
      .foreach(record => println(LocalDateTime.ofInstant(Instant.ofEpochMilli(record.timestamp()), ZoneId.systemDefault()) + " - " + record.value()))
  }
}

class Producer(kafkaProducer: KafkaProducer[String, String]) {

  private var lastLineNumber = 0

  def start(topic: String, fileName: String, codec: String): Unit = {
    val lines =
      Source
        .fromFile(fileName, codec)
        .getLines()
        .toList
    lines
      .drop(lastLineNumber)
      .filterNot("".equalsIgnoreCase)
      .foreach(line => {
        kafkaProducer.send(new ProducerRecord(topic, "key", line))
      })
    lastLineNumber = lines.size
  }
}






