package net.rafael.usefulcactus.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.HuskEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeKeys;
import net.rafael.usefulcactus.effect.ModEffects;
import net.rafael.usefulcactus.item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SwordItem.class)
public class CactusSwordMixin {

    @Inject(method = "postHit", at = @At("HEAD"))
    private void onPostHit(ItemStack stack, LivingEntity target, LivingEntity attacker, CallbackInfoReturnable<Boolean> cir) {
        if (!(stack.getItem() instanceof SwordItem) || stack.getItem() != ModItems.CACTUS_SWORD) {
            return;
        }

        World world = target.getWorld();
        BlockPos pos = target.getBlockPos();

        if (world.getBiome(pos).matchesKey(BiomeKeys.DESERT)) {
            applyTimeDamageBonus(world, target);
            applyDesertThornEffect(world, target);
            applyExtraDamageToHusks(target);
            applyBonusDamageOnSand(world, pos, target);
            reduceDurabilityLoss(world, stack);
        }
    }

    @Unique
    private void applyTimeDamageBonus(World world, LivingEntity target) {
        long timeOfDay = world.getTimeOfDay() % 24000;
        float bonus = 0;

        if (timeOfDay >= 0 && timeOfDay < 13000) {
            bonus = 1.0f;
            if (timeOfDay >= 6000 && timeOfDay <= 6500) {
                bonus = 2.0f;
            }
        }

        if (bonus > 0) {
            target.damage(target.getDamageSources().magic(), bonus);
        }
    }

    @Unique
    private void applyDesertThornEffect(World world, LivingEntity target) {
        if (world.getRandom().nextFloat() < 0.2f) {
            target.addStatusEffect(new StatusEffectInstance(ModEffects.DESERT_THORN, 200, 0, false, true, true));
        }
    }

    @Unique
    private void applyExtraDamageToHusks(LivingEntity target) {
        if (target instanceof HuskEntity) {
            target.damage(target.getDamageSources().magic(), 3.0f);
        }
    }

    @Unique
    private void applyBonusDamageOnSand(World world, BlockPos pos, LivingEntity target) {
        if (world.getBlockState(pos.down()).isIn(net.minecraft.registry.tag.BlockTags.SAND)) {
            target.damage(target.getDamageSources().magic(), 1.5f);
        }
    }

    @Unique
    private void reduceDurabilityLoss(World world, ItemStack stack) {
        if (world.getRandom().nextFloat() < 0.5f && stack.getDamage() > 0) {
            stack.setDamage(stack.getDamage() - 1);
        }
    }
}
