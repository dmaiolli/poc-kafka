package com.maiolli.denys.pockafka.dataprovider.database.entity;

import javax.persistence.*;

@Entity
@Table(name = "master_blaster")
public class MasterBlasterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String processId;
    private String message;

    public MasterBlasterEntity(String processId, String message) {
        this.processId = processId;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
