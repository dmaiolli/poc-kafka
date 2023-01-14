package com.maiolli.denys.pockafka.dataprovider.broker.masterblaster.producer;

import com.maiolli.denys.pockafka.core.domain.dto.output.MasterBlasterEventPayload;
import com.maiolli.denys.pockafka.dataprovider.broker.masterblaster.event.MasterBlasterEvent;
import com.maiolli.denys.pockafka.dataprovider.broker.common.event.MessageProducer;
import org.springframework.stereotype.Service;

@Service
public class MasterBlasterBroker {
    private final MessageProducer messageProducer;

    public MasterBlasterBroker(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    public void send(MasterBlasterEventPayload payload) {
        messageProducer.send(new MasterBlasterEvent(payload));
    }
}
