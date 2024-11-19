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
//                    .icon(() -> new ItemStack(ModItems.))
                    .displayName(Text.translatable("itemgroup.useful_cactus.useful_cactus_items"))
                    .entries((displayContext, entries) -> {

                    })
                    .build());

    public static final ItemGroup USEFUL_CACTUS_BLOCK_GROUPS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(RafaelsUsefulCactus.MOD_ID,"useful_cactus_blocks"),
            FabricItemGroup.builder()
//                    .icon(() -> new ItemStack(ModBlocks.))
                    .displayName(Text.translatable("itemgroup.useful_cactus.useful_cactus_blocks"))
                    .entries((displayContext, entries) -> {

                    })
                    .build());

    public static void registerItemGroups() {
        RafaelsUsefulCactus.LOGGER.info("Registering Item Groups for "+RafaelsUsefulCactus.MOD_ID);
    }
}
