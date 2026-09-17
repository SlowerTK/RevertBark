package com.slowertk.revertbark;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.UseItemOnBlockEvent;

@EventBusSubscriber(modid = RevertBark.MOD_ID)
public class RevertBarkEvents {
    @SubscribeEvent
    public static void onUseItemOnBlock(UseItemOnBlockEvent event){
        if (event.getUsePhase() != UseItemOnBlockEvent.UsePhase.ITEM_AFTER_BLOCK) {
            return;
        }

        UseOnContext context = event.getUseOnContext();
        ItemStack stack = context.getItemInHand();

        if (!(stack.getItem() instanceof BoneMealItem)) {
            return;
        }

        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);

        Block log = RevertBarkBlocks.getLog(state.getBlock());

        if (log == null) {
            return;
        }

        BlockState newState = log.defaultBlockState()
                .setValue(
                        BlockStateProperties.AXIS,
                        state.getValue(BlockStateProperties.AXIS)
                );

        level.setBlockAndUpdate(pos, newState);
        level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(context.getPlayer()));

        level.playSound(
                null,
                pos,
                SoundEvents.BONE_MEAL_USE,
                SoundSource.BLOCKS,
                1.0F,
                1.0F
        );

        if (!level.isClientSide()) {
            stack.shrink(1);

            ServerLevel serverLevel = (ServerLevel) level;
            serverLevel.sendParticles(
                    ParticleTypes.HAPPY_VILLAGER,
                    pos.getX()+0.5,
                    pos.getY()+0.5,
                    pos.getZ()+0.5,
                    10,
                    0.5,
                    0.5,
                    0.5,
                    0.0
            );
        }
        event.cancelWithResult(ItemInteractionResult.sidedSuccess(level.isClientSide()));
    }
}
