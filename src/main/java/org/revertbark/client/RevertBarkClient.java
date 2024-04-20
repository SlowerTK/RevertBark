package org.revertbark.client;

import net.fabricmc.api.ClientModInitializer;

public class RevertBarkClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("RevertBark initialize client!");
    }
}
