package com.github.devshiro.openfleet.service.ui.utils.cordapp;

import com.github.devshiro.openfleet.corda.schema.OpenfleetSchemaV1;
import lombok.extern.slf4j.Slf4j;
import net.corda.core.flows.FlowLogic;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FlowLoader {

    public FlowLoader() {
        new OpenfleetSchemaV1().getMappedTypes().forEach(klass -> {});
    }
}
