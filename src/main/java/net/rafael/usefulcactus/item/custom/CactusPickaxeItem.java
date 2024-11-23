package net.rafael.usefulcactus.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;

import java.util.List;


public class CactusPickaxeItem extends PickaxeItem {
    public CactusPickaxeItem(ToolMaterial material, Item.Settings settings) {
        super(material, settings);
    }


@Override
public float getMiningSpeed(ItemStack stack, BlockState state) {
    World world = MinecraftClient.getInstance().world;
    PlayerEntity player = MinecraftClient.getInstance().player;
    
    if (world != null && player != null) {
        if (world.getBiome(player.getBlockPos()).isIn(BiomeTags.VILLAGE_DESERT_HAS_STRUCTURE)) {
            return super.getMiningSpeed(stack, state) * 1.25F; // 25% faster in deserts
        }
    }
    
    return super.getMiningSpeed(stack, state);
}
    
@Override
public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
    if (miner instanceof PlayerEntity player) {
        if (world.getBiome(player.getBlockPos()).isIn(BiomeTags.VILLAGE_DESERT_HAS_STRUCTURE)) {
            // 20% chance to not consume durability
            if (world.random.nextFloat() < 0.20f) {
                return false;
            }
        }
    }
    return super.postMine(stack, world, state, pos, miner);
}

@Override
public int getEnchantability() {
    World world = MinecraftClient.getInstance().world;
    PlayerEntity player = MinecraftClient.getInstance().player;
    
    if (world != null && player != null) {
        if (world.getBiome(player.getBlockPos()).isIn(BiomeTags.VILLAGE_DESERT_HAS_STRUCTURE)) {
            return super.getEnchantability() + 1;
        }
    }
    return super.getEnchantability();
}

@Override
public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
    MinecraftClient client = MinecraftClient.getInstance();
    World world = client.world;
    
    if (world != null && world.getBiome(client.player.getBlockPos()).isIn(BiomeTags.VILLAGE_DESERT_HAS_STRUCTURE)) {
        tooltip.add(Text.translatable("item.rafaels-useful-cactus.cactus_pickaxe.tooltip.desert"));
        tooltip.add(Text.translatable("item.rafaels-useful-cactus.cactus_pickaxe.tooltip.durability"));
        
        long timeOfDay = world.getTimeOfDay() % 24000;
        if (timeOfDay >= 6000 && timeOfDay <= 6500) {
            tooltip.add(Text.translatable("item.rafaels-useful-cactus.cactus_pickaxe.tooltip.noon"));
        } else if (timeOfDay >= 0 && timeOfDay < 13000) {
            tooltip.add(Text.translatable("item.rafaels-useful-cactus.cactus_pickaxe.tooltip.daytime"));
        }
    }
    
    super.appendTooltip(stack, context, tooltip, type);
}
}
