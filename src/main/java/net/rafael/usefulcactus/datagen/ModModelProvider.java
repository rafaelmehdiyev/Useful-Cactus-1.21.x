package net.rafael.usefulcactus.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.rafael.usefulcactus.block.ModBlocks;
import net.rafael.usefulcactus.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool cactusPlankPool = blockStateModelGenerator
                .registerCubeAllModelTexturePool(ModBlocks.CACTUS_PLANKS);
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
        itemModelGenerator.register(ModItems.CACTUS_SKIN, Models.GENERATED);

        // Tools
        itemModelGenerator.register(ModItems.CACTUS_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CACTUS_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CACTUS_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CACTUS_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CACTUS_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CACTUS_HAMMER, Models.HANDHELD);

        // Armor
        itemModelGenerator.registerArmor(ModItems.CACTUS_HELMET, EquipmentAssetKeys.register("cactus_skin"), "helmet", false);
        itemModelGenerator.registerArmor(ModItems.CACTUS_CHESTPLATE, EquipmentAssetKeys.register("cactus_skin"), "chestplate", false);
        itemModelGenerator.registerArmor(ModItems.CACTUS_LEGGINGS, EquipmentAssetKeys.register("cactus_skin"), "leggings", false);
        itemModelGenerator.registerArmor(ModItems.CACTUS_BOOTS, EquipmentAssetKeys.register("cactus_skin"), "boots", false);

        // itemModelGenerator.registerArmor(ModItems.CACTUS_HELMET,
        //         Identifier.of(RafaelsUsefulCactus.MOD_ID, "cactus_skin"), EquipmentModel.builder()
        //                 .addHumanoidLayers(Identifier.of(RafaelsUsefulCactus.MOD_ID, "cactus_skin")).build(),
        //         EquipmentSlot.HEAD);

        // itemModelGenerator.registerArmor(ModItems.CACTUS_CHESTPLATE,
        //         Identifier.of(RafaelsUsefulCactus.MOD_ID, "cactus_skin"), EquipmentModel.builder()
        //                 .addHumanoidLayers(Identifier.of(RafaelsUsefulCactus.MOD_ID, "cactus_skin")).build(),
        //         EquipmentSlot.CHEST);
        // itemModelGenerator.registerArmor(ModItems.CACTUS_LEGGINGS,
        //         Identifier.of(RafaelsUsefulCactus.MOD_ID, "cactus_skin"), EquipmentModel.builder()
        //                 .addHumanoidLayers(Identifier.of(RafaelsUsefulCactus.MOD_ID, "cactus_skin")).build(),
        //         EquipmentSlot.LEGS);
        // itemModelGenerator.registerArmor(ModItems.CACTUS_BOOTS,
        //         Identifier.of(RafaelsUsefulCactus.MOD_ID, "cactus_skin"), EquipmentModel.builder()
        //                 .addHumanoidLayers(Identifier.of(RafaelsUsefulCactus.MOD_ID, "cactus_skin")).build(),
        //         EquipmentSlot.FEET);
    }
}
