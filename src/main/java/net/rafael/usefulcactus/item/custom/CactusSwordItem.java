package net.rafael.usefulcactus.item.custom;

import net.minecraft.client.MinecraftClient;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

public class CactusSwordItem extends SwordItem {
    public CactusSwordItem(ToolMaterial toolMaterial, Item.Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        MinecraftClient client = MinecraftClient.getInstance();
        World world = client.world;
        
        if (world != null && world.getBiome(world.getPlayerByUuid(world.getPlayerByUuid(world.getPlayers().get(0).getUuid()).getUuid()).getBlockPos()).isIn(BiomeTags.VILLAGE_DESERT_HAS_STRUCTURE)) {
            tooltip.add(Text.translatable("item.rafaels-useful-cactus.cactus_sword.tooltip.desert"));
            
            long timeOfDay = world.getTimeOfDay() % 24000;
            if (timeOfDay >= 6000 && timeOfDay <= 6500) {
                tooltip.add(Text.translatable("item.rafaels-useful-cactus.cactus_sword.tooltip.noon"));
            }
            else if (timeOfDay >= 0 && timeOfDay < 13000) {
                tooltip.add(Text.translatable("item.rafaels-useful-cactus.cactus_sword.tooltip.daytime"));
            }
        }
        
        tooltip.add(Text.translatable("item.rafaels-useful-cactus.cactus_sword.tooltip.thorn"));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
