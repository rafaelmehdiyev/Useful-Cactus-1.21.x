package net.rafael.usefulcactus.mixin;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.CactusBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.rafael.usefulcactus.block.ModBlocks;
import net.rafael.usefulcactus.item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractBlock.class)
public class CactusBlockMixin {

    @Inject(at = @At("HEAD"), method = "onUse", cancellable = true)
private void onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit, CallbackInfoReturnable<ActionResult> cir) {
    if (!world.isClient && state.getBlock() instanceof CactusBlock) {
        ItemStack cactusSkin = new ItemStack(ModItems.CACTUS_SKIN);
        player.getInventory().insertStack(cactusSkin);
        player.damage(world.getDamageSources().cactus(), 2.0F);
        world.setBlockState(pos, ModBlocks.STRIPPED_CACTUS.getDefaultState());
        world.playSound(null, pos, SoundEvents.BLOCK_CROP_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
        cir.setReturnValue(ActionResult.SUCCESS);
        return;
    }
    cir.setReturnValue(ActionResult.PASS);
}
}