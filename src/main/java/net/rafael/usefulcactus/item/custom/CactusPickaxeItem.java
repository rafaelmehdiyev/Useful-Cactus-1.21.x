package net.rafael.usefulcactus.item.custom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeKeys;
import net.rafael.usefulcactus.client.CactusItemTooltips;

import java.util.List;


public class CactusPickaxeItem extends PickaxeItem {
    public CactusPickaxeItem(ToolMaterial material, Item.Settings settings) {
        super(material, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (miner instanceof PlayerEntity player) {
            if (world.getBiome(player.getBlockPos()).matchesKey(BiomeKeys.DESERT)) {
                // 20% chance to not consume durability
                if (world.random.nextFloat() < 0.20f) {
                    return false;
                }
            }
        }
        return super.postMine(stack, world, state, pos, miner);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (type == TooltipType.ADVANCED) {
            CactusItemTooltips.addCactusPickaxeTooltip(tooltip);
        }
        super.appendTooltip(stack, context, tooltip, type);
    }
}
