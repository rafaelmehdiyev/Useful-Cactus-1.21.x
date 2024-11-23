package net.rafael.usefulcactus.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.rafael.usefulcactus.block.ModBlocks;

public class StrippedCactusBlock extends PillarBlock {
    public StrippedCactusBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        world.setBlockState(pos, ModBlocks.DRIED_CACTUS.getDefaultState());
        world.playSound(null, pos, SoundEvents.BLOCK_WOOD_BREAK, SoundCategory.BLOCKS, 0.3F, 1.5F);
    }
}
