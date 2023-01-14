package com.maiolly.denys.pockafka.dataprovider.broker.masterblaster.producer;

import com.maiolly.denys.pockafka.core.domain.dto.output.MasterBlasterEventPayload;
import com.maiolly.denys.pockafka.dataprovider.broker.common.event.MessageProducer;
import com.maiolly.denys.pockafka.dataprovider.broker.masterblaster.event.MasterBlasterEvent;
import org.springframework.stereotype.Service;

@Service
public class MasterBlasterBroker {
    private final MessageProducer messageProducer;

    public MasterBlasterBroker(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    void send(MasterBlasterEventPayload payload) {
        messageProducer.send(new MasterBlasterEvent(payload));
    }
}
