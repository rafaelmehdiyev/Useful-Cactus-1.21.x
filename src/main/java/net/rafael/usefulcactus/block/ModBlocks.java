package net.rafael.usefulcactus.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;
import net.minecraft.block.ButtonBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.block.WoodType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.rafael.usefulcactus.RafaelsUsefulCactus;
import net.rafael.usefulcactus.block.custom.StrippedCactusBlock;

public class ModBlocks {
    public static final Block STRIPPED_CACTUS = registerBlock("stripped_cactus", new StrippedCactusBlock(
            AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, 
                            Identifier.of(RafaelsUsefulCactus.MOD_ID, "stripped_cactus")))
                    .strength(1f)));

    public static final Block DRIED_CACTUS = registerBlock("dried_cactus", new PillarBlock(
            AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, 
                            Identifier.of(RafaelsUsefulCactus.MOD_ID, "dried_cactus")))
                    .strength(1f)));

    public static final Block CACTUS_PLANKS = registerBlock("cactus_planks", 
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).registryKey(RegistryKey.of(RegistryKeys.BLOCK, 
                    Identifier.of(RafaelsUsefulCactus.MOD_ID, "cactus_planks")))));

    public static final Block CACTUS_STAIRS = registerBlock("cactus_stairs",
            new StairsBlock(ModBlocks.CACTUS_PLANKS.getDefaultState(), AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, 
                            Identifier.of(RafaelsUsefulCactus.MOD_ID, "cactus_stairs")))
                    .strength(2f).requiresTool()));

    public static final Block CACTUS_SLAB = registerBlock("cactus_slab",
            new SlabBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, 
                            Identifier.of(RafaelsUsefulCactus.MOD_ID, "cactus_slab")))
                    .strength(2f).requiresTool()));

    public static final Block CACTUS_BUTTON = registerBlock("cactus_button",
            new ButtonBlock(BlockSetType.IRON, 2, AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, 
                            Identifier.of(RafaelsUsefulCactus.MOD_ID, "cactus_button")))
                    .strength(2f).requiresTool().noCollision()));

    public static final Block CACTUS_PRESSURE_PLATE = registerBlock("cactus_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, 
                            Identifier.of(RafaelsUsefulCactus.MOD_ID, "cactus_pressure_plate")))
                    .strength(2f).requiresTool()));

    public static final Block CACTUS_FENCE = registerBlock("cactus_fence",
            new FenceBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, 
                            Identifier.of(RafaelsUsefulCactus.MOD_ID, "cactus_fence")))
                    .strength(2f).requiresTool()));

    public static final Block CACTUS_FENCE_GATE = registerBlock("cactus_fence_gate",
            new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, 
                            Identifier.of(RafaelsUsefulCactus.MOD_ID, "cactus_fence_gate")))
                    .strength(2f).requiresTool()));

    public static final Block CACTUS_DOOR = registerBlock("cactus_door",
            new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, 
                            Identifier.of(RafaelsUsefulCactus.MOD_ID, "cactus_door")))
                    .strength(2f).requiresTool().nonOpaque()));

    public static final Block CACTUS_TRAPDOOR = registerBlock("cactus_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, 
                            Identifier.of(RafaelsUsefulCactus.MOD_ID, "cactus_trapdoor")))
                    .strength(2f).requiresTool().nonOpaque()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(RafaelsUsefulCactus.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(RafaelsUsefulCactus.MOD_ID, name),
                new BlockItem(block, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RafaelsUsefulCactus.MOD_ID, name)))){
                        
                });
    }

    public static void registerModBlocks() {
        RafaelsUsefulCactus.LOGGER.info("Registering Mod Blocks for " + RafaelsUsefulCactus.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.STRIPPED_CACTUS);
            entries.add(ModBlocks.DRIED_CACTUS);
            entries.add(ModBlocks.CACTUS_PLANKS);
            entries.add(ModBlocks.CACTUS_STAIRS);
            entries.add(ModBlocks.CACTUS_SLAB);
            entries.add(ModBlocks.CACTUS_BUTTON);
            entries.add(ModBlocks.CACTUS_PRESSURE_PLATE);
            entries.add(ModBlocks.CACTUS_FENCE);
            entries.add(ModBlocks.CACTUS_FENCE_GATE);
            entries.add(ModBlocks.CACTUS_DOOR);
            entries.add(ModBlocks.CACTUS_TRAPDOOR);
        });
    }
}
