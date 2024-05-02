package org.revertbark.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.HashMap;
import java.util.Map;

@Mixin(BoneMealItem.class)
public class NewBoneMeal {
    @Unique
    private static final Map<Block, Block> strippedLogs = new HashMap<>();
    static {
        strippedLogs.put(Blocks.STRIPPED_BAMBOO_BLOCK, Blocks.BAMBOO_BLOCK);
        strippedLogs.put(Blocks.STRIPPED_ACACIA_LOG, Blocks.ACACIA_LOG);
        strippedLogs.put(Blocks.STRIPPED_ACACIA_WOOD, Blocks.ACACIA_WOOD);
        strippedLogs.put(Blocks.STRIPPED_BIRCH_LOG, Blocks.BIRCH_LOG);
        strippedLogs.put(Blocks.STRIPPED_BIRCH_WOOD, Blocks.BIRCH_WOOD);
        strippedLogs.put(Blocks.STRIPPED_DARK_OAK_LOG, Blocks.DARK_OAK_LOG);
        strippedLogs.put(Blocks.STRIPPED_DARK_OAK_WOOD, Blocks.DARK_OAK_WOOD);
        strippedLogs.put(Blocks.STRIPPED_JUNGLE_LOG, Blocks.JUNGLE_LOG);
        strippedLogs.put(Blocks.STRIPPED_JUNGLE_WOOD, Blocks.JUNGLE_WOOD);
        strippedLogs.put(Blocks.STRIPPED_OAK_LOG, Blocks.OAK_LOG);
        strippedLogs.put(Blocks.STRIPPED_OAK_WOOD, Blocks.OAK_WOOD);
        strippedLogs.put(Blocks.STRIPPED_SPRUCE_LOG, Blocks.SPRUCE_LOG);
        strippedLogs.put(Blocks.STRIPPED_SPRUCE_WOOD, Blocks.SPRUCE_WOOD);
        strippedLogs.put(Blocks.STRIPPED_CHERRY_LOG, Blocks.CHERRY_LOG);
        strippedLogs.put(Blocks.STRIPPED_CHERRY_WOOD, Blocks.CHERRY_WOOD);
        strippedLogs.put(Blocks.STRIPPED_CRIMSON_HYPHAE, Blocks.CRIMSON_HYPHAE);
        strippedLogs.put(Blocks.STRIPPED_WARPED_HYPHAE, Blocks.WARPED_HYPHAE);
        strippedLogs.put(Blocks.STRIPPED_CRIMSON_STEM, Blocks.CRIMSON_STEM);
        strippedLogs.put(Blocks.STRIPPED_WARPED_STEM, Blocks.WARPED_STEM);
        strippedLogs.put(Blocks.STRIPPED_MANGROVE_LOG, Blocks.MANGROVE_LOG);
        strippedLogs.put(Blocks.STRIPPED_MANGROVE_WOOD, Blocks.MANGROVE_WOOD);
    }

    @Inject(at = @At("HEAD"), method = "useOn", cancellable = true)
    private void useOnLog(UseOnContext useOnContext, CallbackInfoReturnable<InteractionResult> info) {
        Level world = useOnContext.getLevel();
        BlockPos pos = useOnContext.getClickedPos();
        BlockState state = useOnContext.getLevel().getBlockState(pos);
        Block block = state.getBlock();
        if(strippedLogs.containsKey(block)){
            Block strippedBlock = strippedLogs.get(block);
            BlockState newState = strippedBlock.defaultBlockState().setValue(BlockStateProperties.AXIS, state.getValue(BlockStateProperties.AXIS));
            useOnContext.getLevel().setBlockAndUpdate(pos, newState);
            useOnContext.getLevel().playSound(null, pos, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1.0f, 1.0f);

            double[][] offsets = {
                    {1.1, 0.0, 0.0},
                    {-0.1, 0.0, 0.0},
                    {0.0, 1.1, 0.0},
                    {0.0, -0.1, 0.0},
                    {0.0, 0.0, 1.1},
                    {0.0, 0.0, -0.1}
            };
            for(double[] offset : offsets){
                int count = world.random.nextInt(1, 3);
                for(int i = 0; i < count; i++){
                double offsetX = offset[0] == 0.0 ? world.random.nextDouble() : offset[0];
                double offsetY = offset[1] == 0.0 ? world.random.nextDouble() : offset[1];
                double offsetZ = offset[2] == 0.0 ? world.random.nextDouble() : offset[2];
                world.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + offsetX, pos.getY() + offsetY, pos.getZ() + offsetZ, 0.0D, 0.0D, 0.0D);
                }
            }
            ItemStack stack = useOnContext.getItemInHand();
            stack.shrink(1);
            info.setReturnValue(InteractionResult.SUCCESS);
        }
    }
}
