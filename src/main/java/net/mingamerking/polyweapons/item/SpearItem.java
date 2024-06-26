package net.mingamerking.polyweapons.item;

import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import eu.pb4.polymer.core.api.item.PolymerItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.math.random.RandomSplitter;
import net.minecraft.world.World;
import net.mingamerking.polyweapons.polymer.PolymerTextures;
import org.jetbrains.annotations.Nullable;

import java.awt.*;

public class SpearItem extends SwordItem implements PolymerItem {

    private static LivingEntity liver = null;
    private final Item item_type;
    private final int damage;
    boolean active = false;

    public SpearItem(Item.Settings settings, int damage, ToolMaterial material, Item type) {

        super(material, damage, -2.4f, settings);
        this.item_type = type;
        this.damage = damage;
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return item_type;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (active != (((LivingEntity)entity).getStackInHand(Hand.MAIN_HAND).getItem() == this)) {
            liver = (LivingEntity)entity;
            SetRange(((LivingEntity)entity).getStackInHand(Hand.MAIN_HAND).getItem() == this);
        }
        active = ((LivingEntity)entity).getStackInHand(Hand.MAIN_HAND).getItem() == this;
    }

    public void SetRange(boolean change_range)
    {
        if (change_range)
        {
            liver.getAttributeInstance(ReachEntityAttributes.REACH).setBaseValue(2.0);
            liver.getAttributeInstance(ReachEntityAttributes.ATTACK_RANGE).setBaseValue(2.0);
        }
        else
        {
            liver.getAttributeInstance(ReachEntityAttributes.REACH).setBaseValue(0.0);
            liver.getAttributeInstance(ReachEntityAttributes.ATTACK_RANGE).setBaseValue(0.0);
        }
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {return PolymerTextures.MODELS.get(this).value();}

    @Override
    public Text getName(ItemStack stack) {
        return Text.translatable(this.getTranslationKey());
    }
}
