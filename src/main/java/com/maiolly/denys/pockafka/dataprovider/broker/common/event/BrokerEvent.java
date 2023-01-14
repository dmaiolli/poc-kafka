package com.maiolly.denys.pockafka.dataprovider.broker.common.event;

public interface BrokerEvent <P> {
    String name();
    String applicationName();
    String eventId();
    P payload();
}
