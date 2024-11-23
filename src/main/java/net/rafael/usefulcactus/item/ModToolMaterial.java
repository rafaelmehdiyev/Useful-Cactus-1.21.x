package net.rafael.usefulcactus.item;

import java.util.function.Supplier;

import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;
import net.rafael.usefulcactus.util.ModTags;

public enum ModToolMaterial implements ToolMaterial {
    
    CACTUS_SKIN(ModTags.Blocks.INCORRECT_FOR_CACTUS_TOOL,
                250,
                6.0F,
                2.0F,
                14,
                () -> Ingredient.ofItems(ModItems.CACTUS_SKIN));


    private ModToolMaterial(TagKey<Block> inverseTag, int itemDurability, float miningSpeed, float attackDamage,
            int enchantability, Supplier<Ingredient> repairIngredient) {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return (Ingredient) this.repairIngredient.get();
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return this.inverseTag;
    }
}
