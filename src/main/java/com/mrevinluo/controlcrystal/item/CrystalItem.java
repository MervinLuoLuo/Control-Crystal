package com.mrevinluo.controlcrystal.item;

import com.mrevinluo.controlcrystal.CommandFileManager;
import com.mrevinluo.controlcrystal.ControlCrystal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.TitleFadeS2CPacket;
import net.minecraft.network.packet.s2c.play.TitleS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class CrystalItem extends Item {


    public CrystalItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (!world.isClient && user instanceof ServerPlayerEntity serverPlayer) {
            serverPlayer.networkHandler.sendPacket(new TitleFadeS2CPacket(10, 70, 20));
            serverPlayer.networkHandler.sendPacket(
                    new TitleS2CPacket(Text.literal("Control Crystals!"))
            );

            // 扣除物品
            stack.decrement(1);

            // 随机读取命令
            String cmd = CommandFileManager.getRandomCommand();
            if (cmd != null && !cmd.isBlank()) {
                // 记录到 mod 日志
                ControlCrystal.LOGGER.info("Selected command (not executed): {}", cmd);
            }
        }

        return ActionResult.SUCCESS;
    }
}
