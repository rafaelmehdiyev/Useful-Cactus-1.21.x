package net.rafael.usefulcactus.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.HuskEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.rafael.usefulcactus.effect.ModEffects;
import net.rafael.usefulcactus.item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
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
        
        if (world.getBiome(pos).isIn(BiomeTags.VILLAGE_DESERT_HAS_STRUCTURE)) {
            // Time-based damage bonus
            long timeOfDay = world.getTimeOfDay() % 24000;
            float bonus = 0;
            
            if (timeOfDay >= 0 && timeOfDay < 13000) { // Daytime
                bonus = 1.0f;
                if (timeOfDay >= 6000 && timeOfDay <= 6500) { // Noon
                    bonus = 2.0f;
                }
            }
            
            // Apply bonus damage
            if (bonus > 0) {
                target.damage(target.getDamageSources().magic(), bonus);
            }
            
            // Desert Thorn effect (20% chance)
if (world.getRandom().nextFloat() < 0.2f) {
    target.addStatusEffect(new StatusEffectInstance(
    ModEffects.DESERT_THORN,  // The effect to apply
    200,                      // Duration (10 seconds)
    0,                        // Amplifier (level 0)
    false,                    // Ambient
    true,                     // Show particles
    true                      // Show icon
));
}
            
            // Extra damage against Husks
            if (target instanceof HuskEntity) {
                target.damage(target.getDamageSources().magic(), 3.0f); // +3 damage
            }
            
            // Bonus damage on sand
            if (world.getBlockState(pos.down()).isIn(net.minecraft.registry.tag.BlockTags.SAND)) {
                target.damage(target.getDamageSources().magic(), 1.5f);
            }
            
            // Reduce durability loss in desert (50% chance to not take damage)
            if (world.getRandom().nextFloat() < 0.5f && stack.getDamage() > 0) {
                stack.setDamage(stack.getDamage() - 1);
            }
        }
    }
}
