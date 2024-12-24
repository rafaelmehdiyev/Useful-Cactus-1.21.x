package net.rafael.usefulcactus.item.custom;

import java.util.List;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.rafael.usefulcactus.client.CactusItemTooltips;

public class CactusSwordItem extends SwordItem {
    public CactusSwordItem(ToolMaterial toolMaterial,float attackDamage, float attackSpeed, Item.Settings settings) {
        super(toolMaterial,attackDamage,attackSpeed, settings);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (type == TooltipType.ADVANCED) {
            CactusItemTooltips.addCactusSwordTooltip(tooltip);
        }
        super.appendTooltip(stack, context, tooltip, type);
    }
}
