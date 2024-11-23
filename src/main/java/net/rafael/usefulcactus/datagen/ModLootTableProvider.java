package net.rafael.usefulcactus.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;
import net.rafael.usefulcactus.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.STRIPPED_CACTUS);
        addDrop(ModBlocks.DRIED_CACTUS);
        addDrop(ModBlocks.CACTUS_PLANKS);

        addDrop(ModBlocks.CACTUS_STAIRS);
        addDrop(ModBlocks.CACTUS_SLAB,slabDrops(ModBlocks.CACTUS_SLAB));

        addDrop(ModBlocks.CACTUS_BUTTON);
        addDrop(ModBlocks.CACTUS_PRESSURE_PLATE);

        addDrop(ModBlocks.CACTUS_FENCE);
        addDrop(ModBlocks.CACTUS_FENCE_GATE);

        addDrop(ModBlocks.CACTUS_DOOR,doorDrops(ModBlocks.CACTUS_DOOR));
        addDrop(ModBlocks.CACTUS_TRAPDOOR);
    }
}
