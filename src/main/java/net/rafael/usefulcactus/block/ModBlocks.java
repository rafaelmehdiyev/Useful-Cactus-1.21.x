package net.rafael.usefulcactus.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rafael.usefulcactus.RafaelsUsefulCactus;

public class ModBlocks {

    public static final Block STRIPPED_CACTUS = registerBlock("stripped_cactus",new PillarBlock(
            AbstractBlock.Settings.create().strength(1f)
    ));

    public static final Block DRIED_CACTUS = registerBlock("dried_cactus",new PillarBlock(
            AbstractBlock.Settings.copy(Blocks.OAK_LOG)
    ));

    public static final Block CACTUS_PLANKS = registerBlock("cactus_planks",new Block(
            AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)
    ));

    public static Block CACTUS_STAIRS = registerBlock("cactus_stairs",
            new StairsBlock(ModBlocks.CACTUS_PLANKS.getDefaultState(),
                    AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static Block CACTUS_SLAB = registerBlock("cactus_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static Block CACTUS_BUTTON = registerBlock("cactus_button",
            new ButtonBlock(BlockSetType.IRON, 2,
                    AbstractBlock.Settings.create().strength(2f).requiresTool().noCollision()));
    public static Block CACTUS_PRESSURE_PLATE = registerBlock("cactus_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON,
                    AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static Block CACTUS_FENCE = registerBlock("cactus_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static Block CACTUS_FENCE_GATE = registerBlock("cactus_fence_gate",
            new FenceGateBlock(WoodType.OAK,AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static Block CACTUS_DOOR = registerBlock("cactus_door",
            new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));
    public static Block CACTUS_TRAPDOOR = registerBlock("cactus_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK,AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(RafaelsUsefulCactus.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(RafaelsUsefulCactus.MOD_ID, name),
                new BlockItem(block,new Item.Settings()));
    }


    public static void registerModBlocks() {
        RafaelsUsefulCactus.LOGGER.info("Registering Mod Blocks for "+ RafaelsUsefulCactus.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries->{
            entries.add(ModBlocks.STRIPPED_CACTUS);
            entries.add(ModBlocks.DRIED_CACTUS);
        });
    }
}
