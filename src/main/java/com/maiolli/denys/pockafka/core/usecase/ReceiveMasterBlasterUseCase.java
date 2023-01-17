package com.maiolli.denys.pockafka.core.usecase;

import com.maiolli.denys.pockafka.core.domain.dto.output.MasterBlasterEventPayload;
import com.maiolli.denys.pockafka.core.exception.SendKafkaMessageException;
import org.springframework.stereotype.Service;

@Service
public class ReceiveMasterBlasterUseCase {

    public void process(MasterBlasterEventPayload payload) {
        throw new SendKafkaMessageException(new RuntimeException());
    }

}
