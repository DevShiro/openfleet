package com.github.devshiro.openfleet.corda;

import com.github.devshiro.openfleet.corda.flow.ExampleFlow;
import com.google.common.collect.ImmutableList;
import net.corda.core.concurrent.CordaFuture;
import net.corda.core.transactions.SignedTransaction;
import net.corda.testing.node.MockNetwork;
import net.corda.testing.node.MockNetworkParameters;
import net.corda.testing.node.StartedMockNode;
import net.corda.testing.node.TestCordapp;
import org.assertj.core.api.WithAssertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

//TODO: Upgrade to junit 5

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FlowTests implements WithAssertions {

    private MockNetwork network;
    private StartedMockNode node;

    @Before
    public void setup() {
        network = new MockNetwork(new MockNetworkParameters().withCordappsForAllNodes(ImmutableList.of(
                TestCordapp.findCordapp("com.github.devshiro.openfleet.corda.contract"),
                TestCordapp.findCordapp("com.github.devshiro.openfleet.corda.flow")
        )));
        node = network.createPartyNode(null);
    }

    @After
    public void teardown() {
        network.stopNodes();
    }

    @Test
    public void simpleTest() {
        ExampleFlow.Initiator flow = new ExampleFlow.Initiator(1);
        CordaFuture<SignedTransaction> future = node.startFlow(flow);
        network.runNetwork();
        assertThatCode(future::get).doesNotThrowAnyException();
    }
}
