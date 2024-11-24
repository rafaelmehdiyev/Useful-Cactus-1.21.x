package net.rafael.usefulcactus.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

@Environment(EnvType.CLIENT)
public class CactusItemTooltips {
    public static void addCactusSwordTooltip(ItemStack stack, World world, List<Text> tooltip) {
        if (world != null && world.getBiome(world.getPlayerByUuid(world.getPlayers().get(0).getUuid()).getBlockPos())
                .isIn(BiomeTags.VILLAGE_DESERT_HAS_STRUCTURE)) {
            tooltip.add(Text.translatable("item.rafaels-useful-cactus.cactus_sword.tooltip.desert"));
            
            long timeOfDay = world.getTimeOfDay() % 24000;
            if (timeOfDay >= 6000 && timeOfDay <= 6500) {
                tooltip.add(Text.translatable("item.rafaels-useful-cactus.cactus_sword.tooltip.noon"));
            } else if (timeOfDay >= 0 && timeOfDay < 13000) {
                tooltip.add(Text.translatable("item.rafaels-useful-cactus.cactus_sword.tooltip.daytime"));
            }
        }
        tooltip.add(Text.translatable("item.rafaels-useful-cactus.cactus_sword.tooltip.thorn"));
    }

    public static void addCactusPickaxeTooltip(ItemStack stack, World world, List<Text> tooltip) {
        if (world != null && world.getBiome(world.getPlayerByUuid(world.getPlayers().get(0).getUuid()).getBlockPos())
                .isIn(BiomeTags.VILLAGE_DESERT_HAS_STRUCTURE)) {
            tooltip.add(Text.translatable("item.rafaels-useful-cactus.cactus_pickaxe.tooltip.desert"));
            tooltip.add(Text.translatable("item.rafaels-useful-cactus.cactus_pickaxe.tooltip.durability"));
            
            long timeOfDay = world.getTimeOfDay() % 24000;
            if (timeOfDay >= 6000 && timeOfDay <= 6500) {
                tooltip.add(Text.translatable("item.rafaels-useful-cactus.cactus_pickaxe.tooltip.noon"));
            } else if (timeOfDay >= 0 && timeOfDay < 13000) {
                tooltip.add(Text.translatable("item.rafaels-useful-cactus.cactus_pickaxe.tooltip.daytime"));
            }
        }
    }
}