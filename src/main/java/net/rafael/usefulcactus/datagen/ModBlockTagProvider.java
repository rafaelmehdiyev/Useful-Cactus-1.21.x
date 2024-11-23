package net.rafael.usefulcactus.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.rafael.usefulcactus.block.ModBlocks;
import net.rafael.usefulcactus.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.DRIED_CACTUS);

        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.CACTUS_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.CACTUS_FENCE_GATE);

        // Add blocks that cactus tools shouldn't be effective against
        getOrCreateTagBuilder(ModTags.Blocks.INCORRECT_FOR_CACTUS_TOOL)
                .add(net.minecraft.block.Blocks.OBSIDIAN)
                .add(net.minecraft.block.Blocks.CRYING_OBSIDIAN)
                .add(net.minecraft.block.Blocks.NETHERITE_BLOCK)
                .add(net.minecraft.block.Blocks.ANCIENT_DEBRIS)
                .add(net.minecraft.block.Blocks.REINFORCED_DEEPSLATE);
    }
}
