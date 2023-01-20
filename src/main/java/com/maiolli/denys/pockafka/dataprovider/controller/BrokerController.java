package com.maiolli.denys.pockafka.dataprovider.controller;

import com.maiolli.denys.pockafka.core.domain.dto.output.MasterBlasterEventPayload;
import com.maiolli.denys.pockafka.core.gateway.MasterBlasterGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("master-blaster")
public record BrokerController(MasterBlasterGateway gateway) {

    @GetMapping
    void send() {
        gateway.sendToQueue(new MasterBlasterEventPayload("123", "123"));
    }

}
