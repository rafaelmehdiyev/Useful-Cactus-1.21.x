package net.rafael.usefulcactus.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;

public class DesertThornEffect extends StatusEffect {
    protected DesertThornEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // Apply damage every 40 ticks (2 seconds)
        return duration % 40 == 0;
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        if (!entity.getWorld().isClient()) {
            // Apply damage
            entity.damage(world,entity.getDamageSources().magic(), 2f);
            
            // Spawn cactus break particles
            ServerWorld serverWorld = (ServerWorld) entity.getWorld();
            serverWorld.spawnParticles(
                ParticleTypes.ITEM_SLIME,
                entity.getX(),
                entity.getY() + 1,
                entity.getZ(),
                5, // particle count
                0.2, // spread X
                0.2, // spread Y
                0.2, // spread Z
                0.1 // speed
            );
            return true;
        }
        return super.applyUpdateEffect(world,entity, amplifier);
    }
}
