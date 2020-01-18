package com.github.devshiro.openfleet.service.ui.view;

import com.github.devshiro.openfleet.corda.flow.ExampleFlow;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import net.corda.client.rpc.CordaRPCClient;
import net.corda.client.rpc.CordaRPCConnection;
import net.corda.core.messaging.CordaRPCOps;
import net.corda.core.utilities.NetworkHostAndPort;

@Route("")
@PWA(name = "Openfleet dashboard", shortName = "Dashboard")
public class MainView extends VerticalLayout {

    public MainView() {
        Button button = new Button("Press me", VaadinIcon.QUESTION.create(), event -> {
            NetworkHostAndPort hostAndPort = new NetworkHostAndPort("localhost",10005);
            CordaRPCClient rpcClient = new CordaRPCClient(hostAndPort);
            CordaRPCConnection connection = rpcClient.use("user1","test", cordaRPCConnection -> {
                CordaRPCOps ops = cordaRPCConnection.getProxy();
                ops.startFlowDynamic(ExampleFlow.Initiator.class, Integer.valueOf(10));
                return cordaRPCConnection;
            });
            Notification.show("Button clicked");
        });
        add(button);
        setSizeFull();
    }
}
