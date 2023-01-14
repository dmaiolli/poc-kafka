package com.maiolli.denys.pockafka.dataprovider.broker.masterblaster.event;

import com.maiolli.denys.pockafka.core.domain.dto.output.MasterBlasterEventPayload;
import com.maiolli.denys.pockafka.dataprovider.broker.common.event.BrokerEvent;

public record MasterBlasterEvent(MasterBlasterEventPayload payload) implements BrokerEvent<MasterBlasterEventPayload> {

    private static final String MASTER_BLASTER_EVENT = "masterBlasterEvent";

    @Override
    public String name() {
        return MASTER_BLASTER_EVENT;
    }

    @Override
    public String applicationName() {
        return "ms-master-blaster-application";
    }

    @Override
    public String eventId() {
        return payload.processId();
    }

}
