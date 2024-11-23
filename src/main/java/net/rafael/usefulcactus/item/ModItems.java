package net.rafael.usefulcactus.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rafael.usefulcactus.RafaelsUsefulCactus;

public class ModItems {

    // Items
    public static final Item CACTUS_SKIN = registerItem("cactus_skin", new Item(new Item.Settings()));

    // Tool Items
    public static final Item CACTUS_SWORD = registerItem("cactus_sword",
        new SwordItem(ModToolMaterial.CACTUS_SKIN, 
        new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(
            ModToolMaterial.CACTUS_SKIN, 3,-2.4f))));
    
    public static final Item CACTUS_PICKAXE = registerItem("cactus_pickaxe", new PickaxeItem(
        ModToolMaterial.CACTUS_SKIN, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
            ModToolMaterial.CACTUS_SKIN, 1,-2.0f))));
    
    public static final Item CACTUS_AXE = registerItem("cactus_axe", new AxeItem(
        ModToolMaterial.CACTUS_SKIN, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(
            ModToolMaterial.CACTUS_SKIN, 6,-3.2f))));
    
    public static final Item CACTUS_SHOVEL = registerItem("cactus_shovel", new ShovelItem(
        ModToolMaterial.CACTUS_SKIN, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(
            ModToolMaterial.CACTUS_SKIN, 1.5f,-3.0f))));

    public static final Item CACTUS_HOE = registerItem("cactus_hoe", new HoeItem(
        ModToolMaterial.CACTUS_SKIN, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(
            ModToolMaterial.CACTUS_SKIN, -2,-1.0f))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(RafaelsUsefulCactus.MOD_ID, name), item);
    }

    public static void registerModItems() {
        RafaelsUsefulCactus.LOGGER.info("Registering Mod Items for " + RafaelsUsefulCactus.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(CACTUS_SKIN);
        });

        // Add tools to combat group
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(CACTUS_SWORD);
        });

        // Add tools to tools group
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(CACTUS_PICKAXE);
            entries.add(CACTUS_AXE);
            entries.add(CACTUS_SHOVEL);
            entries.add(CACTUS_HOE);
        });
    }
}
