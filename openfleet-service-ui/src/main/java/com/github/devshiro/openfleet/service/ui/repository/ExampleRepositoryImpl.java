package com.github.devshiro.openfleet.service.ui.repository;

import com.github.devshiro.openfleet.corda.schema.entity.ExampleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class ExampleRepositoryImpl implements ExampleRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<ExampleEntity> findAll() {
        return entityManager.createQuery("SELECT e FROM ExampleEntity e").getResultList();
    }
}
