package com.maiolli.denys.pockafka.core.usecase;

import com.maiolli.denys.pockafka.core.domain.dto.output.MasterBlasterEventPayload;
import com.maiolli.denys.pockafka.core.gateway.MasterBlasterGateway;
import com.maiolli.denys.pockafka.dataprovider.database.entity.MasterBlasterEntity;
import org.springframework.stereotype.Service;

@Service
public record ReceiveMasterBlasterUseCase(MasterBlasterGateway gateway) {

    public void process(MasterBlasterEventPayload payload) {
        gateway.save(new MasterBlasterEntity(payload.processId(), payload.message()));
    }

}
