package com.maiolli.denys.pockafka.dataprovider.broker.masterblaster.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.maiolli.denys.pockafka.ContextTests;
import com.maiolli.denys.pockafka.core.domain.dto.output.MasterBlasterEventPayload;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.test.EmbeddedKafkaBroker;

import java.util.concurrent.TimeUnit;

class MasterBlasterBrokerTest extends ContextTests {

    @Autowired
    private EmbeddedKafkaBroker embeddedKafkaBroker;

    @Test
    void testSend() throws JsonProcessingException {
        MasterBlasterEventPayload payload = new MasterBlasterEventPayload("123", "message");

        sendMessage(NEW_MASTER_BLASTER_EVENT_TOPIC, createProducer(embeddedKafkaBroker), payload);

        Awaitility.waitAtMost(5L, TimeUnit.SECONDS).untilAsserted(() -> {
        });
    }
}