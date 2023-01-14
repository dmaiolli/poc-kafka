package com.maiolli.denys.pockafka.core.exception;

public class SendKafkaMessageException extends RuntimeException {
    public SendKafkaMessageException(Exception ex) {
        super(ex);
    }
}
