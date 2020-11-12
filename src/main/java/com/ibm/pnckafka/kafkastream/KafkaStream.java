package com.ibm.pnckafka.kafkastream;
import java.util.Properties;

import com.ibm.pnckafka.models.Balance;
import com.ibm.pnckafka.models.Customer;
import com.ibm.pnckafka.models.Joined;
import io.confluent.kafka.streams.serdes.avro.GenericAvroSerde;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.connect.json.JsonDeserializer;
import org.apache.kafka.connect.json.JsonSerializer;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.*;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;


public class KafkaStream {

    public static final String bootstrapServers = "127.0.0.1:9092";
    public static final String CTOPIC = "Customer";
    public static final String BTOPIC = "Balance";
    public static final String JOINTOPIC = "CustomerBalance";
    static final BalanceCustomerJoiner joiner = new BalanceCustomerJoiner();

    public static void main(String[] args) {
        Properties streamsConfiguration = new Properties();
        String rekeyedCustomerTopic = streamsConfiguration.getProperty("rekeyed.customer.topic.name");
        streamsConfiguration.put(StreamsConfig.APPLICATION_ID_CONFIG, "stream_test");
        streamsConfiguration.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
        streamsConfiguration.put("schema.registry.url", "http://my-schema-registry:8081");
        streamsConfiguration.put(
                StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG,
                Serdes.String().getClass().getName());
        streamsConfiguration.put(
                StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG,
                Serdes.String().getClass().getName()
                //GenericAvroSerde.class
                );


        final Serde<Customer> specificAvroSerde = new SpecificAvroSerde();
        StreamsBuilder builder = new StreamsBuilder();

        KStream<String, GenericRecord> balanceStream = builder.stream(BTOPIC);
        //.map((key,balance)->new KeyValue(String.valueOf(balance.getAccountId()),balance));
        KStream<String, Customer> customerStream = builder.stream(CTOPIC,Consumed.with(Serdes.String(),specificAvroSerde))
                .map((key,custom)->new KeyValue(custom.getAccountId(),custom));

        customerStream.to(rekeyedCustomerTopic);

        KTable<String, Customer> customerKTable = builder.table(rekeyedCustomerTopic);


        KStream<String, Joined> joined = (KStream<String, Joined>) balanceStream.join(customerKTable,joiner);

        joined.to(JOINTOPIC);



        KafkaStreams streams = new KafkaStreams(builder.build(), streamsConfiguration);
        streams.start();
        balanceStream.print(Printed.toSysOut());
    }



}


