package net.rafael.usefulcactus.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.rafael.usefulcactus.block.ModBlocks;
import net.rafael.usefulcactus.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool cactusPlankPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CACTUS_PLANKS);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_CACTUS).log(ModBlocks.STRIPPED_CACTUS);

        cactusPlankPool.stairs(ModBlocks.CACTUS_STAIRS);
        cactusPlankPool.slab(ModBlocks.CACTUS_SLAB);

        cactusPlankPool.fence(ModBlocks.CACTUS_FENCE);
        cactusPlankPool.fenceGate(ModBlocks.CACTUS_FENCE_GATE);

        cactusPlankPool.button(ModBlocks.CACTUS_BUTTON);
        cactusPlankPool.pressurePlate(ModBlocks.CACTUS_PRESSURE_PLATE);

        blockStateModelGenerator.registerDoor(ModBlocks.CACTUS_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.CACTUS_TRAPDOOR);

        blockStateModelGenerator.registerLog(ModBlocks.DRIED_CACTUS).log(ModBlocks.DRIED_CACTUS);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // Items
        itemModelGenerator.register(ModItems.CACTUS_SKIN,Models.GENERATED);

        // Tools
        itemModelGenerator.register(ModItems.CACTUS_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CACTUS_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CACTUS_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CACTUS_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CACTUS_HOE, Models.HANDHELD);
    }
}
