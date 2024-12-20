/*
 * This file is part of the Meteor Client distribution (https://github.com/MeteorDevelopment/meteor-client).
 * Copyright (c) Meteor Development.
 */

package meteordevelopment.meteorclient.rc.client.modules;

import meteordevelopment.meteorclient.rc.client.utils.LoggerUtils;
import meteordevelopment.meteorclient.rc.client.utils.PacketHelper;
import meteordevelopment.meteorclient.settings.IntSetting;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.meteorclient.systems.modules.Categories;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.systems.modules.Modules;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;

public class TeleportDown extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();

    private final Setting<Integer> distance = sgGeneral.add(new IntSetting.Builder()
        .name("distance")
        .description("The distance to teleport.")
        .defaultValue(10)
        .min(1)
        .sliderMin(1)
        .sliderMax(50)
        .build()
    );

    public TeleportDown() {
        super(Categories.Redstone, "Teleport Down", "Teleports you in a straight line down.");
    }

    @Override
    public void onActivate() {
        teleport();
        Modules.get().get(TeleportDown.class).toggle();
    }

    private void teleport() {
        for (int i = 0; i < 4; i++) {
            PacketHelper.sendPacket(new PlayerMoveC2SPacket.Full(mc.player.getX(), mc.player.getY(), mc.player.getZ(), mc.player.getYaw(), mc.player.getPitch(), true));
            LoggerUtils.LOGGER.info("X: " + mc.player.getX() + " Y: " + mc.player.getY() + " Z: " + mc.player.getZ());
        }

        PacketHelper.sendPacket(new PlayerMoveC2SPacket.Full(mc.player.getX(), mc.player.getY() - distance.get(), mc.player.getZ(), mc.player.getYaw(), mc.player.getPitch(), true));
        LoggerUtils.LOGGER.info("X: " + mc.player.getX() + " Y: " + (mc.player.getY() - distance.get()) + " Z: " + mc.player.getZ());
    }
}
