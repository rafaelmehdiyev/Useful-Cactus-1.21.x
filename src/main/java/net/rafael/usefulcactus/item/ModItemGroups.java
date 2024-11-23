package net.rafael.usefulcactus.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.rafael.usefulcactus.RafaelsUsefulCactus;
import net.rafael.usefulcactus.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup USEFUL_CACTUS_ITEM_GROUPS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(RafaelsUsefulCactus.MOD_ID,"useful_cactus_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.CACTUS_SKIN))
                    .displayName(Text.translatable("itemgroup.useful_cactus.useful_cactus_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.CACTUS_SKIN);
                        entries.add(ModItems.CACTUS_SWORD);
                        entries.add(ModItems.CACTUS_PICKAXE);
                        entries.add(ModItems.CACTUS_AXE);
                        entries.add(ModItems.CACTUS_SHOVEL);
                        entries.add(ModItems.CACTUS_HOE);
                    })
                    .build());

    public static final ItemGroup USEFUL_CACTUS_BLOCK_GROUPS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(RafaelsUsefulCactus.MOD_ID,"useful_cactus_blocks"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.STRIPPED_CACTUS))
                    .displayName(Text.translatable("itemgroup.useful_cactus.useful_cactus_blocks"))
                    .entries((displayContext, entries) -> {
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

                    })
                    .build());

    public static void registerItemGroups() {
        RafaelsUsefulCactus.LOGGER.info("Registering Item Groups for "+RafaelsUsefulCactus.MOD_ID);
    }
}
