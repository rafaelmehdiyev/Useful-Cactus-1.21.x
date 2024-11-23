package net.rafael.usefulcactus.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.rafael.usefulcactus.RafaelsUsefulCactus;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> DESERT_THORN = registerStatusEffect("desert_thorn", 
        new DesertThornEffect(
            StatusEffectCategory.HARMFUL,  // The effect is harmful
            0x8B4513  // Brown color for cactus thorn
        ));

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect effect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(RafaelsUsefulCactus.MOD_ID, name), effect);
    }

    public static void registerEffects() {
        RafaelsUsefulCactus.LOGGER.info("Registering ModEffects for " + RafaelsUsefulCactus.MOD_ID);
    }
}
