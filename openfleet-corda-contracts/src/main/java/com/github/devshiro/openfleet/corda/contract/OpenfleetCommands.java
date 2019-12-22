package com.github.devshiro.openfleet.corda.contract;

import net.corda.core.contracts.CommandData;

public interface OpenfleetCommands extends CommandData {
    class Create implements OpenfleetCommands {}
}
