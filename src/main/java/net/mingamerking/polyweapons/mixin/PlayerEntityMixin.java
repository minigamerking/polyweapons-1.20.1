package net.mingamerking.polyweapons.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.mingamerking.polyweapons.item.SpearItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin
{
    private ItemStack selectedItem;
    @Inject(method = "dropItem(Lnet/minecraft/item/ItemStack;ZZ)Lnet/minecraft/entity/ItemEntity;", at = @At("HEAD"), cancellable = true)
    private void dropItem(CallbackInfoReturnable info)
    {
        if(this.selectedItem.getItem() instanceof SpearItem)
        {
            ((SpearItem)this.selectedItem.getItem()).SetRange(false);
        }
    }
}
