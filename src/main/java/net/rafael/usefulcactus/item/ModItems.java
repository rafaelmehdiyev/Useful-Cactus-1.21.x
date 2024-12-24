package net.rafael.usefulcactus.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
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
    public static final Item CACTUS_SKIN = registerItem("cactus_skin", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RafaelsUsefulCactus.MOD_ID, "cactus_skin")))));

    // Cactus Tool Items

    // Damange 0 -> 3
    // | Attack Speed | Value |
// |--------------|-------|
// | 0            | 4     |
// | -1           | 3     |
// | -2           | 2     |
// | -3           | 1     |
// | -4           | 0     |


    // Cactus Sword: 6 attack damage, 1.6 attack speed
    public static final Item CACTUS_SWORD = registerItem("cactus_sword",
            new CactusSwordItem(ModToolMaterial.CACTUS_SKIN,3f, -2.6f,new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RafaelsUsefulCactus.MOD_ID, "cactus_sword")))));

    // Cactus Pickaxe: 4 attack damage, 1.2 attack speed
    public static final Item CACTUS_PICKAXE = registerItem("cactus_pickaxe", new CactusPickaxeItem(
            ModToolMaterial.CACTUS_SKIN,0.5f, -2.8f, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RafaelsUsefulCactus.MOD_ID, "cactus_pickaxe")))));

    // Cactus Axe: 9 attack damage, 0.9 attack speed
    public static final Item CACTUS_AXE = registerItem("cactus_axe", new AxeItem(
            ModToolMaterial.CACTUS_SKIN,6, -3.1f, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RafaelsUsefulCactus.MOD_ID, "cactus_axe")))));

    // Cactus Shovel: 4 attack damage, 1.0 attack speed
    public static final Item CACTUS_SHOVEL = registerItem("cactus_shovel", new ShovelItem(
            ModToolMaterial.CACTUS_SKIN,1f, -3.0f, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RafaelsUsefulCactus.MOD_ID, "cactus_shovel")))));

    // Cactus Hoe: 1 attack damage, 1.0 attack speed
    public static final Item CACTUS_HOE = registerItem("cactus_hoe", new HoeItem(
            ModToolMaterial.CACTUS_SKIN,-2, -3.0f, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RafaelsUsefulCactus.MOD_ID, "cactus_hoe")))));

    // Cactus Hammer: 7 attack damage, 0.6 attack speed
    public static final Item CACTUS_HAMMER = registerItem("cactus_hammer", new CactusHammerItem(
            ModToolMaterial.CACTUS_SKIN,4, -3.4f, new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RafaelsUsefulCactus.MOD_ID, "cactus_hammer")))));

    // Cactus Armor Items
    public static final Item CACTUS_HELMET = registerItem("cactus_helmet",
            new ModArmorItem(ModArmorMaterials.CACTUS_SKIN_ARMOR_MATERIAL, EquipmentType.HELMET,
                    new Item.Settings()
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RafaelsUsefulCactus.MOD_ID, "cactus_helmet")))));

    public static final Item CACTUS_CHESTPLATE = registerItem("cactus_chestplate",
            new ArmorItem(ModArmorMaterials.CACTUS_SKIN_ARMOR_MATERIAL, EquipmentType.CHESTPLATE,
                    new Item.Settings()
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RafaelsUsefulCactus.MOD_ID, "cactus_chestplate")))));

    public static final Item CACTUS_LEGGINGS = registerItem("cactus_leggings",
            new ArmorItem(ModArmorMaterials.CACTUS_SKIN_ARMOR_MATERIAL, EquipmentType.LEGGINGS,
                    new Item.Settings()
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RafaelsUsefulCactus.MOD_ID, "cactus_leggings")))));

    public static final Item CACTUS_BOOTS = registerItem("cactus_boots",
            new ArmorItem(ModArmorMaterials.CACTUS_SKIN_ARMOR_MATERIAL, EquipmentType.BOOTS,
                    new Item.Settings()
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RafaelsUsefulCactus.MOD_ID, "cactus_boots")))));

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