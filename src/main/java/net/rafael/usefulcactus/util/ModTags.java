package net.rafael.usefulcactus.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.rafael.usefulcactus.RafaelsUsefulCactus;

public class ModTags {

    public static class Blocks {

        public static final TagKey<Block> INCORRECT_FOR_CACTUS_TOOL = createTag("incorrect_for_cactus_tool");

        public static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(RafaelsUsefulCactus.MOD_ID, name));
        }
    }

    public static class Items{

        public static final TagKey<Item> CACTUS_REPAIR = createTag("cactus_repair");

        public static final TagKey<Item> createTag(String name){
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(RafaelsUsefulCactus.MOD_ID, name));
        }
    }
}
