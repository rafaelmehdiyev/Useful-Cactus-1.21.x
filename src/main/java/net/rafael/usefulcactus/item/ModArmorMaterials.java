package net.rafael.usefulcactus.item;


import java.util.EnumMap;

import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Util;
import net.rafael.usefulcactus.util.ModTags;

public class ModArmorMaterials {

    public static final ArmorMaterial CACTUS_SKIN_ARMOR_MATERIAL = new ArmorMaterial(500,
    Util.make(new EnumMap<>(EquipmentType.class),map->{
                map.put(EquipmentType.BOOTS,2);
                map.put(EquipmentType.HELMET,4);
                map.put(EquipmentType.CHESTPLATE,6);
                map.put(EquipmentType.LEGGINGS,2);
                map.put(EquipmentType.BODY,4);
            }),20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,0,0,ModTags.Items.CACTUS_REPAIR,EquipmentAssetKeys.register("cactus_skin"));

}