package com.github.devshiro.openfleet.corda.schema;

import com.github.devshiro.openfleet.corda.schema.entity.ExampleEntity;
import com.google.common.collect.ImmutableList;
import net.corda.core.schemas.MappedSchema;
import org.jetbrains.annotations.NotNull;

public class OpenfleetSchemaV1 extends MappedSchema {
    public OpenfleetSchemaV1() {
        super(OpenfleetSchema.class, 1, ImmutableList.of(ExampleEntity.class));
    }
}
