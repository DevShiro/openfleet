package com.github.devshiro.openfleet.service.ui.repository;

import com.github.devshiro.openfleet.corda.schema.entity.ExampleEntity;

import java.util.List;

public interface ExampleRepository {
    List<ExampleEntity> findAll();
}
