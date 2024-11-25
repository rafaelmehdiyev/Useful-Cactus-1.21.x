package net.rafael.usefulcactus.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jetbrains.annotations.Nullable;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.rafael.usefulcactus.item.custom.CactusHammerItem;

public class CactusHammerUsageEvent implements PlayerBlockBreakEvents.Before {
    // Good use of a HashSet for tracking hammered blocks to prevent recursion
    private static final Set<BlockPos> HAMMERED_BLOCKS = new HashSet<>();

    @Override
    public boolean beforeBlockBreak(World world, PlayerEntity player, BlockPos blockPos, 
            BlockState blockState, @Nullable BlockEntity blockEntity) {
        ItemStack mainHandItem = player.getMainHandStack();
        
        // Good pattern matching with instanceof
        if (mainHandItem.getItem() instanceof CactusHammerItem && 
                player instanceof ServerPlayerEntity serverPlayer) {
            
            // Recursion prevention
            if (HAMMERED_BLOCKS.contains(blockPos)) return true;

            // Get blocks in 3x3 pattern
            List<BlockPos> blocksToDestroy = CactusHammerItem.getBlocksToBeDestroyed(1, blockPos, serverPlayer);

            for (BlockPos pos : blocksToDestroy) {
                if (blockPos.equals(pos)) continue;

                BlockState targetState = world.getBlockState(pos);
                
                // Good safety check for unbreakable blocks
                if (targetState.getHardness(world, pos) < 0) continue;

                HAMMERED_BLOCKS.add(pos);
                serverPlayer.interactionManager.tryBreakBlock(pos);
                HAMMERED_BLOCKS.remove(pos);
            }
        }
        return true;
    }
}