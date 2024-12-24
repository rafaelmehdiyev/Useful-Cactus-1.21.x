package net.rafael.usefulcactus.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

import java.util.List;

public class CactusItemTooltips {
    public static void addCactusSwordTooltip(List<Text> tooltip) {
        if (getBiomeAtPlayerPosition() != null && getBiomeAtPlayerPosition().matchesKey(BiomeKeys.DESERT))
        {
            World world = getWorld();
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

    public static void addCactusPickaxeTooltip(List<Text> tooltip) {
        if (getBiomeAtPlayerPosition() != null && getBiomeAtPlayerPosition().matchesKey(BiomeKeys.DESERT)) {
            World world = getWorld();
            tooltip.add(Text.translatable("item.rafaels-useful-cactus.cactus_pickaxe.tooltip.durability"));

            long timeOfDay = world.getTimeOfDay() % 24000;
            if (timeOfDay >= 6000 && timeOfDay <= 6500) {
                tooltip.add(Text.translatable("item.rafaels-useful-cactus.cactus_pickaxe.tooltip.noon"));
            }
        }
    }

    // For client-side using MinecraftClient instance
    private static RegistryEntry<Biome> getBiomeAtPlayerPosition() {
        MinecraftClient client = MinecraftClient.getInstance();
        BlockPos playerPos = client.player != null ? client.player.getBlockPos() : null;
        return getWorld().getBiome(playerPos);
    }

    private static World getWorld() {
        MinecraftClient client = MinecraftClient.getInstance();
        return client.world;
    }


}