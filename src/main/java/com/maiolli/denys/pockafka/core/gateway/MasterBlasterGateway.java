package com.maiolli.denys.pockafka.core.gateway;

import com.maiolli.denys.pockafka.core.domain.dto.output.MasterBlasterEventPayload;
import com.maiolli.denys.pockafka.dataprovider.broker.masterblaster.producer.MasterBlasterBroker;
import com.maiolli.denys.pockafka.dataprovider.database.entity.MasterBlasterEntity;
import com.maiolli.denys.pockafka.dataprovider.database.repository.MasterBlasterRepository;
import org.springframework.stereotype.Service;

@Service
public interface MasterBlasterGateway {
    void sendToQueue(MasterBlasterEventPayload payload);

    MasterBlasterEntity save(MasterBlasterEntity entity);
}

@Service
record MasterBlasterGatewayImpl(MasterBlasterBroker blasterBroker, MasterBlasterRepository repository) implements MasterBlasterGateway {

    @Override
    public void sendToQueue(MasterBlasterEventPayload payload) {
        blasterBroker.send(payload);
    }

    @Override
    public MasterBlasterEntity save(MasterBlasterEntity entity) {
        return repository.save(entity);
    }
}
