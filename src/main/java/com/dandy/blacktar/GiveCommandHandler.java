package com.dandy.blacktar;

import net.minecraft.client.MinecraftClient;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.item.Item;

public class GiveCommandHandler {
    public static int handle(ServerCommandSource source, Item item) {
        MinecraftClient.getInstance().execute(() -> {
            MinecraftClient.getInstance().setScreen(new CustomGiveScreen(item));
        });
        return 1;
    }
}
