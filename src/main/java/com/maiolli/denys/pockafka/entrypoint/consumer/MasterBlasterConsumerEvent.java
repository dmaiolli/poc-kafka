package com.maiolli.denys.pockafka.entrypoint.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maiolli.denys.pockafka.core.domain.dto.output.MasterBlasterEventPayload;
import com.maiolli.denys.pockafka.core.usecase.ReceiveMasterBlasterUseCase;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component("masterBlasterEvent")
@ConditionalOnProperty(value = "consumer.topic", havingValue = "master-blaster-event", matchIfMissing = true)
public record MasterBlasterConsumerEvent(ReceiveMasterBlasterUseCase useCase, ObjectMapper mapper) implements Consumer<Message<MasterBlasterEventPayload>> {
    @Override
    public void accept(Message<MasterBlasterEventPayload> message) {
        receive(mapper.convertValue(message.getPayload(), MasterBlasterEventPayload.class));
    }

    private void receive(MasterBlasterEventPayload payload) {
        useCase.process(payload);
    }
}
