package com.maiolli.denys.pockafka.dataprovider.database.repository;

import com.maiolli.denys.pockafka.dataprovider.database.entity.MasterBlasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MasterBlasterRepository extends JpaRepository<MasterBlasterEntity, UUID> {
}
