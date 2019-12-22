package com.github.devshiro.openfleet.corda.schema.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.corda.core.schemas.PersistentState;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "openfleet_example_entity")
@AllArgsConstructor
@Data
public class ExampleEntity extends PersistentState {

    @Column(name = "issuer")
    private final String issuer;

    @Column(name = "value")
    private final int value;

    @Column(name = "linear_id")
    private final UUID linearId;
}
