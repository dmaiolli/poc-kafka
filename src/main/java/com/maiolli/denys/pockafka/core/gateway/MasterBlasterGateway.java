package com.maiolli.denys.pockafka.core.gateway;

import com.maiolli.denys.pockafka.core.domain.dto.output.MasterBlasterEventPayload;
import com.maiolli.denys.pockafka.dataprovider.broker.masterblaster.producer.MasterBlasterBroker;
import org.springframework.stereotype.Service;

@Service
public interface MasterBlasterGateway {
    void sendToQueue(MasterBlasterEventPayload payload);
}

@Service
record MasterBlasterGatewayImpl(MasterBlasterBroker blasterBroker) implements MasterBlasterGateway {

    @Override
    public void sendToQueue(MasterBlasterEventPayload payload) {
        blasterBroker.send(payload);
    }
}
