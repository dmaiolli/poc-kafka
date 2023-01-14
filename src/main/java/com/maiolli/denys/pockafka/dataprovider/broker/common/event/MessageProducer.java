package com.maiolli.denys.pockafka.dataprovider.broker.common.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maiolli.denys.pockafka.core.exception.SendKafkaMessageException;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class MessageProducer {

    private final StreamBridge streamBridge;
    private final ObjectMapper mapper;

    public MessageProducer(StreamBridge streamBridge, ObjectMapper mapper) {
        this.streamBridge = streamBridge;
        this.mapper = mapper;
    }

    private static final String KAFKA_CORRELATION_ID = "correlationId";
    private static final String EVENT_NAME = "eventName";
    private static final String APPLICATION_NAME = "applicationName";
    private static final String EVENT_ID = "eventId";

    public <T> void send(final BrokerEvent<T> event) {
        try {
            Message<String> message = createMessage(event);
            streamBridge.send(event.name(), message);
        } catch (JsonProcessingException e) {
            throw new SendKafkaMessageException(e);
        }
    }

    private <T> Message<String> createMessage(final BrokerEvent<T> event) throws JsonProcessingException {
        String payload = mapper.writeValueAsString(event.payload());
        return MessageBuilder.createMessage(payload, createHeaders(event));
    }

    private <T> MessageHeaders createHeaders(final BrokerEvent<T> event) {
        Map<String, Object> headers = new HashMap<>();

        headers.put(KAFKA_CORRELATION_ID, UUID.randomUUID().toString());
        headers.put(APPLICATION_NAME, event.applicationName());
        headers.put(EVENT_NAME, event.name());
        headers.put(EVENT_ID, event.eventId());

        return new MessageHeaders(headers);
    }
}
