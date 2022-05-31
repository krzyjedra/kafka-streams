import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.{KafkaStreams, StreamsBuilder, StreamsConfig}
import java.util.Properties

object UpperCaseStreams extends App {

  val bootstrapServers = sys.env.getOrElse("KRZYSIEK_BOOTSTRAP_SERVERS", ":9092")
  val props = new Properties()
  props.put(StreamsConfig.APPLICATION_ID_CONFIG, "kafkastreams")
  props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers)
  props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String.getClass)
  props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String.getClass)

  val builder = new StreamsBuilder
  builder.stream[String, String]("input1").mapValues((value: String) => String.valueOf(value.toUpperCase)).to("output1")

  val streams = new KafkaStreams(builder.build, props)
  streams.start()

}
