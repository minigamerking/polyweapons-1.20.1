package net.mingamerking.polyweapons.item;

import eu.pb4.polymer.core.api.item.PolymerItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LifeStealSword extends SwordItem implements PolymerItem {
    private final Item item_type;

    public LifeStealSword(Item.Settings settings, Item type) {
        super(ToolMaterials.DIAMOND, 6, -2.4F, settings);
        this.item_type = type;
    }
    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return item_type;
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(Text.translatable("item.polyweapons.lifesteal_sword.tooltip"));
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity) {
            float previousHealth = target.getHealth();
            float damageDealt = previousHealth - target.getHealth();
            float healAmount = damageDealt / 4.0F;
            ((PlayerEntity) attacker).heal(healAmount);
        }
        return super.postHit(stack, target, attacker);
    }
}
