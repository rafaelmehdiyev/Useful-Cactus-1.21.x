package net.rafael.usefulcactus.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rafael.usefulcactus.RafaelsUsefulCactus;
import net.rafael.usefulcactus.item.custom.CactusHammerItem;
import net.rafael.usefulcactus.item.custom.CactusPickaxeItem;
import net.rafael.usefulcactus.item.custom.CactusSwordItem;
import net.rafael.usefulcactus.item.custom.ModArmorItem;

/**
 * This class defines and registers all custom items for the Rafael's Useful Cactus mod.
 * It includes cactus-based tools, armor, and other items.
 */
public class ModItems {

    // Basic Items
    public static final Item CACTUS_SKIN = registerItem("cactus_skin", new Item(new Item.Settings()));

    // Cactus Tool Items
    public static final Item CACTUS_SWORD = registerItem("cactus_sword",
            new CactusSwordItem(ModToolMaterial.CACTUS_SKIN,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(
                            ModToolMaterial.CACTUS_SKIN, 3, -2.6f))));

    public static final Item CACTUS_PICKAXE = registerItem("cactus_pickaxe", new CactusPickaxeItem(
            ModToolMaterial.CACTUS_SKIN, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
            ModToolMaterial.CACTUS_SKIN, 0.5f, -2.8f))));

    public static final Item CACTUS_AXE = registerItem("cactus_axe", new AxeItem(
            ModToolMaterial.CACTUS_SKIN, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(
            ModToolMaterial.CACTUS_SKIN, 6, -3.1f))));

    public static final Item CACTUS_SHOVEL = registerItem("cactus_shovel", new ShovelItem(
            ModToolMaterial.CACTUS_SKIN, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(
            ModToolMaterial.CACTUS_SKIN, 1f, -3.0f))));

    public static final Item CACTUS_HOE = registerItem("cactus_hoe", new HoeItem(
            ModToolMaterial.CACTUS_SKIN, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(
            ModToolMaterial.CACTUS_SKIN, -2, -3.0f))));

    public static final Item CACTUS_HAMMER = registerItem("cactus_hammer", new CactusHammerItem(
            ModToolMaterial.CACTUS_SKIN, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
            ModToolMaterial.CACTUS_SKIN, 4, -3.4f))));

    // Cactus Armor Items
    public static final Item CACTUS_HELMET = registerItem("cactus_helmet",
            new ModArmorItem(ModArmorMaterials.CACTUS_SKIN_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));

    public static final Item CACTUS_CHESTPLATE = registerItem("cactus_chestplate",
            new ArmorItem(ModArmorMaterials.CACTUS_SKIN_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));

    public static final Item CACTUS_LEGGINGS = registerItem("cactus_leggings",
            new ArmorItem(ModArmorMaterials.CACTUS_SKIN_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));

    public static final Item CACTUS_BOOTS = registerItem("cactus_boots",
            new ArmorItem(ModArmorMaterials.CACTUS_SKIN_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));

    /**
     * Registers an item with the game's item registry.
     * @param name The name (ID) of the item.
     * @param item The item instance to register.
     * @return The registered item.
     */
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(RafaelsUsefulCactus.MOD_ID, name), item);
    }

    /**
     * Registers all mod items and adds them to appropriate item groups.
     */
    public static void registerModItems() {
        RafaelsUsefulCactus.LOGGER.info("Registering Mod Items for " + RafaelsUsefulCactus.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.add(CACTUS_SKIN));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(CACTUS_SWORD);
            entries.add(CACTUS_HELMET);
            entries.add(CACTUS_CHESTPLATE);
            entries.add(CACTUS_LEGGINGS);
            entries.add(CACTUS_BOOTS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(CACTUS_PICKAXE);
            entries.add(CACTUS_AXE);
            entries.add(CACTUS_SHOVEL);
            entries.add(CACTUS_HOE);
            entries.add(CACTUS_HAMMER);
        });
    }
}