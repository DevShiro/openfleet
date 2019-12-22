package com.github.devshiro.openfleet.corda.contract;

import net.corda.core.contracts.CommandWithParties;
import net.corda.core.contracts.Contract;
import net.corda.core.contracts.ContractsDSL;
import net.corda.core.transactions.LedgerTransaction;
import org.jetbrains.annotations.NotNull;

public class OpenfleetContract implements Contract {
    public static final String ID = "com.github.devshiro.openfleet.corda.contract.OpenfleetContract";

    @Override
    public void verify(@NotNull LedgerTransaction tx) throws IllegalArgumentException {
        final CommandWithParties<OpenfleetCommands.Create> command = ContractsDSL.requireSingleCommand(tx.getCommands(), OpenfleetCommands.Create.class);
        ContractsDSL.requireThat(requirements -> {
            requirements.using("No inputs should be consumed", tx.getInputs().isEmpty());
            requirements.using("Only one output", tx.getOutputs().size() == 1);

            return null;
        });
    }
}
