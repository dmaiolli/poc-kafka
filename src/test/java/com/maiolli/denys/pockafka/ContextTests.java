package com.maiolli.denys.pockafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maiolli.denys.pockafka.dataprovider.database.repository.MasterBlasterRepository;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.KafkaTestUtils;

import java.util.concurrent.ExecutionException;


@SpringBootTest(classes = PocKafkaApplicationTests.class)
@EmbeddedKafka(topics = ContextTests.NEW_MASTER_BLASTER_EVENT_TOPIC)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract public class ContextTests {

    protected final static String NEW_MASTER_BLASTER_EVENT_TOPIC = "master-blaster-event";

    protected ObjectMapper mapper = new ObjectMapper();

    @Autowired
    protected MasterBlasterRepository masterBlasterRepository;

    public Producer<String, String> createProducer(EmbeddedKafkaBroker broker) {
        DefaultKafkaProducerFactory<String, String> producerFactory = new DefaultKafkaProducerFactory<>(KafkaTestUtils.producerProps(broker));
        return producerFactory.createProducer();
    }

    public <T> Consumer<String, T> createConsumer(EmbeddedKafkaBroker broker) {
        DefaultKafkaConsumerFactory<String, T> factory = new DefaultKafkaConsumerFactory<>(KafkaTestUtils.consumerProps("ms-master-blaster", "true", broker));
        return factory.createConsumer();
    }

    public <T> void sendMessage(String topic, Producer<String, String> producer, T payload) throws JsonProcessingException {
        producer.send(new ProducerRecord<>(topic, mapper.writeValueAsString(payload)));
    }

}
