package net.rafael.usefulcactus.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.rafael.usefulcactus.block.ModBlocks;
import net.rafael.usefulcactus.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.CACTUS_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.DRIED_CACTUS.asItem());

                // Add tools to appropriate vanilla tags
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.CACTUS_SWORD);

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.CACTUS_PICKAXE);

        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.CACTUS_AXE);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.CACTUS_SHOVEL);

        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.CACTUS_HOE);
    }
}
