package com.slowertk.revertbark;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

public final class RevertBarkBlocks {
    private static final Map<Block, Block> STRIPPED_TO_LOG = Map.ofEntries(
            Map.entry(Blocks.STRIPPED_BAMBOO_BLOCK, Blocks.BAMBOO_BLOCK),
            Map.entry(Blocks.STRIPPED_ACACIA_LOG, Blocks.ACACIA_LOG),
            Map.entry(Blocks.STRIPPED_ACACIA_WOOD, Blocks.ACACIA_WOOD),
            Map.entry(Blocks.STRIPPED_BIRCH_LOG, Blocks.BIRCH_LOG),
            Map.entry(Blocks.STRIPPED_BIRCH_WOOD, Blocks.BIRCH_WOOD),
            Map.entry(Blocks.STRIPPED_DARK_OAK_LOG, Blocks.DARK_OAK_LOG),
            Map.entry(Blocks.STRIPPED_DARK_OAK_WOOD, Blocks.DARK_OAK_WOOD),
            Map.entry(Blocks.STRIPPED_JUNGLE_LOG, Blocks.JUNGLE_LOG),
            Map.entry(Blocks.STRIPPED_JUNGLE_WOOD, Blocks.JUNGLE_WOOD),
            Map.entry(Blocks.STRIPPED_OAK_LOG, Blocks.OAK_LOG),
            Map.entry(Blocks.STRIPPED_OAK_WOOD, Blocks.OAK_WOOD),
            Map.entry(Blocks.STRIPPED_SPRUCE_LOG, Blocks.SPRUCE_LOG),
            Map.entry(Blocks.STRIPPED_SPRUCE_WOOD, Blocks.SPRUCE_WOOD),
            Map.entry(Blocks.STRIPPED_CHERRY_LOG, Blocks.CHERRY_LOG),
            Map.entry(Blocks.STRIPPED_CHERRY_WOOD, Blocks.CHERRY_WOOD),
            Map.entry(Blocks.STRIPPED_CRIMSON_HYPHAE, Blocks.CRIMSON_HYPHAE),
            Map.entry(Blocks.STRIPPED_WARPED_HYPHAE, Blocks.WARPED_HYPHAE),
            Map.entry(Blocks.STRIPPED_CRIMSON_STEM, Blocks.CRIMSON_STEM),
            Map.entry(Blocks.STRIPPED_WARPED_STEM, Blocks.WARPED_STEM),
            Map.entry(Blocks.STRIPPED_MANGROVE_LOG, Blocks.MANGROVE_LOG),
            Map.entry(Blocks.STRIPPED_MANGROVE_WOOD, Blocks.MANGROVE_WOOD)
    );

    private RevertBarkBlocks() {
    }

    public static Block getLog(Block strippedBlock) {
        return STRIPPED_TO_LOG.get(strippedBlock);
    }
    public static int getNumberOfLogs() {return STRIPPED_TO_LOG.size();}
}
