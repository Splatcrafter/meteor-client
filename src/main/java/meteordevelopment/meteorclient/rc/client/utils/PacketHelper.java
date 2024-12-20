/*
 * This file is part of the Meteor Client distribution (https://github.com/MeteorDevelopment/meteor-client).
 * Copyright (c) Meteor Development.
 */

package meteordevelopment.meteorclient.rc.client.utils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.network.packet.Packet;

public class PacketHelper {

    public static void sendPacket(final Packet<?> packet) {
        if (MinecraftClient.getInstance().player != null) {
            MinecraftClient.getInstance().player.networkHandler.sendPacket(packet);
        }
    }
}
