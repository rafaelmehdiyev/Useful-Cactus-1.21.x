package net.rafael.usefulcactus.item.custom;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class CactusHammerItem extends MiningToolItem {
    public CactusHammerItem(ToolMaterial material, float attackDamage, float attackSpeed, Item.Settings settings) {
        super(material, BlockTags.PICKAXE_MINEABLE, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("item.rafaels-useful-cactus.cactus_hammer.tooltip.area"));
        super.appendTooltip(stack, context, tooltip, type);
    }

    /**
     * Determines the blocks to be destroyed by the Cactus Hammer.
     *
     * @param range The range of blocks to consider around the initial block.
     * @param initialBlockPos The position of the block initially targeted.
     * @param player The player using the hammer.
     * @return A list of BlockPos representing the blocks to be destroyed.
     */
    public static List<BlockPos> getBlocksToBeDestroyed(int range, BlockPos initialBlockPos, ServerPlayerEntity player) {
        List<BlockPos> positions = new ArrayList<>();
        HitResult hit = player.raycast(20, 0, false);
        if (hit.getType() == HitResult.Type.BLOCK) {
            BlockHitResult blockHit = (BlockHitResult) hit;
            Direction side = blockHit.getSide();

            for (int x = -range; x <= range; x++) {
                for (int y = -range; y <= range; y++) {
                    if (side == Direction.DOWN || side == Direction.UP) {
                        positions.add(new BlockPos(initialBlockPos.getX() + x, initialBlockPos.getY(), initialBlockPos.getZ() + y));
                    } else if (side == Direction.NORTH || side == Direction.SOUTH) {
                        positions.add(new BlockPos(initialBlockPos.getX() + x, initialBlockPos.getY() + y, initialBlockPos.getZ()));
                    } else if (side == Direction.EAST || side == Direction.WEST) {
                        positions.add(new BlockPos(initialBlockPos.getX(), initialBlockPos.getY() + y, initialBlockPos.getZ() + x));
                    }
                }
            }
        }
        return positions;
    }
}
