package net.rafael.usefulcactus.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.rafael.usefulcactus.item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class CactusPickaxeMixin {
    
    @Inject(method = "getMiningSpeed", at = @At("HEAD"), cancellable = true)
    private void onGetMiningSpeed(ItemStack stack, BlockState state, CallbackInfoReturnable<Float> cir) {
        if (!(stack.getItem() instanceof PickaxeItem) || stack.getItem() != ModItems.CACTUS_PICKAXE) {
            return;
        }

        PlayerEntity player = ((PlayerEntity)(Object)this);
        World world = player.getWorld();
        
        if (world.getBiome(player.getBlockPos()).isIn(BiomeTags.VILLAGE_DESERT_HAS_STRUCTURE)) {
            float originalSpeed = cir.getReturnValue();
            cir.setReturnValue(originalSpeed * 1.25f); // 25% faster in deserts
        }
    }

}